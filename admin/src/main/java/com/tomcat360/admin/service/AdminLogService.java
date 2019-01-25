package com.tomcat360.admin.service;

import java.util.Map;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbAdminLog;

public interface AdminLogService {
	
	/**
	 * 新增日志
	 * @param adminLog
	 */
	public void insert(TbAdminLog adminLog);
	
	/**
	 * 修改日志
	 * @param adminLog
	 */
	public void update(TbAdminLog adminLog);
	
	/**
	 * 根据条件查询日志 分页
	 * @param params
	 * @return
	 */
	JSONData findByCondition(Map<String,Object> params);

	/**
	 * 修改日志
	 * @param adminLog
	 */
	public void updateSelective(TbAdminLog adminLog);
	
}
