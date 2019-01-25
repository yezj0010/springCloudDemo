package com.tomcat360.atm.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbTrans {
    private String id;

    private String equipmentId;

    private String equipmentLogSeq;

    private String oriId;

    private Long userId;

    private String userToken;

    private String userLocalToken;

    private String interfaceCode;

    private String interfaceType;

    private String deductCurrency;

    private String withdrawCurrency;

    private BigDecimal withdrawMoney;

    private String status;

    private String respCode;

    private String respMsg;

    private Date transTime;

    private Date updateTime;

    private String exTransSeq;

    private Long exTransTime;

    private Date termDate;

    private BigDecimal transFee;

    private BigDecimal deductMoney;

    private String exCheckStatus;

    private String cCheckStatus;

    private BigDecimal price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getEquipmentLogSeq() {
        return equipmentLogSeq;
    }

    public void setEquipmentLogSeq(String equipmentLogSeq) {
        this.equipmentLogSeq = equipmentLogSeq == null ? null : equipmentLogSeq.trim();
    }

    public String getOriId() {
        return oriId;
    }

    public void setOriId(String oriId) {
        this.oriId = oriId == null ? null : oriId.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken == null ? null : userToken.trim();
    }

    public String getUserLocalToken() {
        return userLocalToken;
    }

    public void setUserLocalToken(String userLocalToken) {
        this.userLocalToken = userLocalToken == null ? null : userLocalToken.trim();
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode == null ? null : interfaceCode.trim();
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType == null ? null : interfaceType.trim();
    }

    public String getDeductCurrency() {
        return deductCurrency;
    }

    public void setDeductCurrency(String deductCurrency) {
        this.deductCurrency = deductCurrency == null ? null : deductCurrency.trim();
    }

    public String getWithdrawCurrency() {
        return withdrawCurrency;
    }

    public void setWithdrawCurrency(String withdrawCurrency) {
        this.withdrawCurrency = withdrawCurrency == null ? null : withdrawCurrency.trim();
    }

    public BigDecimal getWithdrawMoney() {
        return withdrawMoney;
    }

    public void setWithdrawMoney(BigDecimal withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode == null ? null : respCode.trim();
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg == null ? null : respMsg.trim();
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getExTransSeq() {
        return exTransSeq;
    }

    public void setExTransSeq(String exTransSeq) {
        this.exTransSeq = exTransSeq == null ? null : exTransSeq.trim();
    }

    public Long getExTransTime() {
        return exTransTime;
    }

    public void setExTransTime(Long exTransTime) {
        this.exTransTime = exTransTime;
    }

    public Date getTermDate() {
        return termDate;
    }

    public void setTermDate(Date termDate) {
        this.termDate = termDate;
    }

    public BigDecimal getTransFee() {
        return transFee;
    }

    public void setTransFee(BigDecimal transFee) {
        this.transFee = transFee;
    }

    public BigDecimal getDeductMoney() {
        return deductMoney;
    }

    public void setDeductMoney(BigDecimal deductMoney) {
        this.deductMoney = deductMoney;
    }

    public String getExCheckStatus() {
        return exCheckStatus;
    }

    public void setExCheckStatus(String exCheckStatus) {
        this.exCheckStatus = exCheckStatus == null ? null : exCheckStatus.trim();
    }

    public String getcCheckStatus() {
        return cCheckStatus;
    }

    public void setcCheckStatus(String cCheckStatus) {
        this.cCheckStatus = cCheckStatus == null ? null : cCheckStatus.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}