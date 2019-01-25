package com.tomcat360.admin.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.Region;

import com.tomcat360.admin.model.TbCheckResult;
import com.tomcat360.admin.model.TbMerchantAccount;

public class PoiUtil {
	private String timeZone;

	public PoiUtil(String timeZone) {
		this.timeZone = timeZone;
	}

	@SuppressWarnings("deprecation")
	public String createExcel(HttpServletResponse response, List<Map<String, Object>> list) throws IOException {
		int maxColumn = 10;
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("监控管理列表");

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		HSSFFont font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 16);// 设置字体大小
		Region region1 = new Region(0, (short) 0, 0, (short) 10);// 参数1：行号
																	// 参数2：起始列号
																	// 参数3：行号
																	// 参数4：终止列号
		cellStyle.setFont(font);

		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("设备监控列表");
		cell.setCellStyle(cellStyle);
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(region1);
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		cellStyle = wb.createCellStyle();
		HSSFFont createFont = wb.createFont();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		createFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		cellStyle.setFont(createFont);
		HSSFCell createCell = row2.createCell(0);
		createCell.setCellStyle(cellStyle);
		createCell.setCellValue("设备编号");
		
		HSSFCell createCell1 = row2.createCell(1);
		createCell1.setCellStyle(cellStyle);
		createCell1.setCellValue("整机状态");
		
		HSSFCell createCell2 = row2.createCell(2);
		createCell2.setCellStyle(cellStyle);
		createCell2.setCellValue("安全门");
		
		HSSFCell createCell3 = row2.createCell(3);
		createCell3.setCellStyle(cellStyle);
		createCell3.setCellValue("钞箱模块");
		HSSFCell createCell4 = row2.createCell(4);
		createCell4.setCellStyle(cellStyle);
		createCell4.setCellValue("取款模块");
		
		HSSFCell createCell5 = row2.createCell(5);
		createCell5.setCellStyle(cellStyle);
		createCell5.setCellValue("凭条模块");
		
		HSSFCell createCell6 = row2.createCell(6);
		createCell6.setCellStyle(cellStyle);
		createCell6.setCellValue("凭条纸状态");
		
		HSSFCell createCell7 = row2.createCell(7);
		createCell7.setCellStyle(cellStyle);
		createCell7.setCellValue("网络状态");
		
		HSSFCell createCell8 = row2.createCell(8);
		createCell8.setCellStyle(cellStyle);
		createCell8.setCellValue("维护状态");
		
		HSSFCell createCell9 = row2.createCell(9);
		createCell9.setCellStyle(cellStyle);
		createCell9.setCellValue("交易时间");
		
		HSSFCell createCell10 = row2.createCell(10);
		createCell10.setCellStyle(cellStyle);
		createCell10.setCellValue("无交易时长");

		// 在sheet里创建第二行
		int a = 2;
		if (list == null) {
			list = new ArrayList<Map<String, Object>>();
		}
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> tbEquipmentStatus = list.get(i);
			sheet.autoSizeColumn(a);
			HSSFRow row3 = sheet.createRow(a);
			// 创建单元格并设置单元格内容
			row3.createCell(0).setCellValue((String) tbEquipmentStatus.get("id"));

			String transStatus = tbEquipmentStatus.get("transStatus") == null ? ""
					: (String) tbEquipmentStatus.get("transStatus");
			String transStatusShow = "";
			if (transStatus != null && transStatus.equals("0")) {
				transStatusShow = "纸满";
			} else if ("1".equals(transStatus)) {
				transStatusShow = "纸少";
			} else if ("2".equals(transStatus)) {
				transStatusShow = "无纸";
			} else if ("3".equals(transStatus)) {
				transStatusShow = "未知";
			} else if ("4".equals(transStatus)) {
				transStatusShow = "暂停服务";
			} else if ("9".equals(transStatus)) {
				transStatusShow = "初始化";
			}
			row3.createCell(6).setCellValue(transStatusShow);

			String runningStatus = tbEquipmentStatus.get("runningStatus") == null ? ""
					: (String) tbEquipmentStatus.get("runningStatus");
			String runningStatusShow = "";
			if (runningStatus != null && runningStatus.equals("0")) {
				runningStatusShow = "正常";
			} else if ("1".equals(runningStatus)) {
				runningStatusShow = "未激活";
			} else if ("2".equals(runningStatus)) {
				runningStatusShow = "停用";
			} else if ("3".equals(runningStatus)) {
				runningStatusShow = "异常";
			}
			row3.createCell(1).setCellValue(runningStatusShow);

			String moduleStatus = tbEquipmentStatus.get("moduleStatus") == null ? ""
					: (String) tbEquipmentStatus.get("moduleStatus");
			String moduleStatusShow = "";
			if (moduleStatus != null && moduleStatus.equals("0")) {
				moduleStatusShow = "开";
			} else if ("1".equals(moduleStatus)) {
				moduleStatusShow = "关";
			} else if ("3".equals(moduleStatus)) {
				moduleStatusShow = "未知";
			} else if ("4".equals(moduleStatus)) {
				moduleStatusShow = "停用";
			} else if ("9".equals(moduleStatus)) {
				moduleStatusShow = "初始化";
			}
			row3.createCell(2).setCellValue(moduleStatusShow);

