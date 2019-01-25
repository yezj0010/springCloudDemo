package com.tomcat360.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.admin.constant.AdminConstant;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbAreaMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbAdminUser;
import com.tomcat360.admin.model.TbArea;
import com.tomcat360.admin.model.TbAreaExample;
import com.tomcat360.admin.model.TbEquipment;
import com.tomcat360.admin.service.TbAreaService;
import com.tomcat360.admin.service.TbEquipmentService;

@Service
public class TbAreaServiceImpl implements TbAreaService {
	@Autowired
	private TbAreaMapper tbAreaMapper;
	@Autowired
	private TbEquipmentService tbEquipmentService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONData selectByFristArea(HttpServletRequest request, String id) {
		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);

		JSONData jsonData = JSONData.builder().build();

		List list1 = new ArrayList<TbArea>();
		List list2 = new ArrayList<TbArea>();
		List list3 = new ArrayList<TbArea>();
 		
		Map map = new HashMap<String, Object>();
		List<TbArea> selectByExample = new ArrayList();
		if (StringUtils.isEmpty(id)) {
			if (1l== (admin.getRoleId())) {
				TbAreaExample example = new TbAreaExample();
				example.createCriteria().andParentIdEqualTo(0l);
				selectByExample = tbAreaMapper.selectByExample(example);
			} else {
				TbArea area = tbAreaMapper.selectByPrimaryKey(admin.getCountryId());
				selectByExample.add(area);
			}
			map.put("list", selectByExample);
		} else {
			selectByExample = tbAreaMapper.selectByParentId(id);
			for (TbArea tbArea : selectByExample) {

				Long id2 = tbArea.getId();
				List<TbArea> selectByExample2 = tbAreaMapper.selectByParentId(id2 + "");
				if (selectByExample2 != null && selectByExample2.size() > 0) {
					for (TbArea tbArea2 : selectByExample2) {
						list2.add(tbArea2);
						Long id3 = tbArea2.getId();
						List<TbArea> selectByExample3 = tbAreaMapper.selectByParentId(id3 + "");
						if (selectByExample3 != null && selectByExample3.size() > 0) {
							for (TbArea tbArea3 : selectByExample3) {

								list3.add(tbArea3);
							}
							tbArea2.setTbAreas(list3);
							list3 = new ArrayList<TbArea>();
						}
					}
					tbArea.setTbAreas(list2);
					list2 = new ArrayList<TbArea>();
				}
				list1.add(tbArea);
			}
			map.put("list", list1);
		}

		jsonData.setMsg(EnumResponseMsg.RESP_SUCCESS.getMsg());
		jsonData.setCode(EnumResponseMsg.RESP_SUCCESS.getCode());
		jsonData.setData(map);
		return jsonData;
	}

	@Override
	public TbArea selectByCountry(String countryId) {
		TbAreaExample example = new TbAreaExample();
		example.createCriteria().andIdEqualTo(Long.valueOf(countryId));
		List<TbArea> selectByExample = tbAreaMapper.selectByExample(example);
		return selectByExample.get(0);
	}

	@Override
	public Integer findOrderNum() {
		return tbAreaMapper.findOrderNum();
	}

	@Override
	public JSONData updateByAreaName(TbArea tbArea) {
		
		tbAreaMapper.updateByPrimaryKeySelective(tbArea);
		
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).build();
	}

	@Override
	public void insert(TbArea tbArea) {
		// TODO Auto-generated method stub
		tbAreaMapper.insert(tbArea);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONData findAll(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Integer page = (Integer) params.get("page");
		Integer size = (Integer) params.get("size");

		Page<List<TbArea>> listPage = PageHelper.startPage(page, size);
		tbAreaMapper.findAll(params);
		Map data = new HashMap();
		data.put("list", listPage.getResult());
		data.put("pageSize", listPage.getPageSize());
		data.put("totalPages", listPage.getPages());
		data.put("totalNumber", listPage.getTotal());
		data.put("page", listPage.getPageNum());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}

	@Override
	public JSONData delete(String areaName) {
		List<TbEquipment> te = tbEquipmentService.findEquipmentByArea(areaName);
		if (te != null && te.size() > 0) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_AREA_EQUIPMENT.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_AREA_EQUIPMENT.getMsg()).build();
		}
		TbAreaExample example = new TbAreaExample();
		example.createCriteria().andAreaNameEqualTo(areaName);
		tbAreaMapper.deleteByExample(example);

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@Override
	public List<Map> findAllNotSubPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbArea> selectByAreaName(String areaName) {
		TbAreaExample example = new TbAreaExample();
		example.createCriteria().andAreaNameEqualTo(areaName);
		return tbAreaMapper.selectByExample(example);
	}

	@Override
	public void update(TbArea tbArea) {
		// TODO Auto-generated method stub
		tbAreaMapper.updateByPrimaryKeySelective(tbArea);
	}
}
