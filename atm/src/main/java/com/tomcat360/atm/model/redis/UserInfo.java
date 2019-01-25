package com.tomcat360.atm.model.redis;

import lombok.Data;

/**
 * Redis中保存的用户信息
 */
@Data
public class UserInfo {
    private Long id;
    private String userName;    //用户名
    private String userPhone;   //手机号
}
