package com.tomcat360.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbEquipmentStatusMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbEquipmentStatus;
import com.tomcat360.admin.model.TbEquipmentStatusExample;
import com.tomcat360.admin.service.TbEquipmentStatusService;
import com.tomcat360.admin.util.CalendarUtil;
import com.tomcat360.admin.util.MapUtil;

@Service
public class TbEquipmentStatusServiceImpl implements TbEquipmentStatusService {
	@Autowired
	private TbEquipmentStatusMapper tbEquipmentStatusMapper;
	
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access"})
	@Override
	public JSONData findByList(TbEquipmentStatus tbEquipmentStatus, String country, String page, String size,
			String type) {
		Integer page1 = 1;
		Integer pageSize = 10;
		if (!StringUtils.isEmpty(page)) {
			page1 = Integer.valueOf(page);
		}
		if (!StringUtils.isEmpty(size)) {
			pageSize = Integer.valueOf(size);
		}
		Map map = new HashMap();
		Page<TbEquipmentStatus> pages = PageHelper.startPage(page1, pageSize);
		map.put("country", country);
		// 如果type为空 那就查询出所有设备状态信息
		map.put("transStatus", tbEquipmentStatus.getTransStatus());
		map.put("runningStatus", tbEquipmentStatus.getRunningStatus());
		map.put("moduleStatus", tbEquipmentStatus.getModuleStatus());
		map.put("banknoteBoxStatus", tbEquipmentStatus.getBanknoteBoxStatus());
		map.put("networkStatus", tbEquipmentStatus.getNetworkStatus());
		map.put("prrStatus", tbEquipmentStatus.getPrrStatus());
		map.put("id", tbEquipmentStatus.getId());
		if (StringUtils.isEmpty(type)) {
			tbEquipmentStatusMapper.monitorEquipmentList(map);
			// 否则按条件查找设备信息
		} else {
			if (type.equals("0")) {
				map.put("transStatus", tbEquipmentStatus.getTransStatus());
				tbEquipmentStatusMapper.monitorEquipmentList0(map);
			} else if (type.equals("1")) {
				map.put("connectStatus", tbEquipmentStatus.getConnectStatus());
				tbEquipmentStatusMapper.monitorEquipmentList1(map);
			} else if (type.equals("2")) {
				map.put("moduleStatus", tbEquipmentStatus.getModuleStatus());
				tbEquipmentStatusMapper.monitorEquipmentList2(map);
			} else if (type.equals("3")) {
				map.put("banknoteBoxStatus", tbEquipmentStatus.getBanknoteBoxStatus());
				tbEquipmentStatusMapper.monitorEquipmentList3(map);
			} else if (type.equals("4")) {
				map.put("networkStatus", tbEquipmentStatus.getNetworkStatus());
				tbEquipmentStatusMapper.monitorEquipmentList4(map);
			} else if (type.equals("5")) {
				map.put("prrStatus", tbEquipmentStatus.getPrrStatus());
				tbEquipmentStatusMapper.monitorEquipmentList5(map);
			} else if (type.equals("6")) {
				map.put("maintainStatus", tbEquipmentStatus.getMaintainStatus());
				tbEquipmentStatusMapper.monitorEquipmentList6(map);
			}
		}

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		for (TbEquipmentStatus tbEquipmentStatus2 : pages.getResult()) {
			Map mapTemp = new HashMap();
			mapTemp.put("id", tbEquipmentStatus2.getId());
			mapTemp.put("transStatus", tbEquipmentStatus2.getTransStatus());
			mapTemp.put("runningStatus", tbEquipmentStatus2.getRunningStatus());
			mapTemp.put("moduleStatus", tbEquipmentStatus2.getModuleStatus());
			mapTemp.put("banknoteBoxStatus", tbEquipmentStatus2.getBanknoteBoxStatus());
			mapTemp.put("networkStatus", tbEquipmentStatus2.getNetworkStatus());
			mapTemp.put("updateTime", tbEquipmentStatus2.getTransTime());// 交易时间放在了updateTime里
			// mapTemp.put("equipmentNo", tbEquipmentStatus2.getEquipmentNo());
			mapTemp.put("prrStatus", tbEquipmentStatus2.getPrrStatus());
			mapTemp.put("maintainStatus", tbEquipmentStatus2.getMaintainStatus());
			mapTemp.put("connectStatus", tbEquipmentStatus2.getConnectStatus());

			if (tbEquipmentStatus2.getTransTime() != null) {
				CalendarUtil calendarUtil = new CalendarUtil();
				String dateDistanceTime = calendarUtil.getDateDistanceTime(new Date(),
						tbEquipmentStatus2.getTransTime());

				mapTemp.put("transTime", dateDistanceTime);
			}
			
			list.add(mapTemp);
		}

		for (Map<String, Object> map2 : list) {
			String ts = (String) map2.get("transStatus");
			String rs = (String) map2.get("runningStatus");
			String ms = (String) map2.get("moduleStatus");
			String bs = (String) map2.get("banknoteBoxStatus");
			String ns = (String) map2.get("networkStatus");
			String ps = (String) map2.get("prrStatus");
			String mas = (String) map2.get("maintainStatus");
			String cs = (String) map2.get("connectStatus");

			if (ps != null && ps.equals("0") && ts != null && ts.equals("0") && rs != null && rs.equals("0")
					&& ms != null && ms.equals("0") && bs != null && bs.equals("0") && ns != null && ns.equals("0")
					&& mas != null && mas.equals("0") && cs != null && cs.equals("0")) {
				map2.put("checkStatus", "0");
			} else {
				map2.put("checkStatus", "1");
			}

		}
		if(pages.getPages() <page1){
			list = null;
		}
		
		Map result = new HashMap();
		result.put("list", list);
		result.put("totalNum", pages.getTotal());
		result.put("page", pages.getPageNum());
		result.put("pageSize", pages.getPageSize());
		result.put("totalPages", pages.getPages());
		result.put("totalNumber", pages.getTotal());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();

	}