			String banknoteBoxStatus = tbEquipmentStatus.get("banknoteBoxStatus") == null ? ""
					: (String) tbEquipmentStatus.get("banknoteBoxStatus");
			String banknoteBoxStatusShow = "";
			if (banknoteBoxStatus != null && banknoteBoxStatus.equals("0")) {
				banknoteBoxStatusShow = "正常";
			} else if ("1".equals(banknoteBoxStatus)) {
				banknoteBoxStatusShow = "缺钞";
			} else if ("2".equals(banknoteBoxStatus)) {
				banknoteBoxStatusShow = "空";
			} else if ("4".equals(banknoteBoxStatus)) {
				banknoteBoxStatusShow = "未知";
			} else if ("5".equals(banknoteBoxStatus)) {
				banknoteBoxStatusShow = "暂停服务";
			} else if ("9".equals(banknoteBoxStatus)) {
				banknoteBoxStatusShow = "初始化";
			}

			row3.createCell(3).setCellValue(banknoteBoxStatusShow);

			String networkStatus = tbEquipmentStatus.get("networkStatus") == null ? ""
					: (String) tbEquipmentStatus.get("networkStatus");
			String networkStatusShow = "";
			if (networkStatus != null && networkStatus.equals("0")) {
				networkStatusShow = "正常";
			} else if ("1".equals(networkStatus)) {
				networkStatusShow = "设备异常 ";
			} else if ("3".equals(networkStatus)) {
				networkStatusShow = "未知状态";
			} else if ("4".equals(networkStatus)) {
				networkStatusShow = "暂停服务";
			} else if ("9".equals(networkStatus)) {
				networkStatusShow = "初始化";
			}
			row3.createCell(4).setCellValue(networkStatusShow);

			String prrStatus = tbEquipmentStatus.get("prrStatus") == null ? ""
					: (String) tbEquipmentStatus.get("prrStatus");
			String prrStatusShow = "";
			if (prrStatus != null && prrStatus.equals("0")) {
				prrStatusShow = "正常";
			} else if ("1".equals(prrStatus)) {
				prrStatusShow = "离线";
			} else if ("2".equals(prrStatus)) {
				prrStatusShow = "无法交易";
			} else if ("3".equals(prrStatus)) {
				prrStatusShow = "未知";
			} else if ("4".equals(prrStatus)) {
				prrStatusShow = "暂停服务";
			} else if ("9".equals(prrStatus)) {
				prrStatusShow = "初始化";
			}
			row3.createCell(5).setCellValue(prrStatusShow);

			String connectStatus = tbEquipmentStatus.get("connectStatus") == null ? ""
					: (String) tbEquipmentStatus.get("connectStatus");
			String connectStatusShow = "";
			if (connectStatus != null && connectStatus.equals("0")) {
				connectStatusShow = "正常";
			} else if ("1".equals(connectStatus)) {
				connectStatusShow = "断网";
			} else if ("9".equals(connectStatus)) {
				connectStatusShow = "初始化";
			}
			row3.createCell(7).setCellValue(connectStatusShow);

			String maintainStatus = tbEquipmentStatus.get("maintainStatus") == null ? ""
					: (String) tbEquipmentStatus.get("maintainStatus");
			String maintainStatusShow = "";
			if (maintainStatus != null && maintainStatus.equals("0")) {
				maintainStatusShow = "未维护";
			} else if ("1".equals(maintainStatus)) {
				maintainStatusShow = "维护中";
			}
			row3.createCell(8).setCellValue(maintainStatusShow);

			String transTime = tbEquipmentStatus.get("transTime") == null ? null
					: (String) tbEquipmentStatus.get("transTime");

