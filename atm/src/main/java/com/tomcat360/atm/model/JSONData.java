package com.tomcat360.atm.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Zhang j.c.
 *
 * JSON对象返回封装
 * @Date 2017/9/6
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JSONData {

	private String code;
	private String msg;
	private Map<String, ?> data;
	
	private String content;
	private String signature;
	
	public JSONData(String code,String msg, Map<String, ?> data){
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
}
