package com.tomcat360.atm.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbUserAccount {
    private Long id;

    private Long userId;

    private String userToken;

    private String userLocalToken;

    private String currencyCode;

    private BigDecimal currencyMoney;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
    }

    public BigDecimal getCurrencyMoney() {
        return currencyMoney;
    }

    public void setCurrencyMoney(BigDecimal currencyMoney) {
        this.currencyMoney = currencyMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}