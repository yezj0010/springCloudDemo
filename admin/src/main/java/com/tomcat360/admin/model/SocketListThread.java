package com.tomcat360.admin.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SocketListThread extends Thread {
	Socket socket;
	public String msg;
	public BufferedReader br;
	private String ip;
	public static Set<String> set = new HashSet<String>();

	public SocketListThread(Socket s, String ip) {
		socket = s;
		this.ip = ip;
	}

	public SocketListThread() {
	}

	public SocketListThread(Socket s) {
		socket = s;
	}

	public void run() {

		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("端口是：" + socket.getInetAddress().getHostAddress());

			InputStream inputStream = socket.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			inputStream.close();

			String equipmentId = new String(sb);
			if (equipmentId == null || !equipmentId.contains("HAYEK")) {
				String hostAddress = socket.getInetAddress().getHostAddress();// 记录发送equipmentId失败的设备当前ip
			}else{
				equipmentId = equipmentId.replaceAll("\r|\n", "");
				set.add(equipmentId);
			}
			inputStream.close();
			System.out.println("客户端回写成功：" + set);
			System.out.println(msg);
			return;

		} catch (Exception e) {
			log.info("SocketThread错误。");
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
