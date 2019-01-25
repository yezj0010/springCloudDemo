package com.tomcat360.atm.service.Impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.atm.enums.EnumResponseMsg;
import com.tomcat360.atm.mapper.TbEquipmentSettingsMapper;
import com.tomcat360.atm.model.JSONData;
import com.tomcat360.atm.model.TbEquipmentSettings;
import com.tomcat360.atm.model.TbEquipmentSettingsExample;
import com.tomcat360.atm.service.TbEquipmentSettingsService;

@Service
public class TbEquipmentSettingsServiceImpl implements TbEquipmentSettingsService {

	@Autowired
	private TbEquipmentSettingsMapper tbEquipmentSettingsMapper;

	@Override
	public TbEquipmentSettings find(String id) {
		

		return tbEquipmentSettingsMapper.selectByPrimaryKey(id);
	}

	@Override
	public JSONData addMoney(String id, String amount) {
		BigDecimal bd = new BigDecimal(amount).divide(new BigDecimal(100));//总金额，直接覆盖之前的金额
		TbEquipmentSettings settings = find(id);//根据设备编号查询
		if(settings == null){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_EQUIPMENT_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_EQUIPMENT_NULL.getMsg()).build();
		}
		settings.setAmount(bd);
		tbEquipmentSettingsMapper.updateByPrimaryKey(settings);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@Override
	public void updateDate(TbEquipmentSettings tbEquipmentSettings) {
		tbEquipmentSettingsMapper.updateByPrimaryKey(tbEquipmentSettings);
		
	}

	@Override
	public TbEquipmentSettings findByIP(String ip) {
		TbEquipmentSettingsExample example = new TbEquipmentSettingsExample();
		example.createCriteria().andPreIpEqualTo(ip);
		List<TbEquipmentSettings> list = tbEquipmentSettingsMapper.selectByExample(example);
		if(list == null||list.size()==0){
			return null;
		}
		return list.get(0);
	}

}