	@Override
	public void insert(TbEquipmentStatus tbEquipmentStatus) {
		// TODO Auto-generated method stub
		tbEquipmentStatusMapper.insert(tbEquipmentStatus);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONData findDowntimeEquipment(Map<String, Object> params) {
		Integer page = (Integer) params.get("page");
		Integer size = (Integer) params.get("size");
		Page<Map<String, Object>> list = PageHelper.startPage(page, size);

		tbEquipmentStatusMapper.findDowntimeEquipment();
		for (Map<String, Object> map : list) {
			map = MapUtil.joinDataDowntimeEquipment(map);
		}

		Map map = new HashMap();
		map.put("list", list.getResult());
		map.put("page", list.getPageNum());
		map.put("pageSize", list.getPageSize());
		map.put("totalPages", list.getPages());
		map.put("totalNumber", list.getTotal());
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(map).build();
	}

	@Override
	public TbEquipmentStatus selectById(String id) {
		// TODO Auto-generated method stub
		return tbEquipmentStatusMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(TbEquipmentStatus tbEquipmentStatus) {
		tbEquipmentStatusMapper.updateByPrimaryKeySelective(tbEquipmentStatus);

	}

	// 查询所有闲置设备
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access"})
	@Override
	public JSONData findByIdleEquipment(String country, String page, String size, String type, String id) {
		Integer page1 = 1;
		Integer pageSize = 10;
		if (!StringUtils.isEmpty(page)) {
			page1 = Integer.valueOf(page);
		}
		if (!StringUtils.isEmpty(size)) {
			pageSize = Integer.valueOf(size);
		}
		Map map = new HashMap();
		Page<TbEquipmentStatus> pages = PageHelper.startPage(page1, pageSize);
		map.put("country", country);
		map.put("type", type);
		map.put("id", id);

		tbEquipmentStatusMapper.findByIdleEquipment(map);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (TbEquipmentStatus tbEquipmentStatus2 : pages.getResult()) {
			Map mapTemp = new HashMap();
			mapTemp.put("id", tbEquipmentStatus2.getId());
			mapTemp.put("transStatus", tbEquipmentStatus2.getTransStatus());
			mapTemp.put("runningStatus", tbEquipmentStatus2.getRunningStatus());
			mapTemp.put("moduleStatus", tbEquipmentStatus2.getModuleStatus());
			mapTemp.put("banknoteBoxStatus", tbEquipmentStatus2.getBanknoteBoxStatus());
			mapTemp.put("networkStatus", tbEquipmentStatus2.getNetworkStatus());
			mapTemp.put("updateTime", tbEquipmentStatus2.getTransTime());// 交易时间放在了updateTime里
			// mapTemp.put("equipmentNo", tbEquipmentStatus2.getEquipmentNo());
			mapTemp.put("prrStatus", tbEquipmentStatus2.getPrrStatus());
			mapTemp.put("maintainStatus", tbEquipmentStatus2.getMaintainStatus());
			mapTemp.put("connectStatus", tbEquipmentStatus2.getConnectStatus());

			if (tbEquipmentStatus2.getTransTime() != null) {
				CalendarUtil calendarUtil = new CalendarUtil();
				String dateDistanceTime = calendarUtil.getDateDistanceTime(new Date(),
						tbEquipmentStatus2.getTransTime());

				mapTemp.put("transTime", dateDistanceTime);
			}

			list.add(mapTemp);
		}

		Map result = new HashMap();
		result.put("list", list);
		result.put("totalNum", pages.getTotal());
		result.put("page", pages.getPageNum());
		result.put("pageSize", pages.getPageSize());
		result.put("totalPages", pages.getPages());
		result.put("totalNumber", pages.getTotal());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}

	// 查询所有未激活的设备
	@SuppressWarnings({ "unchecked", "static-access", "rawtypes" })
	@Override
	public JSONData findByNotActive(String country, String page, String size, String type, String id) {
		Integer page1 = 1;
		Integer pageSize = 10;
		if (!StringUtils.isEmpty(page)) {
			page1 = Integer.valueOf(page);
		}
		if (!StringUtils.isEmpty(size)) {
			pageSize = Integer.valueOf(size);
		}
		Map map = new HashMap();
		Page<TbEquipmentStatus> pages = PageHelper.startPage(page1, pageSize);
		map.put("country", country);
		map.put("type", type);
		map.put("id", id);

		tbEquipmentStatusMapper.findByNotActive(map);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (TbEquipmentStatus tbEquipmentStatus2 : pages.getResult()) {
			Map mapTemp = new HashMap();
			mapTemp.put("id", tbEquipmentStatus2.getId());
			mapTemp.put("transStatus", tbEquipmentStatus2.getTransStatus());
			mapTemp.put("runningStatus", tbEquipmentStatus2.getRunningStatus());
			mapTemp.put("moduleStatus", tbEquipmentStatus2.getModuleStatus());
			mapTemp.put("banknoteBoxStatus", tbEquipmentStatus2.getBanknoteBoxStatus());
			mapTemp.put("networkStatus", tbEquipmentStatus2.getNetworkStatus());
			mapTemp.put("updateTime", tbEquipmentStatus2.getTransTime());// 交易时间放在了updateTime里
			// mapTemp.put("equipmentNo", tbEquipmentStatus2.getEquipmentNo());
			mapTemp.put("prrStatus", tbEquipmentStatus2.getPrrStatus());
			mapTemp.put("maintainStatus", tbEquipmentStatus2.getMaintainStatus());
			mapTemp.put("connectStatus", tbEquipmentStatus2.getConnectStatus());

			if (tbEquipmentStatus2.getTransTime() != null) {
				CalendarUtil calendarUtil = new CalendarUtil();
				String dateDistanceTime = calendarUtil.getDateDistanceTime(new Date(),
						tbEquipmentStatus2.getTransTime());

				mapTemp.put("transTime", dateDistanceTime);
			}

			list.add(mapTemp);
		}

		Map result = new HashMap();
		result.put("list", list);
		result.put("totalNum", pages.getTotal());
		result.put("page", pages.getPageNum());
		result.put("pageSize", pages.getPageSize());
		result.put("totalPages", pages.getPages());
		result.put("totalNumber", pages.getTotal());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();

	}

	// 查询所有正常设备
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@Override
	public JSONData findByNormalEquiment(String country, String page, String size, String type, String id) {
		Integer page1 = 1;
		Integer pageSize = 10;
		if (!StringUtils.isEmpty(page)) {
			page1 = Integer.valueOf(page);
		}
		if (!StringUtils.isEmpty(size)) {
			pageSize = Integer.valueOf(size);
		}
		Map map = new HashMap();
		Page<TbEquipmentStatus> pages = PageHelper.startPage(page1, pageSize);
		map.put("country", country);
		map.put("type", type);
		map.put("id", id);

		tbEquipmentStatusMapper.findByNormalEquiment(map);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (TbEquipmentStatus tbEquipmentStatus2 : pages.getResult()) {
			Map mapTemp = new HashMap();
			mapTemp.put("id", tbEquipmentStatus2.getId());
			mapTemp.put("transStatus", tbEquipmentStatus2.getTransStatus());
			mapTemp.put("runningStatus", tbEquipmentStatus2.getRunningStatus());
			mapTemp.put("moduleStatus", tbEquipmentStatus2.getModuleStatus());
			mapTemp.put("banknoteBoxStatus", tbEquipmentStatus2.getBanknoteBoxStatus());
			mapTemp.put("networkStatus", tbEquipmentStatus2.getNetworkStatus());
			mapTemp.put("updateTime", tbEquipmentStatus2.getTransTime());// 交易时间放在了updateTime里
			// mapTemp.put("equipmentNo", tbEquipmentStatus2.getEquipmentNo());
			mapTemp.put("prrStatus", tbEquipmentStatus2.getPrrStatus());
			mapTemp.put("maintainStatus", tbEquipmentStatus2.getMaintainStatus());
			mapTemp.put("connectStatus", tbEquipmentStatus2.getConnectStatus());

			if (tbEquipmentStatus2.getTransTime() != null) {
				CalendarUtil calendarUtil = new CalendarUtil();
				String dateDistanceTime = calendarUtil.getDateDistanceTime(new Date(),
						tbEquipmentStatus2.getTransTime());

				mapTemp.put("transTime", dateDistanceTime);
			}

			list.add(mapTemp);
		}

		Map result = new HashMap();
		result.put("list", list);
		result.put("totalNum", pages.getTotal());
		result.put("page", pages.getPageNum());
		result.put("pageSize", pages.getPageSize());
		result.put("totalPages", pages.getPages());
		result.put("totalNumber", pages.getTotal());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();

	}

	// 查询所有异常设备
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@Override
	public JSONData findByAbnormal(String country, String page, String size, String type, String id) {
		Integer page1 = 1;
		Integer pageSize = 10;
		if (!StringUtils.isEmpty(page)) {
			page1 = Integer.valueOf(page);
		}
		if (!StringUtils.isEmpty(size)) {
			pageSize = Integer.valueOf(size);
		}
		Map map = new HashMap();
		Page<TbEquipmentStatus> pages = PageHelper.startPage(page1, pageSize);
		map.put("country", country);
		map.put("type", type);
		map.put("id", id);

		tbEquipmentStatusMapper.findByAbnormal(map);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (TbEquipmentStatus tbEquipmentStatus2 : pages.getResult()) {
			Map mapTemp = new HashMap();
			mapTemp.put("id", tbEquipmentStatus2.getId());
			mapTemp.put("transStatus", tbEquipmentStatus2.getTransStatus());
			mapTemp.put("runningStatus", tbEquipmentStatus2.getRunningStatus());
			mapTemp.put("moduleStatus", tbEquipmentStatus2.getModuleStatus());
			mapTemp.put("banknoteBoxStatus", tbEquipmentStatus2.getBanknoteBoxStatus());
			mapTemp.put("networkStatus", tbEquipmentStatus2.getNetworkStatus());
			mapTemp.put("updateTime", tbEquipmentStatus2.getTransTime());// 交易时间放在了updateTime里
			// mapTemp.put("equipmentNo", tbEquipmentStatus2.getEquipmentNo());
			mapTemp.put("prrStatus", tbEquipmentStatus2.getPrrStatus());
			mapTemp.put("maintainStatus", tbEquipmentStatus2.getMaintainStatus());
			mapTemp.put("connectStatus", tbEquipmentStatus2.getConnectStatus());

			if (tbEquipmentStatus2.getTransTime() != null) {
				CalendarUtil calendarUtil = new CalendarUtil();
				String dateDistanceTime = calendarUtil.getDateDistanceTime(new Date(),
						tbEquipmentStatus2.getTransTime());

				mapTemp.put("transTime", dateDistanceTime);
			}

			list.add(mapTemp);
		}

		Map result = new HashMap();
		result.put("list", list);
		result.put("totalNum", pages.getTotal());
		result.put("page", pages.getPageNum());
		result.put("pageSize", pages.getPageSize());
		result.put("totalPages", pages.getPages());
		result.put("totalNumber", pages.getTotal());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public JSONData test(TbEquipmentStatus tbEquipmentStatus, String country, String page, String size, String type,
			String equipmentType) {

		Integer page1 = 1;
		Integer pageSize = 10;
		if (!StringUtils.isEmpty(page)) {
			page1 = Integer.valueOf(page);
		}
		if (!StringUtils.isEmpty(size)) {
			pageSize = Integer.valueOf(size);
		}
		Map map = new HashMap();
		Page<List<Map<String, Object>>> pages = PageHelper.startPage(page1, pageSize);
		map.put("country", country);
		// 如果type为空 那就查询出所有设备状态信息
		map.put("transStatus", tbEquipmentStatus.getTransStatus());
		map.put("runningStatus", equipmentType);
		map.put("moduleStatus", tbEquipmentStatus.getModuleStatus());
		map.put("banknoteBoxStatus", tbEquipmentStatus.getBanknoteBoxStatus());
		map.put("networkStatus", tbEquipmentStatus.getNetworkStatus());
		map.put("prrStatus", tbEquipmentStatus.getPrrStatus());
		map.put("id", tbEquipmentStatus.getId());
		map.put("type", type);
		tbEquipmentStatusMapper.test(map);
		
		Map result = new HashMap();
		result.put("list", pages.getResult());
		result.put("totalNum", pages.getTotal());
		result.put("page", pages.getPageNum());
		result.put("pageSize", pages.getPageSize());
		result.put("totalPages", pages.getPages());
		result.put("totalNumber", pages.getTotal());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONData findEquipmentStatus() {
		List<Map<String,Object>> list = tbEquipmentStatusMapper.findEquipmentStatus();
		Map map = new HashMap<String,Object>();
		map.put("list", list);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(map).build();
	}

	@Override
	public List<TbEquipmentStatus> selectByExample(TbEquipmentStatusExample example) {
		List<TbEquipmentStatus> selectByExample = tbEquipmentStatusMapper.selectByExample(example);
		return selectByExample;
	}

}
