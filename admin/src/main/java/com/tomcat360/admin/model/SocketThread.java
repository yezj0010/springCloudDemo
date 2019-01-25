package com.tomcat360.admin.model;

import com.tomcat360.admin.properties.AppProperties;
import com.tomcat360.admin.service.TbEquipmentSettingsService;
import com.tomcat360.admin.util.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.Socket;
import java.util.Set;

/**
 * 客户端给服务端的消息流规范： 第1个字节：infoType消息类型 0-心跳检测 ，1-抓取日志，2-截屏，3-设备编号 然后300个字节：参数
 * 接下来4个字节：内容长度 接下来内容长度个字节：消息内容 接下来7个字节：文件类型
 * 
 * @author admin
 */
@Slf4j
@Component
public class SocketThread extends Thread {
	Socket socket;

	private AppProperties appProperties;

	private String logPath;
	private String snapPath;
	private static TbEquipmentSettingsService tbEquipmentSettingsService;

	@Autowired
	public void setTbEquipmentSettingsService(TbEquipmentSettingsService tbEquipmentSettingsService) {
		SocketThread.tbEquipmentSettingsService = tbEquipmentSettingsService;
	}

	public static String fileName = "";
	private String equipmentNo;

	public SocketThread() {

	}

	public SocketThread(Socket socket, AppProperties appProperties) {
		this.socket = socket;
		this.appProperties = appProperties;
	}

	public SocketThread(Socket socket, String equipmentNo) {
		this.socket = socket;
		this.equipmentNo = equipmentNo;
	}

	/**
	 * 客户端给服务端的消息流规范： 第1个字节：消息类型 0-心跳检测 ，1-抓取日志，2-截屏，3-设备编号,4-版本下发成功通知
	 * 接下来4个字节：内容长度 接下来内容长度个字节：消息内容 接下来7个字节：文件类型 最后20个字节：参数
	 * 
	 * @author admin
	 */
	public void run() {
		String termNo = null;
		// TODO while 内部加trycatch,catch里加心跳检测，如果还异常则跳出while
		logPath = appProperties.getLogPath();
		snapPath = appProperties.getSnapPath();
		while (true) {
			try {
				InputStream in = socket.getInputStream();
				byte[] standard = new byte[1];//
				in.read(standard);
				String standardS = new String(standard);// 判断消息类型 0-心跳检测
														// ，1-抓取日志，2-截屏，3-设备编号,4-版本下发成功通知
				if (standardS != null && standardS.equals("0")) {
					log.info("ping pong from client " + equipmentNo);

				} else if (standardS != null && standardS.equals("3")) {// 获取3-设备编号
					byte[] parameterData = new byte[300];
					in.read(parameterData);

					byte[] lengthData = new byte[4];
					in.read(lengthData);
					int length = byteArrayToInt(lengthData);
					byte[] content = new byte[length];
					in.read(content);
					termNo = new String(content, "utf-8");

					equipmentNo = termNo;
					log.info("客户端设备编号是：" + equipmentNo);
					SocketData socketData = new SocketData();
					socketData.setSocket(socket);
					Socket oldSocket = SocketServer.clients.get(termNo) == null ? null
							: SocketServer.clients.get(termNo).getSocket();

					if (oldSocket != null) {
						oldSocket.close();
						// SocketServer.socketFlag = true;
						oldSocket = null;
					}

					SocketServer.clients.put(termNo, socketData);
				} else if (standardS != null && standardS.equals("1")) {// 抓取日志
					log.info("获取日志文件" + equipmentNo);
					String receiveFile = receiveFile(in, logPath);
					System.out.println(receiveFile);

				} else if (standardS != null && standardS.equals("2")) {// 2-截取屏幕
					log.info("获取截屏文件" + equipmentNo);
					receiveFile(in, snapPath);
				} else if (standardS != null && standardS.equals("4")) {
					log.info("获取版本下发结果" + equipmentNo);
					versionReadResult();
				}

			} catch (Exception e) {
				log.error(LogUtils.getExceptionInfo(e));
				// TODO Auto-generated catch block
				try {
					// 如果心跳检测报错，则跳出循环
					socket.getOutputStream().write("0".getBytes());
					socket.getOutputStream().flush();
				} catch (IOException e1) {
					try {
						if (!StringUtils.isEmpty(equipmentNo)) {
							// 这个socket2 可能是新的连接，还是旧的连接
							Socket socket2 = SocketServer.clients.get(equipmentNo) == null ? null
									: SocketServer.clients.get(equipmentNo).getSocket();
							if (socket2 != null) {
								// 如果心跳检测报错，则跳出循环
								socket2.getOutputStream().write("0".getBytes());
								socket2.getOutputStream().flush();
							}
						}

					} catch (Exception e2) {
						SocketServer.clients.remove(equipmentNo);
					}
					log.error("设备编号"+equipmentNo+"断开连接,"+"线程id："+Thread.currentThread().getId()+"结束运行");
					break;
				}
			}
		}
	}

