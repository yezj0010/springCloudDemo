package com.tomcat360.atm.model;

import java.util.Date;

public class TbUserInfo {
    private Long id;

    private String userToken;

    private String userLocalToken;

    private String userName;

    private String userPhone;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}