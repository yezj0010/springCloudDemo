package com.tomcat360.admin.model;

import java.util.Date;

public class TbAllCurrency {
    private Long id;

    private String allCurrencyCn;

    private String allCurrencyEn;

    private String currencyCode;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllCurrencyCn() {
        return allCurrencyCn;
    }

    public void setAllCurrencyCn(String allCurrencyCn) {
        this.allCurrencyCn = allCurrencyCn == null ? null : allCurrencyCn.trim();
    }

    public String getAllCurrencyEn() {
        return allCurrencyEn;
    }

    public void setAllCurrencyEn(String allCurrencyEn) {
        this.allCurrencyEn = allCurrencyEn == null ? null : allCurrencyEn.trim();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}