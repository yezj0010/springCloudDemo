package com.tomcat360.admin.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbCheckResult {
    private Long id;

    private String checkBatchNo;

    private String equipmentId;

    private BigDecimal successAmount;

    private Long successNum;

    private BigDecimal errorAmount;

    private Long errorNum;

    private String withdrawCurrency;

    private Date checkTime;

    private String checkStatus;

    private String operateStatus;

    private String operateAdmin;

    private Long operateAdminId;

    private String type;

    private String remark;

    private Date createTime;

    private Date updateTime;
    

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckBatchNo() {
        return checkBatchNo;
    }

    public void setCheckBatchNo(String checkBatchNo) {
        this.checkBatchNo = checkBatchNo == null ? null : checkBatchNo.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public BigDecimal getSuccessAmount() {
        return successAmount;
    }

    public void setSuccessAmount(BigDecimal successAmount) {
        this.successAmount = successAmount;
    }

    public Long getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Long successNum) {
        this.successNum = successNum;
    }

    public BigDecimal getErrorAmount() {
        return errorAmount;
    }

    public void setErrorAmount(BigDecimal errorAmount) {
        this.errorAmount = errorAmount;
    }

    public Long getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(Long errorNum) {
        this.errorNum = errorNum;
    }

    public String getWithdrawCurrency() {
        return withdrawCurrency;
    }

    public void setWithdrawCurrency(String withdrawCurrency) {
        this.withdrawCurrency = withdrawCurrency == null ? null : withdrawCurrency.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus == null ? null : operateStatus.trim();
    }

    public String getOperateAdmin() {
        return operateAdmin;
    }

    public void setOperateAdmin(String operateAdmin) {
        this.operateAdmin = operateAdmin == null ? null : operateAdmin.trim();
    }

    public Long getOperateAdminId() {
        return operateAdminId;
    }

    public void setOperateAdminId(Long operateAdminId) {
        this.operateAdminId = operateAdminId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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