package com.tomcat360.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Created by Administrator on 2017/7/5.
 */
@Data
public class LoginUser {

    private Long id;

    private String mobile;

    private String username;

    @JsonIgnore
    private String password;

    private Long loginTime;
}
