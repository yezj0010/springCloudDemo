package com.tomcat360.admin.model;

import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class SocketData {
	private Socket socket;
	private Set<String> set = new HashSet<String>();
	private Boolean flag =false;
	private Set<String> versionEquipmentId = new HashSet<String>();
	
}