			// 判断是否有交易时间
			if (transTime != null && !transTime.equals("")) {

				row3.createCell(9)
						.setCellValue(tbEquipmentStatus.get("updateTime") == null ? ""
								: CalendarUtil.localDateToUTCStr((Date) tbEquipmentStatus.get("updateTime"),
										"yyyy-MM-dd HH:mm:ss"));

				row3.createCell(10).setCellValue(transTime);

			} else {
				row3.createCell(9).setCellValue("");
				row3.createCell(10).setCellValue("");
			}
			a++;
		}
		HSSFRow row3 = sheet.createRow(a);
		HSSFCell createCell11 = row3.createCell(0);
		createCell11.setCellStyle(cellStyle);
		createCell11.setCellValue("UTC：世界标准时间");

		// 列宽自适应，只对英文和数字有效
		for (int i = 0; i <= maxColumn; i++) {
			sheet.autoSizeColumn(i);
		}
		// 获取当前列的宽度，然后对比本列的长度，取最大值
		for (int columnNum = 0; columnNum <= maxColumn; columnNum++) {
			int columnWidth = sheet.getColumnWidth(columnNum) / 256;
			for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
				Row currentRow;
				// 当前行未被使用过
				if (sheet.getRow(rowNum) == null) {
					currentRow = sheet.createRow(rowNum);
				} else {
					currentRow = sheet.getRow(rowNum);
				}

				if (currentRow.getCell(columnNum) != null) {
					Cell currentCell = currentRow.getCell(columnNum);
					int length = currentCell.toString().getBytes("GBK").length;
					if (columnWidth < length + 1) {
						columnWidth = length + 1;
					}
				}
			}
			sheet.setColumnWidth(columnNum, columnWidth * 256);
		}

		String today = new SimpleDateFormat("yyyy年MM月dd日HH时dd分ss秒").format(new Date());
		String fileName = "监控管理_" + today;
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1") + ".xls");
		response.setContentType("application/msexcel");
		wb.write(output);
		output.close();
		return null;
	}

	public void exportEquipmentNum(HttpServletResponse response, List<Map<String, Object>> list) throws IOException {
		int maxColumn = 9;
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("设备统计列表");

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		HSSFFont font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 16);// 设置字体大小
		cellStyle.setFont(font);

		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("设备统计列表");
		cell.setCellStyle(cellStyle);
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, maxColumn));
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		cellStyle = wb.createCellStyle();
		HSSFFont createFont = wb.createFont();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		createFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		cellStyle.setFont(createFont);
		
		HSSFCell createCell = row2.createCell(0);
		createCell.setCellStyle(cellStyle);
		createCell.setCellValue("设备编号");
		
		HSSFCell createCell1 = row2.createCell(1);
		createCell1.setCellStyle(cellStyle);
		createCell1.setCellValue("所在地区");
		
		HSSFCell createCell2 = row2.createCell(2);
		createCell2.setCellStyle(cellStyle);
		createCell2.setCellValue("详细地址");
		
		HSSFCell createCell3 = row2.createCell(3);
		createCell3.setCellStyle(cellStyle);
		createCell3.setCellValue("安装位置");
		
		HSSFCell createCell4 = row2.createCell(4);
		createCell4.setCellStyle(cellStyle);
		createCell4.setCellValue("设备类型");
		
		HSSFCell createCell5 = row2.createCell(5);
		createCell5.setCellStyle(cellStyle);
		createCell5.setCellValue("币种");
		
		HSSFCell createCell6 = row2.createCell(6);
		createCell6.setCellStyle(cellStyle);
		createCell6.setCellValue("设备状态");
		
		HSSFCell createCell7 = row2.createCell(7);
		createCell7.setCellStyle(cellStyle);
		createCell7.setCellValue("上线时间");
		
		HSSFCell createCell8 = row2.createCell(8);
		createCell8.setCellStyle(cellStyle);
		createCell8.setCellValue("停机时间");
		
		HSSFCell createCell9 = row2.createCell(9);
		createCell9.setCellStyle(cellStyle);
		createCell9.setCellValue("操作用户");

		// 在sheet里创建第二行
		int a = 2;
		if (list == null) {
			list = new ArrayList<Map<String, Object>>();
		}
		for (int i = 0; i < list.size(); i++) {

			Map<String, Object> map = list.get(i);
			sheet.autoSizeColumn(a);
			HSSFRow row3 = sheet.createRow(a);
			// 创建单元格并设置单元格内容
			// 设备编号
			row3.createCell(0).setCellValue((String) map.get("id"));
			// 所在区
			row3.createCell(1).setCellValue(map.get("country") == null ? "" : (String) map.get("country"));
			// 地址
			row3.createCell(2).setCellValue(map.get("detailAddress") == "" ? null : (String) map.get("detailAddress"));
			// 安装位置
			row3.createCell(3)
					.setCellValue(map.get("installLocation") == "" ? null : (String) map.get("installLocation"));

			// 设备类型
			String etype = map.get("equipmentType") == null ? "" : (String) map.get("equipmentType");
			String etypeShow = "";
			if (etype != null && etype.equals("0")) {
				etypeShow = "取款";
			} else if (etype != null && etype.equals("1")) {
				etypeShow = "存取款";
			}
			row3.createCell(4).setCellValue(etypeShow);
			// 币种
			row3.createCell(5)
					.setCellValue(map.get("equipmentSubType") == null ? "" : (String) map.get("equipmentSubType"));

			// 设备状态
			String runningStatus = map.get("runningStatus") == null ? "" : (String) map.get("runningStatus");
			String runningStatusShow = "";
			if (runningStatus != null && runningStatus.equals("0")) {
				runningStatusShow = "正常";
			} else if ("1".equals(runningStatus)) {
				runningStatusShow = "未激活";
			} else if ("2".equals(runningStatus)) {
				runningStatusShow = "停用";
			} else if ("3".equals(runningStatus)) {
				runningStatusShow = "异常";
			}
			row3.createCell(6).setCellValue(runningStatusShow);
			// 上线时间
			Date onlineTime = map.get("onlineTime") == null ? null : (Date) map.get("onlineTime");
			row3.createCell(7).setCellValue(CalendarUtil.localDateToUTCStr(onlineTime, CalendarUtil.DATE_FMT_5));
			// 停机时间
			Date downTime = map.get("downTime") == null ? null : (Date) map.get("downTime");
			row3.createCell(8).setCellValue(CalendarUtil.localDateToUTCStr(downTime, CalendarUtil.DATE_FMT_5));

			String createAdminName = map.get("createAdminName") == null ? "" : (String) map.get("createAdminName");
			row3.createCell(9).setCellValue(createAdminName);
			a++;
		}
		HSSFRow row3 = sheet.createRow(a);
		HSSFCell createCell10 = row3.createCell(0);
		createCell10.setCellStyle(cellStyle);
		createCell10.setCellValue("UTC：世界标准时间");

		for (int i = 0; i <= maxColumn; i++) {
			sheet.autoSizeColumn(i);
		}
		// 获取当前列的宽度，然后对比本列的长度，取最大值
		for (int columnNum = 0; columnNum <= maxColumn; columnNum++) {
			int columnWidth = sheet.getColumnWidth(columnNum) / 256;
			for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
				Row currentRow;
				// 当前行未被使用过
				if (sheet.getRow(rowNum) == null) {
					currentRow = sheet.createRow(rowNum);
				} else {
					currentRow = sheet.getRow(rowNum);
				}

				if (currentRow.getCell(columnNum) != null) {
					Cell currentCell = currentRow.getCell(columnNum);
					int length = currentCell.toString().getBytes("GBK").length;
					if (columnWidth < length + 1) {
						columnWidth = length + 1;
					}
				}
			}
			sheet.setColumnWidth(columnNum, columnWidth * 256);
		}

		String today = new SimpleDateFormat("yyyy年MM月dd日HH时dd分ss秒").format(new Date());
		// String fileName = "equipmentNum_" + today;
		String fileName = "设备统计_" + today;
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1") + ".xls");
		response.setContentType("application/msexcel");
		wb.write(output);
		output.close();
	}

	public Sheet autoSize(int maxColumn, Sheet sheet) throws UnsupportedEncodingException {

		return sheet;
	}

	public void exportFindFaultEquipment(HttpServletResponse response, List<Map<String, Object>> list)
			throws IOException {
		int maxColumn = 10;
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("故障统计列表");
		// 设备字体和居中
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		HSSFFont font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 16);// 设置字体大小
		cellStyle.setFont(font);

		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("故障统计列表");
		cell.setCellStyle(cellStyle);
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, maxColumn));
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		cellStyle = wb.createCellStyle();
		HSSFFont createFont = wb.createFont();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		createFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		cellStyle.setFont(createFont);
		
		HSSFCell createCell = row2.createCell(0);
		createCell.setCellStyle(cellStyle);
		createCell.setCellValue("设备编号");
		
		HSSFCell createCell1 = row2.createCell(1);
		createCell1.setCellStyle(cellStyle);
		createCell1.setCellValue("所在地区");
		
		HSSFCell createCell2 = row2.createCell(2);
		createCell2.setCellStyle(cellStyle);
		createCell2.setCellValue("详细地址");
		
		HSSFCell createCell3 = row2.createCell(3);
		createCell3.setCellStyle(cellStyle);
		createCell3.setCellValue("安装位置");
		
		HSSFCell createCell4 = row2.createCell(4);
		createCell4.setCellStyle(cellStyle);
		createCell4.setCellValue("维护次数");
		
		HSSFCell createCell5 = row2.createCell(5);
		createCell5.setCellStyle(cellStyle);
		createCell5.setCellValue("安全门");
		
		HSSFCell createCell6 = row2.createCell(6);
		createCell6.setCellStyle(cellStyle);
		createCell6.setCellValue("钞箱");
		
		HSSFCell createCell7 = row2.createCell(7);
		createCell7.setCellStyle(cellStyle);
		createCell7.setCellValue("取款模块");
		
		HSSFCell createCell8 = row2.createCell(8);
		createCell8.setCellStyle(cellStyle);
		createCell8.setCellValue("凭条模块");
		
		HSSFCell createCell9 = row2.createCell(9);
		createCell9.setCellStyle(cellStyle);
		createCell9.setCellValue("凭条纸");
		
		HSSFCell createCell10 = row2.createCell(10);
		createCell10.setCellStyle(cellStyle);
		createCell10.setCellValue("网络状态");
		// 在sheet里创建第二行
		int a = 2;
		if (list == null) {
			list = new ArrayList<Map<String, Object>>();
		}
		for (int i = 0; i < list.size(); i++) {

			Map<String, Object> map = list.get(i);
			sheet.autoSizeColumn(a);
			HSSFRow row3 = sheet.createRow(a);
			// 创建单元格并设置单元格内容
			// 设备编号
			row3.createCell(0).setCellValue(map.get("equipmentId").toString());
			// 所在区
			row3.createCell(1).setCellValue(map.get("country") == null ? "" : map.get("country").toString());
			// 地址
			row3.createCell(2)
					.setCellValue(map.get("detailAddress") == null ? "" : map.get("detailAddress").toString());
			String moduleStatus = map.get("moduleStatusNum") == null ? "" : map.get("moduleStatusNum").toString();
			String banknoteBoxStatus = map.get("banknoteBoxStatusNum") == null ? ""
					: map.get("banknoteBoxStatusNum").toString();
			String networkStatus = map.get("networkStatusNum") == null ? "" : map.get("networkStatusNum").toString();
			String prrStatus = map.get("prrStatusNum") == null ? "" : map.get("prrStatusNum").toString();
			String transStatus = map.get("transStatusNum") == null ? "" : map.get("transStatusNum").toString();
			String connectStatus = map.get("connectStatusNum") == null ? "" : map.get("connectStatusNum").toString();
			String maintainStatus = map.get("maintainStatusNum") == null ? "" : map.get("maintainStatusNum").toString();
			row3.createCell(3)
					.setCellValue(map.get("installLocation") == null ? "" : map.get("installLocation").toString());

			if (maintainStatus.equals("0")) {
				maintainStatus = "-";
			}
			row3.createCell(4).setCellValue(maintainStatus);

			if (moduleStatus.equals("0")) {
				moduleStatus = "-";
			}
			row3.createCell(5).setCellValue(moduleStatus);

			if (banknoteBoxStatus.equals("0")) {
				banknoteBoxStatus = "-";
			}
			row3.createCell(6).setCellValue(banknoteBoxStatus);

			if (networkStatus.equals("0")) {
				networkStatus = "-";
			}
			row3.createCell(7).setCellValue(networkStatus);

			if (prrStatus.equals("0")) {
				prrStatus = "-";
			}
			row3.createCell(8).setCellValue(prrStatus);

			if (transStatus.equals("0")) {
				transStatus = "-";
			}
			row3.createCell(9).setCellValue(transStatus);

			if (connectStatus.equals("0")) {
				connectStatus = "-";
			}
			row3.createCell(10).setCellValue(connectStatus);

			a++;
		}
		HSSFRow row3 = sheet.createRow(a);
		HSSFCell createCell11 = row3.createCell(0);
		createCell11.setCellStyle(cellStyle);
		createCell11.setCellValue("统计单位：异常次数");

		for (int i = 0; i <= maxColumn; i++) {
			sheet.autoSizeColumn(i);
		}
		// 获取当前列的宽度，然后对比本列的长度，取最大值
		for (int columnNum = 0; columnNum <= maxColumn; columnNum++) {
			int columnWidth = sheet.getColumnWidth(columnNum) / 256;
			for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
				Row currentRow;
				// 当前行未被使用过
				if (sheet.getRow(rowNum) == null) {
					currentRow = sheet.createRow(rowNum);
				} else {
					currentRow = sheet.getRow(rowNum);
				}

				if (currentRow.getCell(columnNum) != null) {
					Cell currentCell = currentRow.getCell(columnNum);
					int length = currentCell.toString().getBytes("GBK").length;
					if (columnWidth < length + 1) {
						columnWidth = length + 1;
					}
				}
			}
			sheet.setColumnWidth(columnNum, columnWidth * 256);
		}

		String today = new SimpleDateFormat("yyyy年MM月dd日HH时dd分ss秒").format(new Date());
		String fileName = "故障统计_" + today;
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1") + ".xls");
		response.setContentType("application/msexcel");
		wb.write(output);
		output.close();
	}

	public void exportWithdrawInfo(List<Map<String, Object>> list, HttpServletResponse response, boolean flag)
			throws IOException {
		int maxColumn = 10;
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("取款明细");

		// 设备字体和居中
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		HSSFFont font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 16);// 设置字体大小
		cellStyle.setFont(font);

		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("取款明细列表");
		cell.setCellStyle(cellStyle);
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, maxColumn));
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		cellStyle = wb.createCellStyle();
		HSSFFont createFont = wb.createFont();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		createFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		cellStyle.setFont(createFont);
		
		HSSFCell createCell = row2.createCell(0);
		createCell.setCellStyle(cellStyle);
		createCell.setCellValue("ATMC流水号");
		
		HSSFCell createCell1 = row2.createCell(1);
		createCell1.setCellStyle(cellStyle);
		createCell1.setCellValue("ATMP流水号");
		
		HSSFCell createCell2 = row2.createCell(2);
		createCell2.setCellStyle(cellStyle);
		createCell2.setCellValue("交易所流水号");
		
		HSSFCell createCell3 = row2.createCell(3);
		createCell3.setCellStyle(cellStyle);
		createCell3.setCellValue("ATM设备号");
		
		HSSFCell createCell4 = row2.createCell(4);
		createCell4.setCellStyle(cellStyle);
		createCell4.setCellValue("用户账号");
		
		HSSFCell createCell5 = row2.createCell(5);
		createCell5.setCellStyle(cellStyle);
		createCell5.setCellValue("取款金额");
		
		HSSFCell createCell6 = row2.createCell(6);
		createCell6.setCellStyle(cellStyle);
		createCell6.setCellValue("行情");
		
		HSSFCell createCell7 = row2.createCell(7);
		createCell7.setCellStyle(cellStyle);
		createCell7.setCellValue("取款花费");
		
		HSSFCell createCell8 = row2.createCell(8);
		createCell8.setCellStyle(cellStyle);
		createCell8.setCellValue("手续费");
		
		HSSFCell createCell9 = row2.createCell(9);
		createCell9.setCellStyle(cellStyle);
		createCell9.setCellValue("交易时间");
		
		HSSFCell createCell10 = row2.createCell(10);
		createCell10.setCellStyle(cellStyle);
		createCell10.setCellValue("取款结果");

		// 在sheet里创建第二行
		int a = 2;
		if (list == null) {
			list = new ArrayList<Map<String, Object>>();
		}
		for (int i = 0; i < list.size(); i++) {

			Map<String, Object> map = list.get(i);
			sheet.autoSizeColumn(a);
			HSSFRow row3 = sheet.createRow(a);
			// ATMC端流水
			row3.createCell(0)
					.setCellValue(map.get("equipmentLogSeq") == null ? "" : map.get("equipmentLogSeq").toString());
			// ATMP端流水
			row3.createCell(1).setCellValue(map.get("id") == null ? "" : map.get("id").toString());
			// 交易所流水号
			row3.createCell(2).setCellValue(map.get("exTransSeq") == null ? "" : map.get("exTransSeq").toString());
			// ATM设备号
			row3.createCell(3).setCellValue(map.get("equipmentId") == null ? "" : map.get("equipmentId").toString());

			// 用户id
			row3.createCell(4).setCellValue(map.get("userName") == null ? "" : map.get("userName").toString());
			// 取款金额
			row3.createCell(5)
					.setCellValue(map.get("withdrawMoney") == null ? "" : map.get("withdrawMoney").toString());
			// 行情
			row3.createCell(6).setCellValue(map.get("price") == null ? "" : map.get("price").toString());
			// 取款花费
			row3.createCell(7).setCellValue(map.get("deductMoney") == null ? "" : map.get("deductMoney").toString());
			// 手续费
			row3.createCell(8).setCellValue(map.get("transFee") == null ? "" : map.get("transFee").toString());
			// 交易时间 *
			Date transTime = map.get("transTime") == null ? null : (Date) map.get("transTime");
			row3.createCell(9).setCellValue(CalendarUtil.localDateToUTCStr(transTime, CalendarUtil.DATE_FMT_5));
			// 取款结果 *
			String stuts = map.get("status") == null ? "" : map.get("status").toString();
			String withResult = "";
			if (stuts.equals("1")) {
				withResult = "成功";
			} else if (stuts.equals("2")) {
				withResult = "失败";
			} else if (stuts.equals("4")) {
				withResult = "已冲正";
			} else if (stuts.equals("6")) {
				withResult = "吐钞中";
			} else if (stuts.equals("7")) {
				withResult = "状态不明";
			} else if (stuts.equals("0")) {
				withResult = "初始";
			} else if (stuts.equals("3")) {
				withResult = "超时";
			} else if (stuts.equals("5")) {
				withResult = "冲正异常";
			}

			row3.createCell(10).setCellValue(withResult);
			a++;
		}
		HSSFRow row3 = sheet.createRow(a);
		HSSFCell createCell11 = row3.createCell(0);
		createCell11.setCellStyle(cellStyle);
		createCell11.setCellValue("UTC：世界标准时间");

		for (int i = 0; i <= maxColumn; i++) {
			sheet.autoSizeColumn(i);
		}
		// 获取当前列的宽度，然后对比本列的长度，取最大值
		for (int columnNum = 0; columnNum <= maxColumn; columnNum++) {
			int columnWidth = sheet.getColumnWidth(columnNum) / 256;
			for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
				Row currentRow;
				// 当前行未被使用过
				if (sheet.getRow(rowNum) == null) {
					currentRow = sheet.createRow(rowNum);
				} else {
					currentRow = sheet.getRow(rowNum);
				}

				if (currentRow.getCell(columnNum) != null) {
					Cell currentCell = currentRow.getCell(columnNum);
					int length = currentCell.toString().getBytes("GBK").length;
					if (columnWidth < length + 1) {
						columnWidth = length + 1;
					}
				}
			}
			sheet.setColumnWidth(columnNum, columnWidth * 256);
		}

		String today = new SimpleDateFormat("yyyy年MM月dd日HH时dd分ss秒").format(new Date());
		String fileName = "取款明细_" + today;
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1") + ".xls");
		response.setContentType("application/msexcel");
		wb.write(output);
		output.close();
	}

	public void exportOperateAccountInfo(List<Map<String, Object>> list, HttpServletResponse response)
			throws IOException {
		int maxColumn = 4;

		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("账户列表");

		// 设备字体和居中
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		HSSFFont font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 16);// 设置字体大小
		cellStyle.setFont(font);

		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("运营账户信息列表");
		cell.setCellStyle(cellStyle);
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, maxColumn));
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		cellStyle = wb.createCellStyle();
		HSSFFont createFont = wb.createFont();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		createFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		cellStyle.setFont(createFont);
		
		HSSFCell createCell = row2.createCell(0);
		createCell.setCellStyle(cellStyle);
		createCell.setCellValue("商户号");
		
		HSSFCell createCell1 = row2.createCell(1);
		createCell1.setCellStyle(cellStyle);
		createCell1.setCellValue("币种");
		
		HSSFCell createCell2 = row2.createCell(2);
		createCell2.setCellStyle(cellStyle);
		createCell2.setCellValue("账户地址");
		
		HSSFCell createCell3 = row2.createCell(3);
		createCell3.setCellStyle(cellStyle);
		createCell3.setCellValue("账户余额");
		
		HSSFCell createCell4 = row2.createCell(4);
		createCell4.setCellStyle(cellStyle);
		createCell4.setCellValue("充值总计");
		
		HSSFCell createCell5 = row2.createCell(5);
		createCell5.setCellStyle(cellStyle);
		createCell5.setCellValue("取款总计");
		
		HSSFCell createCell6 = row2.createCell(6);
		createCell6.setCellStyle(cellStyle);
		createCell6.setCellValue("取款手续费总计");

		// 在sheet里创建第二行
		int a = 2;
		if (list == null) {
			list = new ArrayList<Map<String, Object>>();
		}
		for (int i = 0; i < list.size(); i++) {

			TbMerchantAccount tbMerchantAccount = (TbMerchantAccount) list.get(i);
			sheet.autoSizeColumn(a);
			HSSFRow row3 = sheet.createRow(a);
			// 商户号
			row3.createCell(0).setCellValue(tbMerchantAccount.getMerchantNo());
			// 币种

			row3.createCell(1).setCellValue(tbMerchantAccount.getCurrency());
			// 账户地址
			row3.createCell(2).setCellValue(tbMerchantAccount.getAccountAdress());
			// 账户余额
			row3.createCell(3).setCellValue(tbMerchantAccount.getAccountBalance() == null ? ""
					: tbMerchantAccount.getAccountBalance().toString());

			// 充值总计
			row3.createCell(4).setCellValue(
					tbMerchantAccount.getTotalCharge() == null ? "" : tbMerchantAccount.getTotalCharge().toString());

			// 取款总计
			row3.createCell(5).setCellValue(tbMerchantAccount.getTotalWithdrawal() == null ? ""
					: tbMerchantAccount.getTotalWithdrawal().toString());

			// 取款手续费总计
			row3.createCell(6).setCellValue(tbMerchantAccount.getTotalWithdrawalFee() == null ? ""
					: tbMerchantAccount.getTotalWithdrawalFee().toString());
			a++;
		}

		for (int i = 0; i <= maxColumn; i++) {
			sheet.autoSizeColumn(i);
		}
		// 获取当前列的宽度，然后对比本列的长度，取最大值
		for (int columnNum = 0; columnNum <= maxColumn; columnNum++) {
			int columnWidth = sheet.getColumnWidth(columnNum) / 256;
			for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
				Row currentRow;
				// 当前行未被使用过
				if (sheet.getRow(rowNum) == null) {
					currentRow = sheet.createRow(rowNum);
				} else {
					currentRow = sheet.getRow(rowNum);
				}

				if (currentRow.getCell(columnNum) != null) {
					Cell currentCell = currentRow.getCell(columnNum);
					int length = currentCell.toString().getBytes("GBK").length;
					if (columnWidth < length + 1) {
						columnWidth = length + 1;
					}
				}
			}
			sheet.setColumnWidth(columnNum, columnWidth * 256);
		}

		String today = new SimpleDateFormat("yyyy年MM月dd日HH时dd分ss秒").format(new Date());
		String fileName = "商户账户信息列表_" + today;
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1") + ".xls");
		response.setContentType("application/msexcel");
		wb.write(output);
		output.close();
	}

	public void exportCheckResultList(List<TbCheckResult> list, HttpServletResponse response, String type)
			throws IOException {
		int maxColumn = 9;

		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		String excelTitle = "";
		if (type.equals("0")) {
			excelTitle = "本地对账列表";
		} else if (type.equals("1")) {
			excelTitle = "交易所对账列表";
		}
		HSSFSheet sheet = wb.createSheet(excelTitle);

		// 设备字体和居中
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		HSSFFont font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 16);// 设置字体大小
		cellStyle.setFont(font);

		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue(excelTitle + "列表");
		cell.setCellStyle(cellStyle);
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, maxColumn));
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		cellStyle = wb.createCellStyle();
		HSSFFont createFont = wb.createFont();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		createFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		cellStyle.setFont(createFont);
		
		HSSFCell createCell = row2.createCell(0);
		createCell.setCellStyle(cellStyle);
		createCell.setCellValue("对账批次");
		
		HSSFCell createCell1 = row2.createCell(1);
		createCell1.setCellStyle(cellStyle);
		createCell1.setCellValue("设备编号");
		
		HSSFCell createCell2 = row2.createCell(2);
		createCell2.setCellStyle(cellStyle);
		createCell2.setCellValue("平账金额");
		
		HSSFCell createCell3 = row2.createCell(3);
		createCell3.setCellStyle(cellStyle);
		createCell3.setCellValue("平账数");
		
		HSSFCell createCell4 = row2.createCell(4);
		createCell4.setCellStyle(cellStyle);
		createCell4.setCellValue("差错金额");
		
		HSSFCell createCell5 = row2.createCell(5);
		createCell5.setCellStyle(cellStyle);
		createCell5.setCellValue("差错笔数");
		
		HSSFCell createCell6 = row2.createCell(6);
		createCell6.setCellStyle(cellStyle);
		createCell6.setCellValue("对账时间");
		
		HSSFCell createCell7 = row2.createCell(7);
		createCell7.setCellStyle(cellStyle);
		createCell7.setCellValue("对账结果");
		
		HSSFCell createCell8 = row2.createCell(8);
		createCell8.setCellStyle(cellStyle);
		createCell8.setCellValue("人工处理结果");
		
		HSSFCell createCell9 = row2.createCell(9);
		createCell9.setCellStyle(cellStyle);
		createCell9.setCellValue("操作员");

		// 在sheet里创建第二行
		int a = 2;
		if (list == null) {
			list = new ArrayList<TbCheckResult>();
		}
		for (int i = 0; i < list.size(); i++) {
			TbCheckResult tbCheckResult = list.get(i);
			Map<String, Object> map = MapTrun.object2Map(tbCheckResult);
			sheet.autoSizeColumn(a);
			HSSFRow row3 = sheet.createRow(a);

			String checkBatchNo = map.get("checkBatchNo") == null ? "" : map.get("checkBatchNo").toString();
			String equipmentId = map.get("equipmentId") == null ? "" : map.get("equipmentId").toString();
			BigDecimal successAmount = map.get("successAmount") == null ? new BigDecimal(0)
					: (BigDecimal) map.get("successAmount");
			String successNum = map.get("successNum") == null ? "" : map.get("successNum").toString();
			BigDecimal errorAmount = map.get("errorAmount") == null ? new BigDecimal(0)
					: (BigDecimal) map.get("errorAmount");
			String errorNum = map.get("errorNum") == null ? "" : map.get("errorNum").toString();
			Date checkTime = map.get("checkTime") == null ? null : (Date) map.get("checkTime");
			String operateAdmin = map.get("operateAdmin") == null ? "" : map.get("operateAdmin").toString();

			String withdrawCurrency = map.get("withdrawCurrency") == null ? "" : map.get("withdrawCurrency").toString();
			String successAmountShow = successAmount.doubleValue() + " " + withdrawCurrency;
			String errorAmountShow = errorAmount.doubleValue() + " " + withdrawCurrency;
			String checkStatus = map.get("checkStatus") == null ? "" : map.get("checkStatus").toString();
			String checkStatusShow = "";
			if (checkStatus.equals("0")) {
				checkStatusShow = "差错";
			} else if (checkStatus.equals("1")) {
				checkStatusShow = "平账";
			}
			String operateStatus = map.get("operateStatus") == null ? "" : map.get("operateStatus").toString();
			String operateStatusShhow = "";
			if (operateStatus.equals("0")) {
				operateStatusShhow = "未平帐";
			} else if (operateStatus.equals("1")) {
				operateStatusShhow = "平账";
			}
			// 对账批次
			row3.createCell(0).setCellValue(checkBatchNo);
			// 设备编号
			row3.createCell(1).setCellValue(equipmentId);
			// 平账金额
			row3.createCell(2).setCellValue(successAmountShow);
			// 平账数
			row3.createCell(3).setCellValue(successNum);
			// 差错金额
			row3.createCell(4).setCellValue(errorAmountShow);
			// 差错数
			row3.createCell(5).setCellValue(errorNum);
			// 对账时间
			row3.createCell(6).setCellValue(CalendarUtil.localDateToUTCStr(checkTime, CalendarUtil.DATE_FMT_5));
			// 对账结果
			row3.createCell(7).setCellValue(checkStatusShow);
			// 处理结果
			row3.createCell(8).setCellValue(operateStatusShhow);
			// 处理账户
			row3.createCell(9).setCellValue(operateAdmin);

			a++;
		}

		HSSFRow row3 = sheet.createRow(a);
		HSSFCell createCell10 = row3.createCell(0);
		createCell10.setCellStyle(cellStyle);
		createCell10.setCellValue("UTC：世界标准时间");

		for (int i = 0; i <= maxColumn; i++) {
			sheet.autoSizeColumn(i);
		}
		// 获取当前列的宽度，然后对比本列的长度，取最大值
		for (int columnNum = 0; columnNum <= maxColumn; columnNum++) {
			int columnWidth = sheet.getColumnWidth(columnNum) / 256;
			for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
				Row currentRow;
				// 当前行未被使用过
				if (sheet.getRow(rowNum) == null) {
					currentRow = sheet.createRow(rowNum);
				} else {
					currentRow = sheet.getRow(rowNum);
				}

				if (currentRow.getCell(columnNum) != null) {
					Cell currentCell = currentRow.getCell(columnNum);
					int length = currentCell.toString().getBytes("GBK").length;
					if (columnWidth < length + 1) {
						columnWidth = length + 1;
					}
				}
			}
			sheet.setColumnWidth(columnNum, columnWidth * 256);
		}

		String today = new SimpleDateFormat("yyyy年MM月dd日HH时dd分ss秒").format(new Date());
		String fileName = "";
		if (type.equals("0")) {
			fileName = "本地对账_" + today;
		} else if (type.equals("1")) {
			fileName = "交易所对账_" + today;
		}

		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1") + ".xls");
		response.setContentType("application/msexcel");
		wb.write(output);
		output.close();
	}

}
