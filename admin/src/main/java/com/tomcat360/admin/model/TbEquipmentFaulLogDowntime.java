package com.tomcat360.admin.model;

import java.util.Date;

public class TbEquipmentFaulLogDowntime {
	private Long id;

	private String equipmentId;

	private String ifDown;

	private String downReason;

	private Date downTime;

	private Date recoveryTime;

	private String keyBord;

	private String teller;

	private String printer;

	private Date createTime;

	private String banknoteBox;

	private String networkStatus;

	private String transStatus;

	private String runningStatus;

	private String country;

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

	public String getIfDown() {
		return ifDown;
	}

	public void setIfDown(String ifDown) {
		this.ifDown = ifDown == null ? null : ifDown.trim();
	}

	public String getDownReason() {
		return downReason;
	}

	public void setDownReason(String downReason) {
		this.downReason = downReason == null ? null : downReason.trim();
	}

	public Date getDownTime() {
		return downTime;
	}

	public void setDownTime(Date downTime) {
		this.downTime = downTime;
	}

	public Date getRecoveryTime() {
		return recoveryTime;
	}

	public void setRecoveryTime(Date recoveryTime) {
		this.recoveryTime = recoveryTime;
	}

	public String getKeyBord() {
		return keyBord;
	}

	public void setKeyBord(String keyBord) {
		this.keyBord = keyBord == null ? null : keyBord.trim();
	}

	public String getTeller() {
		return teller;
	}

	public void setTeller(String teller) {
		this.teller = teller == null ? null : teller.trim();
	}

	public String getPrinter() {
		return printer;
	}

	public void setPrinter(String printer) {
		this.printer = printer == null ? null : printer.trim();
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

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus == null ? null : networkStatus.trim();
	}

	public String getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus == null ? null : transStatus.trim();
	}

	public String getRunningStatus() {
		return runningStatus;
	}

	public void setRunningStatus(String runningStatus) {
		this.runningStatus = runningStatus == null ? null : runningStatus.trim();
	}
}