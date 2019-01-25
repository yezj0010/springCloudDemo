package com.tomcat360.admin.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbEquipment {
    private String id;

    private Long equipmentNo;

    private String country;

    private String detailAddress;

    private Date onlineTime;

    private String equipmentStatus;

    private String useStatus;

    private Date lastTransTime;

    private Integer transNum;

    private BigDecimal transAmount;

    private String verifyStatus;

    private String secondRegion;

    private String thirdRegion;

    private String fourthRegion;

    private Long countryId;

    private Long secondRegionId;

    private Long thirdRegionId;

    private Long fourthRegionId;

    private Date createTime;

    private Date downTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(Long equipmentNo) {
        this.equipmentNo = equipmentNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus == null ? null : equipmentStatus.trim();
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus == null ? null : useStatus.trim();
    }

    public Date getLastTransTime() {
        return lastTransTime;
    }

    public void setLastTransTime(Date lastTransTime) {
        this.lastTransTime = lastTransTime;
    }

    public Integer getTransNum() {
        return transNum;
    }

    public void setTransNum(Integer transNum) {
        this.transNum = transNum;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus == null ? null : verifyStatus.trim();
    }

    public String getSecondRegion() {
        return secondRegion;
    }

    public void setSecondRegion(String secondRegion) {
        this.secondRegion = secondRegion == null ? null : secondRegion.trim();
    }

    public String getThirdRegion() {
        return thirdRegion;
    }

    public void setThirdRegion(String thirdRegion) {
        this.thirdRegion = thirdRegion == null ? null : thirdRegion.trim();
    }

    public String getFourthRegion() {
        return fourthRegion;
    }

    public void setFourthRegion(String fourthRegion) {
        this.fourthRegion = fourthRegion == null ? null : fourthRegion.trim();
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getSecondRegionId() {
        return secondRegionId;
    }

    public void setSecondRegionId(Long secondRegionId) {
        this.secondRegionId = secondRegionId;
    }

    public Long getThirdRegionId() {
        return thirdRegionId;
    }

    public void setThirdRegionId(Long thirdRegionId) {
        this.thirdRegionId = thirdRegionId;
    }

    public Long getFourthRegionId() {
        return fourthRegionId;
    }

    public void setFourthRegionId(Long fourthRegionId) {
        this.fourthRegionId = fourthRegionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }
}