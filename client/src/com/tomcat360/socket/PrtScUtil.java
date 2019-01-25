package com.tomcat360.socket;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 截屏工具类
 * Created by jin.Deng on 2018/9/25.
 */
public class PrtScUtil {

	/**
	 * 屏幕截图
	 * @param imageName 存储图片名称
	 * @param path 图片路径
	 * @param imgType 图片类型
	 * @throws Exception
	 */
	public static void printScreen(String imageName,String path,String imgType) throws Exception{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image,imgType, new File(path+imageName+"."+imgType));
	}

	public static void main(String[] args) throws Exception {
		PrtScUtil.printScreen("20180925_printScreen","d:/","png");
	}

}
