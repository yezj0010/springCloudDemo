package com.tomcat360.atm.enums;

public enum TransStatusEnum {
	/** 交易状态初始 **/
	INITIAL("0", "初始"),

	/** 交易状态完成 **/
	SUCCESS("1", "完成"),

	/** 交易状态失败 **/
	FAIL("2", "失败"),

	/** 交易状态超时 **/
	TIMEOUT("3", "超时"),

	/** 交易状态已冲正 **/
	CORRECTION("4", "已冲正"),

	/** 交易状态冲正异常 **/
	CORRECTION_E("5", "冲正异常"),

	/** 交易状态吐钞中 **/
	SPITMONEY("6", "吐钞中"),

	/** 状态不明 **/
	UNKNOW("7", "状态不明"),
	
	;

	/** 状态--status **/
	private String status;
	/** 描述--desc **/
	private String desc;

	TransStatusEnum(String status, String desc) {
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
