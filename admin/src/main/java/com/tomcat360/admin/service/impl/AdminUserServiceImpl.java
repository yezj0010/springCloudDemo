package com.tomcat360.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbAdminUserMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbAdminUser;
import com.tomcat360.admin.model.TbAdminUserExample;
import com.tomcat360.admin.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService{

	@Autowired
	private TbAdminUserMapper tbAdminUserMapper;
	
	@Override
	public TbAdminUser findById(Long id) {
		return tbAdminUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public TbAdminUser findOneByUserName(String userName) {
		TbAdminUserExample example = new TbAdminUserExample();
		example.createCriteria().andUserNameEqualTo(userName);
		List<TbAdminUser> list = tbAdminUserMapper.selectByExample(example);
		if(list == null||list.size()==0){
			return null;
		}
		return list.get(0);
	}
	

	@Override
	public Integer findByUserNameExSelf(String userName, Long selfId) {
		TbAdminUserExample example = new TbAdminUserExample();
		example.createCriteria().andUserNameEqualTo(userName).andIdNotEqualTo(selfId);
		List<TbAdminUser> list = tbAdminUserMapper.selectByExample(example);
		if(list == null){
			return 0;
		}
		return list.size();
	}

	@Override
	public JSONData findByCondition(Map<String, Object> params) {
		Integer page = (Integer)params.get("page");
		Integer size = (Integer)params.get("size");
		Page<Map<String,Object>> list = PageHelper.startPage(page, size);
		tbAdminUserMapper.selectByCondition(params);
		
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
	public void update(TbAdminUser adminUser) {
		tbAdminUserMapper.updateByPrimaryKey(adminUser);
	}

	@Override
	public void save(TbAdminUser adminUser) {
		tbAdminUserMapper.insert(adminUser);
	}

}
