package com.tomcat360.admin.model;

import java.util.Date;

public class TbEquipmentFaulLogLackMoney {
	private Long id;

	private String equipmentId;

	private Date createTime;

	private String banknoteBox;

	private String country;

	private String banknoteBoxCount;

	private String printerCount;

	public String getBanknoteBoxCount() {
		return banknoteBoxCount;
	}

	public void setBanknoteBoxCount(String banknoteBoxCount) {
		this.banknoteBoxCount = banknoteBoxCount;
	}

	public String getPrinterCount() {
		return printerCount;
	}

	public void setPrinterCount(String printerCount) {
		this.printerCount = printerCount;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	private String detailAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId == null ? null : equipmentId.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBanknoteBox() {
		return banknoteBox;
	}

	public void setBanknoteBox(String banknoteBox) {
		this.banknoteBox = banknoteBox == null ? null : banknoteBox.trim();
	}

}