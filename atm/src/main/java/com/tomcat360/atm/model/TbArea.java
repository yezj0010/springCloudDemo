package com.tomcat360.atm.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbArea {
    private Long id;

    private Long parentId;

    private String areaName;

    private Date createTime;

    private Date updateTime;

    private String status;

    private Integer areaLevel;

    private Integer orderNum;

    private BigDecimal serviceCharge;

    private String servicePhone;

    private BigDecimal withdrawSum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone == null ? null : servicePhone.trim();
    }

    public BigDecimal getWithdrawSum() {
        return withdrawSum;
    }

    public void setWithdrawSum(BigDecimal withdrawSum) {
        this.withdrawSum = withdrawSum;
    }
}