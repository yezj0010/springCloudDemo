package com.tomcat360.atm.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbCCheckTrans {
    private Long id;

    private String atmcSeq;

    private String atmpSeq;

    private String exSeq;

    private String checkBatchNo;

    private String equipmentId;

    private Long userId;

    private BigDecimal withdrawMoney;

    private String withdrawCurrency;

    private String deductCurrency;

    private BigDecimal deductMoney;

    private BigDecimal deductFee;

    private Date transTime;

    private String transStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtmcSeq() {
        return atmcSeq;
    }

    public void setAtmcSeq(String atmcSeq) {
        this.atmcSeq = atmcSeq == null ? null : atmcSeq.trim();
    }

    public String getAtmpSeq() {
        return atmpSeq;
    }

    public void setAtmpSeq(String atmpSeq) {
        this.atmpSeq = atmpSeq == null ? null : atmpSeq.trim();
    }

    public String getExSeq() {
        return exSeq;
    }

    public void setExSeq(String exSeq) {
        this.exSeq = exSeq == null ? null : exSeq.trim();
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getWithdrawMoney() {
        return withdrawMoney;
    }

    public void setWithdrawMoney(BigDecimal withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

    public String getWithdrawCurrency() {
        return withdrawCurrency;
    }

    public void setWithdrawCurrency(String withdrawCurrency) {
        this.withdrawCurrency = withdrawCurrency == null ? null : withdrawCurrency.trim();
    }

    public String getDeductCurrency() {
        return deductCurrency;
    }

    public void setDeductCurrency(String deductCurrency) {
        this.deductCurrency = deductCurrency == null ? null : deductCurrency.trim();
    }

    public BigDecimal getDeductMoney() {
        return deductMoney;
    }

    public void setDeductMoney(BigDecimal deductMoney) {
        this.deductMoney = deductMoney;
    }

    public BigDecimal getDeductFee() {
        return deductFee;
    }

    public void setDeductFee(BigDecimal deductFee) {
        this.deductFee = deductFee;
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus == null ? null : transStatus.trim();
    }
}