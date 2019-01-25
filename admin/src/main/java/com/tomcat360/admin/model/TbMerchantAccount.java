package com.tomcat360.admin.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbMerchantAccount {
    private Long id;

    private String merchantNo;

    private String accountAdress;

    private String currency;

    private BigDecimal totalWithdrawal;

    private BigDecimal totalWithdrawalFee;

    private BigDecimal totalDeposit;

    private BigDecimal totalDepositFee;

    private BigDecimal totalCharge;

    private BigDecimal totalCashOut;

    private BigDecimal totalOtherIn;

    private BigDecimal totalOtherOut;

    private BigDecimal accountBalance;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    public String getAccountAdress() {
        return accountAdress;
    }

    public void setAccountAdress(String accountAdress) {
        this.accountAdress = accountAdress == null ? null : accountAdress.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getTotalWithdrawal() {
        return totalWithdrawal;
    }

    public void setTotalWithdrawal(BigDecimal totalWithdrawal) {
        this.totalWithdrawal = totalWithdrawal;
    }

    public BigDecimal getTotalWithdrawalFee() {
        return totalWithdrawalFee;
    }

    public void setTotalWithdrawalFee(BigDecimal totalWithdrawalFee) {
        this.totalWithdrawalFee = totalWithdrawalFee;
    }

    public BigDecimal getTotalDeposit() {
        return totalDeposit;
    }

    public void setTotalDeposit(BigDecimal totalDeposit) {
        this.totalDeposit = totalDeposit;
    }

    public BigDecimal getTotalDepositFee() {
        return totalDepositFee;
    }

    public void setTotalDepositFee(BigDecimal totalDepositFee) {
        this.totalDepositFee = totalDepositFee;
    }

    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
    }

    public BigDecimal getTotalCashOut() {
        return totalCashOut;
    }

    public void setTotalCashOut(BigDecimal totalCashOut) {
        this.totalCashOut = totalCashOut;
    }

    public BigDecimal getTotalOtherIn() {
        return totalOtherIn;
    }

    public void setTotalOtherIn(BigDecimal totalOtherIn) {
        this.totalOtherIn = totalOtherIn;
    }

    public BigDecimal getTotalOtherOut() {
        return totalOtherOut;
    }

    public void setTotalOtherOut(BigDecimal totalOtherOut) {
        this.totalOtherOut = totalOtherOut;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
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