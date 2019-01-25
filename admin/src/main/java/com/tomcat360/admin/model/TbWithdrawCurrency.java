package com.tomcat360.admin.model;

import java.util.Date;

public class TbWithdrawCurrency {
    private Long id;

    private Integer withdrawMoney1;

    private Integer withdrawMoney2;

    private Integer withdrawMoney3;

    private Integer withdrawMoney4;

    private Integer withdrawMoney5;

    private Integer withdrawMoney6;

    private String currencyName;

    private String status;

    private String descCny;

    private String descEn;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWithdrawMoney1() {
        return withdrawMoney1;
    }

    public void setWithdrawMoney1(Integer withdrawMoney1) {
        this.withdrawMoney1 = withdrawMoney1;
    }

    public Integer getWithdrawMoney2() {
        return withdrawMoney2;
    }

    public void setWithdrawMoney2(Integer withdrawMoney2) {
        this.withdrawMoney2 = withdrawMoney2;
    }

    public Integer getWithdrawMoney3() {
        return withdrawMoney3;
    }

    public void setWithdrawMoney3(Integer withdrawMoney3) {
        this.withdrawMoney3 = withdrawMoney3;
    }

    public Integer getWithdrawMoney4() {
        return withdrawMoney4;
    }

    public void setWithdrawMoney4(Integer withdrawMoney4) {
        this.withdrawMoney4 = withdrawMoney4;
    }

    public Integer getWithdrawMoney5() {
        return withdrawMoney5;
    }

    public void setWithdrawMoney5(Integer withdrawMoney5) {
        this.withdrawMoney5 = withdrawMoney5;
    }

    public Integer getWithdrawMoney6() {
        return withdrawMoney6;
    }

    public void setWithdrawMoney6(Integer withdrawMoney6) {
        this.withdrawMoney6 = withdrawMoney6;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName == null ? null : currencyName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDescCny() {
        return descCny;
    }

    public void setDescCny(String descCny) {
        this.descCny = descCny == null ? null : descCny.trim();
    }

    public String getDescEn() {
        return descEn;
    }

    public void setDescEn(String descEn) {
        this.descEn = descEn == null ? null : descEn.trim();
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