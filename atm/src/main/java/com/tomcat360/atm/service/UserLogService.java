package com.tomcat360.atm.service;

import com.tomcat360.atm.model.TbUserLog;

public interface UserLogService {
	
	public int save(TbUserLog userLog);
	
	public void update(TbUserLog userLog);
	
}
