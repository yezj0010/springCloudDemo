package com.tomcat360.admin.model;

import java.util.Date;

public class TbEquipmentFaulLogFault {
	private Long id;

	private String equipmentId;

	private Date createTime;

	private String banknoteBox;

	private String country;

	private String keyBordCount;

	private String tellerCount;

	private String printerCount;

	public String getKeyBordCount() {
		return keyBordCount;
	}

	public void setKeyBordCount(String keyBordCount) {
		this.keyBordCount = keyBordCount;
	}

	public String getTellerCount() {
		return tellerCount;
	}

	public void setTellerCount(String tellerCount) {
		this.tellerCount = tellerCount;
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