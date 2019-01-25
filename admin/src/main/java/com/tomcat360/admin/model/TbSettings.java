package com.tomcat360.admin.model;

import java.util.Date;

public class TbSettings {
    private Long id;

    private String settingsCode;

    private String settingsNameCn;

    private String settingsNameEn;

    private String settingsType;

    private String settingsValue;

    private String status;

    private String settingsValueType;

    private String remark;

    private String ext1;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSettingsCode() {
        return settingsCode;
    }

    public void setSettingsCode(String settingsCode) {
        this.settingsCode = settingsCode == null ? null : settingsCode.trim();
    }

    public String getSettingsNameCn() {
        return settingsNameCn;
    }

    public void setSettingsNameCn(String settingsNameCn) {
        this.settingsNameCn = settingsNameCn == null ? null : settingsNameCn.trim();
    }

    public String getSettingsNameEn() {
        return settingsNameEn;
    }

    public void setSettingsNameEn(String settingsNameEn) {
        this.settingsNameEn = settingsNameEn == null ? null : settingsNameEn.trim();
    }

    public String getSettingsType() {
        return settingsType;
    }

    public void setSettingsType(String settingsType) {
        this.settingsType = settingsType == null ? null : settingsType.trim();
    }

    public String getSettingsValue() {
        return settingsValue;
    }

    public void setSettingsValue(String settingsValue) {
        this.settingsValue = settingsValue == null ? null : settingsValue.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSettingsValueType() {
        return settingsValueType;
    }

    public void setSettingsValueType(String settingsValueType) {
        this.settingsValueType = settingsValueType == null ? null : settingsValueType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}