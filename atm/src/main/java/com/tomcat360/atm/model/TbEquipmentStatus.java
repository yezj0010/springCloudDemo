package com.tomcat360.atm.model;

import java.util.Date;

public class TbEquipmentStatus {
    private String id;

    private String transStatus;

    private String runningStatus;

    private String moduleStatus;

    private String banknoteBoxStatus;

    private String networkStatus;

    private Date updateTime;

    private Date transTime;

    private String equipmentNo;

    private String prrStatus;

    private String cimStatus;

    private String maintainStatus;

    private String connectStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo == null ? null : equipmentNo.trim();
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

    public String getMaintainStatus() {
        return maintainStatus;
    }

    public void setMaintainStatus(String maintainStatus) {
        this.maintainStatus = maintainStatus == null ? null : maintainStatus.trim();
    }

    public String getConnectStatus() {
        return connectStatus;
    }

    public void setConnectStatus(String connectStatus) {
        this.connectStatus = connectStatus == null ? null : connectStatus.trim();
    }
}