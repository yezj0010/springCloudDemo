package com.tomcat360.admin.enums;

/**
 * 日志状态枚举
 * 
 * @author Deng.Jin
 * @date 2018/8/16
 */
public enum LogStatusEnum {
	/** 交易状态初始 **/
	INITIAL("0", "初始"),

	/** 交易状态完成 **/
	SUCCESS("1", "完成"),

	/** 交易状态失败 **/
	FAIL("2", "失败"),
	
	;

	/** 状态--status **/
	private String status;
	/** 描述--desc **/
	private String desc;

	LogStatusEnum(String status, String desc) {
		this.status = status;
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public String getDesc() {
		return desc;
	}
}
