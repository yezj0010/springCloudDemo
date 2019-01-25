package com.tomcat360.third.enums.response;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @ClassName: EnumResponseMsg
 * @Description: 用户请求响应信息枚举类型
 * @author dongping.Qin
 * @date 2017年9月7日
 * @copyright 浙江雄猫软件开发有限公司
*/
public enum EnumResponseMsg {
	/**成功 =0000**/
	RESP_SUCCESS("0000","成功"),
	/**失败 =9999**/
	RESP_ERROR_SYSTEM_FAILURE("9999","系统开小差，稍后再试|The system dips and tries again later"),
	/**用户名不存在 =9999**/
	RESP_ERROR_USER_NOT_EXIST("1000","用户不存在"),
	/**密码不正确 =1001**/
	RESP_ERROR_WRONG_PASSWORD("1001","密码不正确"),
    /**用户名或密码不正确=1002**/
    RESP_ERROR_WRONG_USERNAME_OR_PWD("1002","用户名或密码不正确"),
    /**您当前登录处于冻结中，请联系客服人员=1003**/
    RESP_ERROR_FROZEN("1003","您当前登录处于冻结中，请联系客服人员。"),
    /**请输入正确的手机号码=1004**/
    RESP_ERROR_INCORRECT_PHONE_NUMBER("1004","请输入正确的手机号码"),
    /**注册失败=1005**/
    RESP_ERROR_REGISTER_ERROR("1005","注册失败"),
    /**请输入正确的密码=1006**/
    RESP_ERROR_PS_IMPORT_RIGHT_PWD("1006","请输入正确的密码"),
    /**密码长度6-15位=1007**/
    RESP_ERROR_PASSWORD_LENGTH_ILLEGAL("1007","密码长度6-15位"),
    /**两次密码必须一致=1008**/
    RESP_ERROR_PASSWORD_UNMATCH("1008","两次密码必须一致"),
    /**参数不能为空 =1009**/
	RESP_ERROR_PARAM_EMPTY("1009","参数不能为空"),
	/**图形验证码输入错误 =1010**/
	RESP_ERROR_CAPTCHA("1010","图形验证码输入错误"),
	/**token生成失败 =1011**/
	RESP_ERROR_GENERATE_TOKEN("1011","token生成失败"),
	/**您当前账号已被停用=1012**/
    RESP_ERROR_FORBIDDEN("1012","您当前账号已被停用"),
    /**您没有操作此功能的权限=1013**/
    RESP_ERROR_NO_AUTH("1013","您没有操作此功能的权限"),
    /**会员昵称已经被使用=1014**/
    RESP_ERROR_USER_USERNAME_IS_USED("1014","会员昵称已经被使用"),
    /**该用户名已经被使用=1015**/
    RESP_ERROR_ADMINUSER_USERNAME_IS_USED("1015","该用户名已经被使用"),
    /**未查询到对应用户的设备号，无法单独发送消息=1016**/
    RESP_ERROR_USER_EQUIPMENT_NOT_FOUND("1016","未查询到对应用户的设备号，无法单独发送消息"),
    /**该产品不存在=1017**/
    RESP_ERROR_NO_PRODUCT("1017","该产品不存在"),
    /** 积分不足 = 1109 **/
    RESP_ERROR_POINT_NOT_ENOUGH("1109","积分不足"),
    /** excel导出错误 = 1201 **/
    RESP_ERROR_POI("1201","excel导出错误"),
	/** 设备号重复 **/
    RESP_ERROR_EQUIPMENT_NO("1202","设备号重复"),
    /** admin用户只能修改自己密码=1203 **/
    RESP_ERROR_ADMIN_UPDATE_ERR("1203","超级管理员只能修改自己密码"),
    /** 该账号权限不足=1204 **/
    RESP_ERROR_PERMISSION_NOT_ENOUGH("1204","该账号权限不足"),
    /**没有配置该币种=1205*/
    RESP_ERROR_CURRENCY_IS_ERROR("1205", "没有配置该币种"),
    /**找不到指定的设备=1206*/
    RESP_SOCKET_TIME_OUT_ERROR("1206", "找不到指定的设备"),
    /** 交易所返回超时=1036 **/
    RESP_ERROR_EXCHANFE_ERROR("1036","交易所返回超时|Exchange return timeout"),
    /** C端和P端对账表数据错误=1037 **/
    RESP_C_EXCHANFE_ERROR("1037","C端和P端对账表数据错误|Exchange return timeout"),
    /** socket服务已经开启=1038 **/
    RESP_ERROR_SOCKKET_IS_START("1038","socket服务已经开启"),
    /** 找不到指定client客户端=1039 **/
    RESP_ERROR_SOCKKET_CLIENT("1039","找不到指定client客户端"),
    
