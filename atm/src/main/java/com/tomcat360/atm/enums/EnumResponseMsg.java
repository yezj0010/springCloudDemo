package com.tomcat360.atm.enums;

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
	RESP_ERROR_SYSTEM_FAILURE("9999","系统开小差，稍后再试--The system dips and tries again later"),
	/**用户名不存在 =9999**/
	RESP_ERROR_USER_NOT_EXIST("1000","用户名或密码不正确|The username or password is incorrect"),
    /**用户名或密码不正确=1001**/
    RESP_ERROR_WRONG_USERNAME_OR_PWD("1001","用户名或密码不正确|The username or password is incorrect"),
    /**参数不能为空**/
	RESP_ERROR_PARAMETER_NULL("1002","参数不能为空"),
	/**参数不能为空**/
	RESP_ERROR_REDIS("1003","redis查询错误"),
	/** 验证码发送频率太快=1004 **/
    RESP_ERROR_SMS_FAST("1004","验证码发送频率太快|The verification code is sent too fast"),
    /** 用户未登录=1005 **/
    RESP_ERROR_USER_NOT_LOGIN("1005","用户未登录"),
    /** 交易所返回超时=1006 **/
    RESP_ERROR_EXCHANFE_ERROR("1006","交易所返回超时|Exchange return timeout"),
    /**退出失败=1007*/
    RESP_ERROR_LOGOUT("1007", "退出失败|Exit failure"),
    /**登录次数超过30次=1008*/
    RESP_ERROR_LOGIN_OUT("1008", "登录次数超过30次|Log in more than 30 times"),
    /**原交易状态无法冲正=1009*/
    RESP_ERROR_CORRECTION_STATUS_ERR("1009", "原交易状态无法冲正"),
    /**原交易不存在=1010*/
    RESP_ERROR_ORITRANS_NOT_FOUND("1010", "原交易不存在"),
    /**扣款失败，冲正成功=1011*/
    RESP_ERROR_CORRECTION_OK("1011", "扣款失败，冲正成功"),
    /**扣款失败，冲正异常=1012*/
    RESP_ERROR_CORRECTION_ERR("1012", "扣款失败，冲正异常"),
    /**验签失败=1013*/
    RESP_ERROR_VALIDATE_FAIL("1013", "验签失败"),
    /**查不到该设备=1014*/
    RESP_ERROR_EQUIPMENT_NULL("1014", "查不到该设备"),
    /**原交易正在冲正=1015*/
    RESP_ERROR_CORRECTION_RUNNING("1015", "原交易正在冲正"),
    /**暂不支持该币种交易=1016*/
    RESP_ERROR_CURRENCY_IS_ERROR("1016", "暂不支持该币种交易"),
    /**重复请求|Repeat request=1017*/
    RESP_ERROR_REPEAT_REQUEST("1017", "重复请求|Repeat request"),
    /**该设备已闲置|Equipment Unused=1018*/
    RESP_ERROR_EQUIPMENT_UNUSED("1018", "该设备已闲置|Equipment Unused"),
    /**取款超过设备每日限额|Withdrawals exceed the daily limit of the device=1019*/
    RESP_ERROR_EXCEED_EQUIPMENT_DAY_LIMIT_("1019", "取款超过设备每日限额|Withdrawals exceed the daily limit of the device"),
    /**您的验证码错误，请重新输入|Your verification code error, please re-enter=zE0024*/
    RESP_ERROR_VERIFICATION_ERROR("zE0024", "您的验证码错误，请重新输入|Your verification code error, please re-enter"),
    /**账号不存在|account does not exist=zE0003*/
    RESP_ERROR_ACCOUNT_NOT_EXIST("zE0003", "账号不存在|account does not exist"),
    /**取款超过用户每日限额|Withdrawals exceed the user daily limit=1019*/
    RESP_ERROR_ACCOUNT_WITHDRAWSUM("1019", "取款超过用户每日限额|Withdrawals exceed the user daily limit"),
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
