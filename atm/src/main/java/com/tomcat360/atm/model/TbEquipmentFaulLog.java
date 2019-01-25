package com.tomcat360.atm.model;

import java.util.Date;

public class TbEquipmentFaulLog {
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

    private String banknoteBoxStatus;

    private String networkStatus;

    private String transStatus;

    private String runningStatus;

    private String moduleStatus;

    private String prrStatus;

    private String cimStatus;

    private String connectStatus;

    private String maintainStatus;

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

    public String getBanknoteBoxStatus() {
        return banknoteBoxStatus;
    }

    public void setBanknoteBoxStatus(String banknoteBoxStatus) {
        this.banknoteBoxStatus = banknoteBoxStatus == null ? null : banknoteBoxStatus.trim();
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

    public String getModuleStatus() {
        return moduleStatus;
    }

    public void setModuleStatus(String moduleStatus) {
        this.moduleStatus = moduleStatus == null ? null : moduleStatus.trim();
    }

    public String getPrrStatus() {
        return prrStatus;
    }

    public void setPrrStatus(String prrStatus) {
        this.prrStatus = prrStatus == null ? null : prrStatus.trim();
    }

    public String getCimStatus() {
        return cimStatus;
    }

    public void setCimStatus(String cimStatus) {
        this.cimStatus = cimStatus == null ? null : cimStatus.trim();
    }

    public String getConnectStatus() {
        return connectStatus;
    }

    public void setConnectStatus(String connectStatus) {
        this.connectStatus = connectStatus == null ? null : connectStatus.trim();
    }

    public String getMaintainStatus() {
        return maintainStatus;
    }

    public void setMaintainStatus(String maintainStatus) {
        this.maintainStatus = maintainStatus == null ? null : maintainStatus.trim();
    }
}