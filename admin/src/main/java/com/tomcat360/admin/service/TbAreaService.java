package com.tomcat360.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbArea;

public interface TbAreaService {

	JSONData selectByFristArea(HttpServletRequest request,String id);

	TbArea selectByCountry(String countryId);

	Integer findOrderNum();
	
	JSONData updateByAreaName(TbArea tbarea);

	void insert(TbArea tbArea);

	JSONData findAll(Map<String, Object> param);

	List<Map> findAllNotSubPage();

	JSONData delete(String areaName);

	List<TbArea> selectByAreaName(String areaName);

	void update(TbArea tbArea);
	
}