	// 读取客户端发送得版本下发结果通知
	private void versionReadResult() throws IOException {
		InputStream cin = socket.getInputStream();
		byte[] by = new byte[300];
		cin.read(by);
		String str = new String(by).trim();
		if (!StringUtils.isEmpty(str)) {
			String[] split = str.split(",");
			String funName = split[0];
			if (funName != null && funName.equals("versionSend")) {
				String resultString = split[1];
				if (resultString != null && resultString.equals("true")) {
					String fileName = split[2];
					TbEquipmentSettings tbEquipmentSettings = new TbEquipmentSettings();
					tbEquipmentSettings.setId(equipmentNo);
					tbEquipmentSettings.setSoftVersion(fileName);
					tbEquipmentSettingsService.updateSelectTbEquipmentSettings(tbEquipmentSettings);

				}
			}
		}

	}

	public String receiveFile(InputStream in, String filePathAndName) throws IOException {
		filePathAndName = filePathAndName + "/" + equipmentNo + "/";
		// 读取参数
		byte[] pData = new byte[300];
		in.read(pData);
		String fileName = new String(pData).trim().split(",")[0];
		String fileNum = new String(pData).trim().split(",")[1];

		System.out.println(fileName);
		byte[] lData = new byte[4];
		in.read(lData);
		int length = byteArrayToInt(lData);
		log.info("文件大小：" + length + "字节" + equipmentNo);
		byte[] dt2 = new byte[length];
		readData(in, dt2);
		byte[] type = new byte[7];

		in.read(type);

		String typeStr = new String(type);
		log.info("文件类型：" + typeStr.trim() + equipmentNo);
		File file = new File(filePathAndName);
		if (!file.exists()) {
			file.mkdirs();
		}

		File of = new File(filePathAndName + fileName + "." + typeStr.trim());
		of.createNewFile();
		OutputStream o = new FileOutputStream(of);

		o.write(dt2);
		o.flush();
		o.close();
		String a = fileName + "." + typeStr.trim();
		SocketData socketData2 = SocketServer.clients.get(equipmentNo);
		Set<String> set = socketData2.getSet();
		log.info("文件名称" + a + " " + equipmentNo);
		set.add(a);
		if (Integer.valueOf(fileNum) == set.size()) {
			log.info("文件传输完毕" + equipmentNo);
			SocketData socketData = SocketServer.clients.get(equipmentNo);
			socketData.setFlag(true);
		}
		return fileName + "." + typeStr.trim();
	}

	private static int byteArrayToInt(byte[] b) {
		return b[3] & 0xFF | (b[2] & 0xFF) << 8 | (b[1] & 0xFF) << 16 | (b[0] & 0xFF) << 24;
	}

	@SuppressWarnings("unused")
	private static byte[] intToByteArray(int a) {
		return new byte[] { (byte) ((a >> 24) & 0xFF), (byte) ((a >> 16) & 0xFF), (byte) ((a >> 8) & 0xFF),
				(byte) (a & 0xFF) };
	}

	private static void readData(InputStream in, byte[] buffer) throws IOException {
		int offset = 0;
		int numRead = 0;
		while (offset < buffer.length && (numRead = in.read(buffer, offset, buffer.length - offset)) >= 0) {
			offset += numRead;
		}
		// 确保所有数据均被读取
		if (offset != buffer.length) {
			throw new IOException("Could not completely read file ");
		}

	}
	
}
