package com.tomcat360.admin.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbAdminLogMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbAdminLog;
import com.tomcat360.admin.model.TbAdminLogExample;
import com.tomcat360.admin.model.TbAdminLogExample.Criteria;
import com.tomcat360.admin.service.AdminLogService;
import com.tomcat360.admin.util.CalendarUtil;

@Service
public class AdminLogServiceImpl implements AdminLogService{

	@Autowired
	private TbAdminLogMapper tbAdminLogMapper;
	
	@Override
	public void insert(TbAdminLog adminLog) {
		tbAdminLogMapper.insert(adminLog);
	}

	@Override
	public void update(TbAdminLog adminLog) {
		tbAdminLogMapper.updateByPrimaryKey(adminLog);
	}

	@Override
	public JSONData findByCondition(Map<String, Object> params) {
		Integer page = (Integer)params.get("page");
		Integer size = (Integer)params.get("size");
		String userName = (String)params.get("userName");
		String operation = (String)params.get("operation");
		String operateStatus = (String)params.get("operateStatus");
		
		Date firstTime = (Date)params.get("firstTime");
		Date endTime = (Date)params.get("endTime");
		
		String userName2 = (String)params.get("userName2");
		Page<TbAdminLog> list = PageHelper.startPage(page, size);
		TbAdminLogExample example = new TbAdminLogExample();
		example.setOrderByClause("create_time desc");
		Criteria criteria = example.createCriteria();
		if(!StringUtil.isEmpty(userName)){
			criteria.andUserNameLike(userName);
		}
		if(!StringUtil.isEmpty(operation)){
			criteria.andInterfaceCodeEqualTo(operation);
		}
		if(!StringUtil.isEmpty(operateStatus)){
			criteria.andOperateStatusEqualTo(operateStatus);
		}
		if(firstTime != null){
			criteria.andCreateTimeGreaterThan(firstTime);
			criteria.andCreateTimeLessThan(endTime);
		}
		if(!StringUtil.isEmpty(userName2)){
			criteria.andUserNameEqualTo(userName2);
		}
		
		tbAdminLogMapper.selectByExample(example);
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("list", list.getResult());
		data.put("pageSize", list.getPageSize());
		data.put("totalPages", list.getPages());
		data.put("totalNumber", list.getTotal());
		data.put("page", list.getPageNum());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
    			.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}

	@Override
	public void updateSelective(TbAdminLog adminLog) {
		tbAdminLogMapper.updateByPrimaryKeySelective(adminLog);
	}
}
