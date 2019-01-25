package com.tomcat360.atm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.atm.enums.EnumResponseMsg;
import com.tomcat360.atm.mapper.TbEquipmentStatusMapper;
import com.tomcat360.atm.model.JSONData;
import com.tomcat360.atm.model.TbEquipmentStatus;
import com.tomcat360.atm.service.TbEquipmentStatusService;
@Service
public class TbEquipmentStatusServiceImpl implements TbEquipmentStatusService {
	@Autowired
	private TbEquipmentStatusMapper tbEquipmentStatusMpper;
	
	
	public JSONData updateByTbEquipmentStatus(TbEquipmentStatus tbEquipmentStatus) {
		tbEquipmentStatusMpper.updateByPrimaryKey(tbEquipmentStatus);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}


	@Override
	public TbEquipmentStatus findById(String equipmentId) {
		// TODO Auto-generated method stub
		return tbEquipmentStatusMpper.selectByPrimaryKey(equipmentId);
	}


	@Override
	public void updateByPrimaryKeySelective(TbEquipmentStatus tbEquipmentStatus) {
		tbEquipmentStatusMpper.updateByPrimaryKeySelective(tbEquipmentStatus);
	}
	
}
