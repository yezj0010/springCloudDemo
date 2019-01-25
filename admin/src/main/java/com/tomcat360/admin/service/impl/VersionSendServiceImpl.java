package com.tomcat360.admin.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.admin.properties.AppProperties;
import com.tomcat360.admin.service.VersionSendService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class VersionSendServiceImpl implements VersionSendService {
	private String pathAndFileName;
	
	private String infoType = "3";
	@Autowired
	private AppProperties appProperties;
	@Override
	public boolean versionSend(Socket client, String softVersion) throws IOException {
		try {
			pathAndFileName = appProperties.getVersionFilePath();
			OutputStream out = client.getOutputStream();
			
			File f = new File(pathAndFileName+softVersion);
			if (!f.exists()) {
				System.out.println("文件不存在");
				log.info("版本文件不存在");
				return true;
			} else {
				InputStream in = new FileInputStream(f);
				int length = (int) f.length();
				// if (length > 1024 * 1024 * 5) {
				// System.out.println("文件过大");
				// return;
				// } else {

				String[] tempFileType = softVersion.split("\\.");
				String fileType = tempFileType[tempFileType.length - 1];
				byte[] typeData = fileType.getBytes();
				byte[] sendTypeData = new byte[7];
				if (typeData.length < 7) {
					System.arraycopy(typeData, 0, sendTypeData, 0, typeData.length);
				}

				byte[] name = f.getName().replace("." + fileType, "").getBytes();
				byte[] nameData = new byte[300];
				if (name.length < 300) {
					System.arraycopy(name, 0, nameData, 0, name.length);
				}

				byte[] tempData = new byte[length];
				in.read(tempData);
				in.close();

				byte[] lengthData = intToByteArray(length);
				out.write(infoType.getBytes());
				out.write(nameData);
				out.write(lengthData);
				out.write(tempData);
				out.write(sendTypeData);
				out.flush();
				
			}
			// }
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	private static byte[] intToByteArray(int a) {
		return new byte[] { (byte) ((a >> 24) & 0xFF), (byte) ((a >> 16) & 0xFF), (byte) ((a >> 8) & 0xFF),
				(byte) (a & 0xFF) };
	}
}
