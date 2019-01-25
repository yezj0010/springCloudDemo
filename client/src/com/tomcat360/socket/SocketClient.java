package com.tomcat360.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户端给服务端的消息流规范： 第1个字节：infoType消息类型 0-心跳检测 ，1-抓取日志，2-截屏，3-设备编号 然后写入300个字节，该字节为参数
 * 接下来4个字节：内容长度 接下来内容长度个字节：之后是消息内容 最后的7个字节：文件类型
 * 
 * @author admin
 */
public class SocketClient {
	private Socket client;
	//设备标号
	private String termNo;
	//atm日志储存位置
	private String logPath;
	//版本储存位置
	private String versionPath;
	//服务端地址
	private String host;
	//服务端端口号
	private Integer port;
	//心跳检测时间
	private Integer pingTime;
	//初次连接等待时间
	private Integer startTime;
	private static final Logger logger = LoggerFactory.getLogger(SocketClient.class);

	public SocketClient() {
		IniUtil iniUtil = new IniUtil();
		versionPath = iniUtil.getConfigPer("versionPath").trim();
		//获取服务端得域名
		host = iniUtil.getConfigPer("host");
		InetAddress ip = null;
		try {
			ip = InetAddress.getByName(host);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(ip==null){
			logger.error("获取ip异常");
		}
		host = ip.toString().split("/")[1];
		logger.info("获取的服务端ip地址为："+host);
		
		port = iniUtil.getConfigPer("port")==null?null:Integer.valueOf(iniUtil.getConfigPer("port").trim());
		logger.info("获取的服务端端口为："+port);
		
		termNo = IniUtil.getEquipmentNo().trim();
		logger.info("获取的设备号为："+termNo);
		
		logPath = iniUtil.getConfigPer("logPath");
		logger.info("本设备日志路径为："+logPath);
		
		startTime = iniUtil.getConfigPer("startTime")==null?0:Integer.valueOf(iniUtil.getConfigPer("startTime").trim());
		logger.info("本设备未连接上服务的心跳检测时间为："+startTime+"秒");
		
		pingTime = iniUtil.getConfigPer("pingTime")==null?null:Integer.valueOf(iniUtil.getConfigPer("pingTime").trim());
		logger.info("本设备心跳检测时间为："+pingTime+"秒");
		while (true) {
			
			try {
				if (client == null) {
					logger.info("开始连接");
					
					client = new Socket(host, port);
					new Cthread().start();
					// 设备编号从ini文件中获取
					OutputStream os = client.getOutputStream();
					os.write("3".getBytes());
					os.write(new byte[300]);
					os.write(intToByteArray(termNo.getBytes().length));
					os.write(termNo.getBytes());
					os.flush();
				} else {
					
					logger.info("已经连接");
					try {// 发送心跳检测
						OutputStream os = client.getOutputStream();
						os.write("0".getBytes());
						os.flush();
					} catch (Exception e) {// 断开产生异常，关闭对象
						client.close();
						client = null;
						logger.error(LogUtils.getExceptionInfo(e));
					}
					
				}
			} catch (Exception e) {
				logger.error(LogUtils.getExceptionInfo(e));
			}

			try {
				if(client==null){
					logger.info("等待"+startTime+"秒进行连接");
					Thread.sleep(startTime*1000);// 等待${startTime}秒通讯检测
				}else{
					logger.info("等待"+pingTime+"秒之后进行通信检测");
					Thread.sleep(pingTime*1000);// 等待${pingTime}秒通讯检测
				}
			} catch (Exception e) {
				logger.error(LogUtils.getExceptionInfo(e));
			}
		}

	}

	/**
	 * 客户端给服务端的消息流规范： 第1个字节：infoType消息类型 0-心跳检测 ，1-抓取日志，2-截屏，3-设备编号 然后30个字节：参数
	 * 接下来4个字节：内容长度 接下来内容长度个字节：消息内容 接下来7个字节：文件类型
	 * 
	 * @author admin
	 */
	class Cthread extends Thread {

		@SuppressWarnings("resource")
		public void run() {
			while (true) {
				try {
					
					InputStream inputStream = client.getInputStream();
					byte[] b = new byte[1];
					inputStream.read(b);
					String flag = new String(b);
					if (flag != null && flag.equals("0")) {
						// 心跳检测
						logger.info("ping pong from server");
					} else if (flag != null && flag.equals("1")) {
						logger.info("执行发送日志 start");
						// 抓取日志 TODO 文件名后期根据一套规则获取
						byte[] para = new byte[300];
						inputStream.read(para);
						String paramter = new String(para);

						sendLogFile("1", logPath, paramter);// 1代表发给服务端的消息类型
						logger.info("执行发送日志 end");
					} else if (flag != null && flag.equals("2")) {
						logger.info("执行发送截屏 start");
						// 截屏  文件名后期根据一套规则获取
						String path = "C:/";
						String type = "png";
						String name = "printScreen";// 覆盖掉原来的，不需要存储以前的截图
						
						try {
							logger.info("本地截屏开始");
							PrtScUtil.printScreen(name, path, type);
							logger.info("本地截屏开始");
							logger.info("传输截屏到服务器");
							sendOneFile("2", path + name + "." + type);// 2代表发给服务端的消息类型
						} catch (Exception e) {
							logger.error(LogUtils.getExceptionInfo(e));
						}
						logger.info("执行发送截屏 end");
					} else if (flag != null && flag.equals("3")) {
						logger.info("接收下发版本 start");
						// 版本下发
						versionSend(inputStream,client.getOutputStream());
						logger.info("接收下发版本 start");
					} else if (flag != null && flag.equals("4")) {
						logger.info("重启设备 start");
						// 重启设备
						// 执行操作，具体直接执行重启，还是通过东方通信接口重启待定。
						Socket localClient = new Socket("127.0.0.1", 8122);
						OutputStream os = localClient.getOutputStream();
						os.write("ECC_ABWOA_3.0_COMMAND=REBOOT".getBytes());
						os.flush();
						os.close();
						logger.info("重启设备 end");
					}
					
					OutputStream out = client.getOutputStream();
					out.write("0".getBytes());
					out.flush();
					
				} catch (IOException e) {
					logger.error(LogUtils.getExceptionInfo(e));
					try {
						OutputStream os = client.getOutputStream();
						os.write("0".getBytes());
						os.flush();
					} catch (Exception e2) {
						logger.error(LogUtils.getExceptionInfo(e));
						logger.info("服务端关闭");
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new SocketClient();
	}

	public void sendLogFile(String infoType, String pathAndFileName, String paramter) {
		try {

			OutputStream out = client.getOutputStream();
			logger.info(pathAndFileName);
			File f = new File(pathAndFileName);
			if (!f.exists()) {
				logger.info("文件不存在");
				return;
			} else {
				// if (length > 1024 * 1024 * 5) {
				// logger.info("文件过大");
				// return;
				// } else {
				// 解析日志文件名里的日期，判断日志文件日期是否在抓取日期之内
				String[] split = paramter.split("_");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				Date firstTime = sdf.parse(split[0]);
				Date endTime = sdf.parse(split[1]);
				List<File> list = new ArrayList<File>();
				File[] listFiles = f.listFiles();
				for (int i = 0; i < listFiles.length; i++) {
					String name = listFiles[i].getName();
					String fileName = name.substring(0, name.indexOf("."));

					Date parse = sdf.parse(fileName);
					if (DateUtil.isDateBetween(parse, firstTime, endTime)) {
						list.add(listFiles[i]);
					}
				}

				for (int i = 0; i < list.size(); i++) {
					File f1 = list.get(i);
					InputStream in = new FileInputStream(f1);
					int length = (int) f.length();

					String fileName = f1.getName();
					String fileType = fileName.substring(fileName.indexOf(".") + 1);

					if (!"jrn".equals(fileType)) {
						continue;
					}

					// 后缀名
					byte[] typeData = fileType.getBytes();
					byte[] sendTypeData = new byte[7];
					if (typeData.length < 7) {
						System.arraycopy(typeData, 0, sendTypeData, 0, typeData.length);
					}

					// 获得文件名
					// 获取文件个数
					String fileNum = list.size() + "";
					byte[] parameterData = new byte[300];
					String fileName1 = f1.getName().substring(0, f1.getName().indexOf("."));
					byte[] nameByte = (fileName1 + "," + fileNum).getBytes();
					if (nameByte.length < 300) {
						System.arraycopy(nameByte, 0, parameterData, 0, nameByte.length);
					}
					// 文件内容
					byte[] tempData = new byte[length];
					in.read(tempData);
					in.close();
					// 文件长度
					byte[] lengthData = intToByteArray(length);
					out.write(infoType.getBytes());
					out.write(parameterData);
					out.write(lengthData);
					out.write(tempData);
					out.write(sendTypeData);
					out.flush();
					logger.info(f1.getName() + "已经传输");
				}
			}
			// }
		} catch (UnknownHostException e) {
			logger.error(LogUtils.getExceptionInfo(e));
		} catch (IOException e) {
			logger.error(LogUtils.getExceptionInfo(e));
		} catch (ParseException e) {
			logger.error("日期转换异常");
			logger.error(LogUtils.getExceptionInfo(e));
		}

	}

	public void sendOneFile(String infoType, String pathAndFileName) {
		try {
			OutputStream out = client.getOutputStream();
			File f = new File(pathAndFileName);
			if (!f.exists()) {
				logger.info("文件不存在");
				return;
			} else {
				InputStream in = new FileInputStream(f);
				int length = (int) f.length();
				
				String[] tempFileType = pathAndFileName.split("\\.");
				String fileType = tempFileType[tempFileType.length - 1];
				byte[] typeData = fileType.getBytes();
				byte[] sendTypeData = new byte[7];
				if (typeData.length < 7) {
					System.arraycopy(typeData, 0, sendTypeData, 0, typeData.length);
				}

				// 获得文件名 写入参数位置
				byte[] parameterData = new byte[300];
				byte[] nameByte = (f.getName().replace("." + fileType, "")+",1").getBytes();
				if (nameByte.length < 300) {
					System.arraycopy(nameByte, 0, parameterData, 0, nameByte.length);
				}

				byte[] tempData = new byte[length];
				in.read(tempData);
				in.close();

				byte[] lengthData = intToByteArray(length);
				out.write(infoType.getBytes());
				out.write(parameterData);
				out.write(lengthData);
				out.write(tempData);
				out.write(sendTypeData);
				out.flush();
				logger.info(f.getName() + "已经传输");
			}

		} catch (UnknownHostException e) {
			logger.error(LogUtils.getExceptionInfo(e));
		} catch (IOException e) {
			logger.error(LogUtils.getExceptionInfo(e));
		}

	}

	// 接收最新版本文件
	private void versionSend(InputStream in,OutputStream out) throws IOException {

		byte[] pData = new byte[300];
		in.read(pData);
		String versionName = new String(pData).trim();

		byte[] lData = new byte[4];
		in.read(lData);
		int length = byteArrayToInt(lData);
		logger.info("文件大小：" + length + "字节");
		byte[] dt2 = new byte[length];
		readData(in, dt2);
		byte[] type = new byte[5];

		in.read(type);

		String typeStr = new String(type);
		
		logger.info("文件类型：" + typeStr.trim());
		File of = new File(versionPath + "App_"+versionName + "." + typeStr.trim());
		of.createNewFile();
		OutputStream o = new FileOutputStream(of);

		o.write(dt2);
		o.flush();
		o.close();
		//版本文件传输完成之后给服务端发送成功信息
		out.write("4".getBytes());
		
		byte[] paraData = ("versionSend,true,"+versionName+"."+typeStr.trim()).getBytes();
		byte[] paraData1 = new byte[300];
		if (paraData.length < 300) {
			System.arraycopy(paraData, 0, paraData1, 0, paraData.length);
		}
		
		out.write(paraData1);
		out.flush();
	}

	private int byteArrayToInt(byte[] b) {
		return b[3] & 0xFF | (b[2] & 0xFF) << 8 | (b[1] & 0xFF) << 16 | (b[0] & 0xFF) << 24;
	}

	private byte[] intToByteArray(int a) {
		return new byte[] { (byte) ((a >> 24) & 0xFF), (byte) ((a >> 16) & 0xFF), (byte) ((a >> 8) & 0xFF),
				(byte) (a & 0xFF) };
	}

	private void readData(InputStream in, byte[] buffer) throws IOException {
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
