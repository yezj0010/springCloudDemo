package com.tomcat360.atm.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbEquipmentSettings {
    private String id;

    private String equipmentType;

    private String equipmentSubType;

    private String equipmentVersion;

    private String softVersion;

    private String brand;

    private String operateos;

    private String browser;

    private String installLocation;

    private String preIp;

    private String prePort;

    private String monitorPort;

    private String monitorFile;

    private String versionServerPort;

    private String versionServerFilePort;

    private String localMonitorPort;

    private String localFileMonitorPort;

    private BigDecimal limitPerDay;

    private String currencyCode;

    private String masterKey;

    private BigDecimal amount;

    private String privateKey;

    private Date onlineTime;

    private String useState;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }

    public String getEquipmentSubType() {
        return equipmentSubType;
    }

    public void setEquipmentSubType(String equipmentSubType) {
        this.equipmentSubType = equipmentSubType == null ? null : equipmentSubType.trim();
    }

    public String getEquipmentVersion() {
        return equipmentVersion;
    }

    public void setEquipmentVersion(String equipmentVersion) {
        this.equipmentVersion = equipmentVersion == null ? null : equipmentVersion.trim();
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion == null ? null : softVersion.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getOperateos() {
        return operateos;
    }

    public void setOperateos(String operateos) {
        this.operateos = operateos == null ? null : operateos.trim();
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser == null ? null : browser.trim();
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation == null ? null : installLocation.trim();
    }

    public String getPreIp() {
        return preIp;
    }

    public void setPreIp(String preIp) {
        this.preIp = preIp == null ? null : preIp.trim();
    }

    public String getPrePort() {
        return prePort;
    }

    public void setPrePort(String prePort) {
        this.prePort = prePort == null ? null : prePort.trim();
    }

    public String getMonitorPort() {
        return monitorPort;
    }

    public void setMonitorPort(String monitorPort) {
        this.monitorPort = monitorPort == null ? null : monitorPort.trim();
    }

    public String getMonitorFile() {
        return monitorFile;
    }

    public void setMonitorFile(String monitorFile) {
        this.monitorFile = monitorFile == null ? null : monitorFile.trim();
    }

    public String getVersionServerPort() {
        return versionServerPort;
    }

    public void setVersionServerPort(String versionServerPort) {
        this.versionServerPort = versionServerPort == null ? null : versionServerPort.trim();
    }

    public String getVersionServerFilePort() {
        return versionServerFilePort;
    }

    public void setVersionServerFilePort(String versionServerFilePort) {
        this.versionServerFilePort = versionServerFilePort == null ? null : versionServerFilePort.trim();
    }

    public String getLocalMonitorPort() {
        return localMonitorPort;
    }

    public void setLocalMonitorPort(String localMonitorPort) {
        this.localMonitorPort = localMonitorPort == null ? null : localMonitorPort.trim();
    }

    public String getLocalFileMonitorPort() {
        return localFileMonitorPort;
    }

    public void setLocalFileMonitorPort(String localFileMonitorPort) {
        this.localFileMonitorPort = localFileMonitorPort == null ? null : localFileMonitorPort.trim();
    }

    public BigDecimal getLimitPerDay() {
        return limitPerDay;
    }

    public void setLimitPerDay(BigDecimal limitPerDay) {
        this.limitPerDay = limitPerDay;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
    }

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey == null ? null : masterKey.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey == null ? null : privateKey.trim();
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getUseState() {
        return useState;
    }

    public void setUseState(String useState) {
        this.useState = useState == null ? null : useState.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}