    /** socket服务已经开启=1040 **/
    RESP_ERROR_SOCKKET_IS_STOP("1040","socket服务已经关闭"),
    /** 该区域已有设备=1041 **/
    RESP_ERROR_AREA_EQUIPMENT("1041","该区域已有设备"),
    
    /** 该币种已有设备再使用=1041 **/
    RESP_ERROR_CURRENCY_EQUIPMENT("1043","该币种已有设备在使用"),
    /** token失效=1043 **/
    RESP_ERROR_TOKEN_OUT("1043","token失效"),
    /** 该地区已存在=1044 **/
    RESP_ERROR_AREA("1044","该地区已存在"),
    /** 无法修改系统参数=1045 **/
    RESP_ERROR_SYSTEM_SETTINGS("1045","无法新增系统参数"),
    /** 该币种已有设备在使用=1046 **/
    RESP_ERROR_CURRENCY("1046","该数字货币币种已存在"),
    /** 该名称已有区域使用=1047 **/
    RESP_ERROR_AREANAME("1047","该名称已有区域使用"),
    /** 该币种符号已存在=1048 **/
    RESP_ERROR_CURRENCY_CODE("1048","该币种符号已存在"),
    /** 该币种中文名称已存在=1049 **/
    RESP_ERROR_CURRENCY_CNY("1049","该币种中文名称已存在"),
    /** 该数字货币币种已使用，无法修改数字货币币种名称=1050 **/
    RESP_ERROR_DEDUCT_CURRENCY("1050","该数字货币币种已使用，无法修改数字货币币种名称"),
    /** 类型转换异常=1051 **/
    RESP_ERROR_TYPE_CHANGGE("1051","类型转换异常"),
    /** 该版本文件不存在，请先联系开发人员上传版本文件=1052 **/
    RESP_ERROR_VERSION_NOT("1052","该版本文件不存在，请先联系开发人员上传版本文件"),
    /** 取款金额配置不能重复=1053 **/
    RESP_ERROR_WITHDRAWMONEY("1053","取款金额配置不能重复"),
    /** 该时段没有日志=1054 **/
    RESP_ERROR_NOT_LOG("1054","该时段没有日志"),
    /** 系统参数的code无法修改=1055 **/
    RESP_ERROR_SYSTEM_CODE("1055","系统参数的code无法修改"),
    /** 该地区的法币类型还未开通|Area legal tender type not opened=1056 **/
    RESP_AREA_CURRENCY_NOTOPEN("1056","该地区的法币类型还未开通|Area legal tender type not opened"),
    ;

	/**响应编码--code**/
	 private String code;
	 /**响应信息--msg**/
     private String msg;
     private boolean display;

     EnumResponseMsg(String code, String msg) {
       this.code = code;
       this.msg = msg;
       this.display = true;
     }
     
     public String getCode() {
       return code;
     }
     
     public void setCode(String code) {
       this.code = code;
     }
     
     public String getMsg() {
       return msg;
     }
     
     public void setMsg(String msg) {
       this.msg = msg;
     }
     
     public boolean isDisplay() {
       return display;
     }
     
     public void setDisplay(boolean display) {
       this.display = display;
     }
     
     public static boolean isSuccess(String code){
    	 return RESP_SUCCESS.getCode().equals(code);
     }
     
     /**
      * 根据枚举的code返回枚举对象
      * @param code  枚举code值
      * @return  枚举对象
      */
     public static EnumResponseMsg getEnumByCode(String code) {
       if (code == null) return null;
       for (EnumResponseMsg type : values()) {
           if (type.getCode().equals(code.trim()))
               return type;
       }
       return null;
     }
     
     /**
      * 将枚举转换成code-msg形式的集合
      * 可通过<code>EnumXXX.setDisplay(false);</code>的方式将不需要的枚举类型不转换成map
      * @return  转换后的map集合
      */
     public static Map<String, String> toMap() {
       Map<String, String> enumDataMap = new LinkedHashMap<String, String>();
       for (EnumResponseMsg type : EnumResponseMsg.values()) {
           if (type.isDisplay()) enumDataMap.put(type.getCode(), type.getMsg());
       }
       return enumDataMap;
     }
     
     /**
      * 将枚举转换成code-code-msg形式的集合
      * 可通过<code>EnumXXX.setDisplay(false);</code>的方式将不需要的枚举类型不转换成map
      * @return  转换后的map集合
      */
     public static Map<String, String> toMixMap() {
       Map<String, String> enumDataMap = new LinkedHashMap<String, String>();
       for (EnumResponseMsg type : EnumResponseMsg.values()) {
           if (type.isDisplay()) enumDataMap.put(type.getCode(), type.getCode() + "-" + type.getMsg());
       }
       return enumDataMap;
     }
}
