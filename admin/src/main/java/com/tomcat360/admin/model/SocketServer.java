package com.tomcat360.admin.model;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.tomcat360.admin.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tomcat360.admin.properties.AppProperties;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by jin.Deng on 2018/9/25.
 */
@Slf4j
@Component
public class SocketServer {
	
	public static boolean socketFlag = false;
	private static AppProperties appProperties;
	
	public AppProperties getAppProperties() {
		return appProperties;
	}
	
	@Autowired
	public void setAppProperties(AppProperties appProperties) {
		SocketServer.appProperties = appProperties;
	}

	private static int port = 16789;
	public static Map<String,SocketData> clients = new HashMap<String,SocketData>();
	public static ServerSocket server;
	
	
	public static void startServer() throws Exception{
		log.info("启动socketServer，接收连接请求。");
		server = new ServerSocket(port);

		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try{
						log.info("等待连接。。。");
						if(server==null){
							break;
						}
						Socket socket = server.accept();
						log.info("接收到请求");
						SocketThread mythread = new SocketThread(socket,appProperties);
						mythread.start();
					}catch (Exception e){
						log.error(LogUtils.getExceptionInfo(e));
						break;
					}
				}
			}
		}).start();
	}

	public static void stopServer() throws Exception{
		if(clients!=null){
			for(SocketData socketData : clients.values()){
				Socket socket = socketData.getSocket();
				if(socket!=null){
					socket.close();
					socket = null;
				}
			}
		}
		clients = new HashMap<String,SocketData>();
		server.close();
		server = null;
	}

}
