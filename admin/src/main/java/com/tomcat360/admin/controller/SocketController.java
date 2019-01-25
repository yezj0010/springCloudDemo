package com.tomcat360.admin.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tomcat360.admin.aspect.AdminLog;
import com.tomcat360.admin.constant.AdminConstant;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.SocketData;
import com.tomcat360.admin.model.SocketServer;
import com.tomcat360.admin.model.TbEquipmentSettings;
import com.tomcat360.admin.properties.AppProperties;
import com.tomcat360.admin.service.TbEquipmentService;
import com.tomcat360.admin.service.TbEquipmentSettingsService;
import com.tomcat360.admin.service.VersionSendService;
import com.tomcat360.admin.util.FileUtil;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/auth")
public class SocketController {
	@Autowired
	private VersionSendService versionSendService;
	@Autowired
	private TbEquipmentService tbEquipmentService;
	@Autowired
	private TbEquipmentSettingsService tbEquipmentSettingsService;
	@Autowired
	private AppProperties appProperties;

	@AdminLog(interfaceCode = "/auth/startSocket", interfaceDesc = "开启远程控制")
	@ApiOperation(value = "开启远程控制", httpMethod = "POST")
	@RequestMapping("/startSocket")
	public JSONData startSocket(HttpServletRequest request) throws Exception {
		if (SocketServer.server != null) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_SOCKKET_IS_START.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_SOCKKET_IS_START.getCode()).build();
		}

		SocketServer.startServer();

		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).build();
	}

	@AdminLog(interfaceCode = "/auth/stopSocket", interfaceDesc = "关闭远程控制")
	@ApiOperation(value = "关闭远程控制", httpMethod = "POST")
	@RequestMapping("/stopSocket")
	public JSONData stopSocket(HttpServletRequest request) throws Exception {
		if (SocketServer.server != null) {
			SocketServer.stopServer();
		} else {
			log.info("socketServer已经关闭，不需要重复关闭");
		}

		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).build();
	}

	//@AdminLog(interfaceCode = "/auth/querySocketList", interfaceDesc = "获取远程控制列表")
	@ApiOperation(value = "获取远程控制列表", httpMethod = "POST")
	@RequestMapping("/querySocketList")
	public JSONData querySocketList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, String country, String brand,
			String equipmentVersion, String equipmentId, String status, String softVersion, HttpServletRequest request)
			throws Exception {
		// 当前建立连接的设备的设备编号列表
		Set<String> termNoList = SocketServer.clients.keySet();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("termNoList", termNoList);
		params.put("country", country == null ? null : country.trim().replaceAll("/n", ""));
		params.put("brand", brand);
		params.put("equipmentVersion", equipmentVersion);
		params.put("equipmentId", equipmentId);
		params.put("status", status);
		params.put("softVersion", softVersion);
		params.put("page", page);
		params.put("size", size);
		return tbEquipmentService.findAllByEquipmentIds(params);
	}

	/**
	 * 抓取ATM日志，给ATM设备程序 写入1，表示抓取日志
	 *
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@AdminLog(interfaceCode = "/auth/getATMLog", interfaceDesc = "获取ATM日志")
	@ApiOperation(value = "获取ATM日志", httpMethod = "POST")
	@RequestMapping("/getATMLog")
	public JSONData getATMLog(HttpServletRequest request) {

		String id = request.getParameter("id");
		String firstTime = request.getParameter("firstTime");
		String endTime = request.getParameter("endTime");
		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(firstTime) || StringUtils.isEmpty(endTime)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}

		firstTime = firstTime.replaceAll("-", "");
		endTime = endTime.replaceAll("-", "");
		Map<String, SocketData> map = SocketServer.clients;
		SocketData socketData = map.get(id);
		socketData.setSet(new HashSet());
		Set<String> set = socketData.getSet();

		if (set != null && set.size() > 0) {
			socketData.setSet(new HashSet());
		}

		log.info("提取设备" + id + "的日志");
		// 根据设备编号，找到对应的socket,然后接收传过来的文件。
		// 以下是示例， 后期应该放到service中实现
		Socket client = socketData.getSocket();
		try {
			OutputStream os = client.getOutputStream();
			os.write("1".getBytes());
			byte[] bytes = (firstTime + "_" + endTime).getBytes();
			byte[] sendTypeData = new byte[300];
			if (bytes.length < 300) {
				System.arraycopy(bytes, 0, sendTypeData, 0, bytes.length);
			}
			os.write(sendTypeData);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果那边没有传输完成，那么就让线程休眠0.2秒 不然获取不到文件名的数据
		long l1 = new Date().getTime();
		while (!socketData.getFlag()) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				log.info("线程休眠异常");
			}
			// 超时时间10秒，如果超时就跳出循环直接返回
			if (new Date().getTime() - l1 > 30000) {
				log.info("等待时间超过30秒");
				break;
			}
		}

		socketData.setFlag(false);
		Map<String, Object> data = new HashMap();
		Set<String> list = socketData.getSet();
		Set<String> list1 = new HashSet<String>();
		for (String string : list) {
			string = appProperties.getResourcePath() + "log/" + id + "/" + string;
			list1.add(string);
		}
		// 更新日志操作描述 start

		request.setAttribute(AdminConstant.OPERATION_DESC, "对设备" + id + "提取日志");
		List<File> fileList = new ArrayList<>();
		// fileList.add(new File());
		if (list1 == null || list1.size() == 0) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_NOT_LOG.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_NOT_LOG.getCode()).data(data).build();
		}
		for (String string : list1) {
			String resourcePath = appProperties.getResourcePath();
			String logPath = appProperties.getLogPath();
			string = string.replaceAll(resourcePath + "log/", "");
			log.info("日志文件路径为:" + string);
			fileList.add(new File(logPath + string));
		}

		FileOutputStream fos2 = null;
		String allLog = appProperties.getLogPath() + "/" + id + "/allLog.zip";
		try {
			fos2 = new FileOutputStream(new File(allLog));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		FileUtil.toZip(fileList, fos2);
		String allLogPath = appProperties.getResourcePath() + "log/" + id + "/allLog.zip";
		log.info("日志包路径为：" + allLogPath);
		List allLogPathList = new ArrayList<String>();
		allLogPathList.add(allLogPath);
		data.put("list", allLogPathList);

		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(data).build();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@AdminLog(interfaceCode = "/auth/getScreenSnap", interfaceDesc = "获取截屏")
	@ApiOperation(value = "获取截屏", httpMethod = "POST")
	@RequestMapping("/getScreenSnap")
	public JSONData getScreenSnap(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}

		Map<String, SocketData> map = SocketServer.clients;
		SocketData socketData = map.get(id);
		Set<String> set = socketData.getSet();

		if (set != null && set.size() > 0) {
			socketData.setSet(new HashSet());
		}

		log.info("提取设备" + id + "的截屏");
		// 根据设备编号，找到对应的socket,然后接收传过来的文件。
		// 以下是示例， 后期应该放到service中实现
		Socket client = socketData.getSocket();
		try {
			OutputStream os = client.getOutputStream();
			os.write("2".getBytes());// 消息类型 0-心跳检测 ，1-抓取日志，2-截屏，3-版本下发
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> data = new HashMap();
		long l1 = new Date().getTime();
		while (!socketData.getFlag()) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				log.info("线程休眠异常");
			}
			// 超时时间10秒，如果超时就跳出循环直接返回
			if (new Date().getTime() - l1 > 30000) {
				log.info("等待时间超过30秒");
				break;
			}
		}
		socketData.setFlag(false);
		Set<String> list = socketData.getSet();

		data.put("list", list);
		Set<String> list1 = new HashSet<String>();
		for (String string : list) {
			string = appProperties.getResourcePath() + "/snap/" + id + "/" + string;
			list1.add(string);
		}

		// 更新日志操作描述 start
		String operationDesc = "对设备" + id + "抓取图片";
		boolean flag = false;// 如果没有找到，则默认为false

		if (list != null || list.size() > 0) {
			operationDesc = operationDesc + "，抓取的图片信息为：" + list.toString();
			flag = true;
		}

		if (flag) {
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
		}

		data.put("list", list1);

		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(data).build();
	}

	@AdminLog(interfaceCode = "/auth/versionSend", interfaceDesc = "版本下发")
	@ApiOperation(value = "版本下发", httpMethod = "POST")
	@RequestMapping("/versionSend")
	public JSONData versionSend(HttpServletRequest request) {

		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String softVersion = request.getParameter("softVersion");// 文件名称
		log.info("版本下发设备" + id);
		// 根据设备编号，找到对应的socket,然后接收传过来的文件。
		// 以下是示例， 后期应该放到service中实现

		if ((StringUtils.isEmpty(id) && StringUtils.isEmpty(type)) || StringUtils.isEmpty(softVersion)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}
		// 记录是否是多台设备 0-一台，1-多台，2-所有设备
		int f = 0;
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		Boolean flag = false;
		Map<String, SocketData> mapSocket = SocketServer.clients;
		
		try {
			Socket client;
			if (StringUtils.isEmpty(type)) {
				// 如果id有逗号 说明有多个id需要下发版本
				if (id.contains(",")) {
					f = 1;
					String[] ids = id.split(",");
					for (int i = 0; i < ids.length; i++) {
						client = mapSocket.get(ids[i]).getSocket();
						flag = versionSendService.versionSend(client, softVersion);
						//判断版本文件是否存在，如果不存在直接返回错误信息
						if(flag){
							return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_VERSION_NOT.getMsg())
									.code(EnumResponseMsg.RESP_ERROR_VERSION_NOT.getCode()).build();
						}
						
						map.put(ids[i], flag);
					}
				} else {
					client = mapSocket.get(id).getSocket();
					flag = versionSendService.versionSend(client, softVersion);
					//判断版本文件是否存在，如果不存在直接返回错误信息
					if(flag){
						return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_VERSION_NOT.getMsg())
								.code(EnumResponseMsg.RESP_ERROR_VERSION_NOT.getCode()).build();
					}
					map.put(id, flag);
				}
				// 如果type不为空或空字符串那么就给所有设备下发版本
			} else {
				f = 2;

				for (Map.Entry<String, SocketData> entry : mapSocket.entrySet()) {
					SocketData value = entry.getValue();
					flag = versionSendService.versionSend(value.getSocket(), softVersion);
					//判断版本文件是否存在，如果不存在直接返回错误信息
					if(flag){
						return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_VERSION_NOT.getMsg())
								.code(EnumResponseMsg.RESP_ERROR_VERSION_NOT.getCode()).build();
					}
					map.put(entry.getKey(), flag);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TbEquipmentSettings tbEquipmentSettings = new TbEquipmentSettings();
		tbEquipmentSettings.setSoftVersion(softVersion);
		// 只给一台设备下发了版本
		if (f == 0) {
			// 如果上传成功才去修改数据库的版本信息
			Boolean b = map.get(id);
			if (b) {
				tbEquipmentSettings.setId(id);
				tbEquipmentSettingsService.updateSelectTbEquipmentSettings(tbEquipmentSettings);
			}
		} else if (f == 1) {
			String[] ids = id.split(",");
			for (int i = 0; i < ids.length; i++) {
				Boolean b = map.get(ids[i]);
				if (b) {
					tbEquipmentSettings.setId(ids[i]);
					tbEquipmentSettingsService.updateSelectTbEquipmentSettings(tbEquipmentSettings);
				}
			}
		} else if (f == 2) {
			List<TbEquipmentSettings> list = tbEquipmentSettingsService.findAll();
			for (TbEquipmentSettings tbEquipmentSettings2 : list) {
				String id2 = tbEquipmentSettings2.getId();
				Boolean b = map.get(id2);
				if (b) {
					tbEquipmentSettings.setId(id2);
					tbEquipmentSettingsService.updateSelectTbEquipmentSettings(tbEquipmentSettings);
				}
			}
		}
		
		// 更新日志操作描述 start
		String operationDesc = "对ATM设备下发版本"+softVersion;

		request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);

		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).build();
	}

	@AdminLog(interfaceCode = "/auth/restartATM", interfaceDesc = "重启设备")
	@ApiOperation(value = "重启设备", httpMethod = "POST")
	@RequestMapping("/restartATM")
	public JSONData restartATM(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}
		log.info("重启设备" + id);
		// 根据设备编号，找到对应的socket,然后接收传过来的文件。
		// 以下是示例， 后期应该放到service中实现
		Socket client = SocketServer.clients.get(id).getSocket();
		try {
			OutputStream os = client.getOutputStream();
			os.write("4".getBytes());// 消息类型 0-心跳检测 ，1-抓取日志，2-截屏，3-版本下发，4-重启设备
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 更新日志操作描述 start
		String operationDesc = "对设备:" + id + "进行重启操作。";
		boolean logFlag = true;// 如果没有找到，则默认为false

		if (logFlag) {
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
		}

		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).build();
	}

	//@AdminLog(interfaceCode = "/auth/findSoftVersion", interfaceDesc = "查询所有设备版本信息")
	@ApiOperation(value = "查询所有设备版本信息", httpMethod = "POST")
	@RequestMapping("/findSoftVersion")
	public JSONData findSoftVersion(HttpServletRequest request) {
		return tbEquipmentSettingsService.findSoftVersion();
	}

	//@AdminLog(interfaceCode = "/auth/findEquipmentVersion", interfaceDesc = "查询设备型号")
	@ApiOperation(value = "查询设备型号", httpMethod = "POST")
	@RequestMapping("/findEquipmentVersion")
	public JSONData findEquipmentVersion(HttpServletRequest request) {
		return tbEquipmentSettingsService.findEquipmentVersion();
	}

	//@AdminLog(interfaceCode = "/auth/findBrand", interfaceDesc = "查询品牌信息")
	@ApiOperation(value = "查询品牌信息", httpMethod = "POST")
	@RequestMapping("/findBrand")
	public JSONData findBrand(HttpServletRequest request) {
		return tbEquipmentSettingsService.findBrand();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	//@AdminLog(interfaceCode = "/auth/findSocketServer", interfaceDesc = "查询服务状态")
	@ApiOperation(value = "查询服务状态", httpMethod = "POST")
	@RequestMapping("/findSocketServer")
	public JSONData findSocketServer(HttpServletRequest request) {
		String status = "";

		if (SocketServer.server == null) {
			status = "1";
		} else {
			status = "0";
		}
		Map map = new HashMap();
		map.put("status", status);
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(map).build();

	}

}
