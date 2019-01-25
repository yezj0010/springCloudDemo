package com.tomcat360.admin.service;

import java.io.IOException;
import java.net.Socket;

public interface VersionSendService {

	boolean versionSend(Socket client, String softVersion) throws IOException;

}
