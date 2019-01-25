package com.tomcat360.atm.service;

import com.tomcat360.atm.model.TbEquipment;

public interface TbEquipmentService {

	TbEquipment find(String id);

	void update(TbEquipment tbEquipment);

	TbEquipment selectByKey(String id);

	/**
	 * 根据id，只更新不为空的值
	 * @param selectiveRecord
	 */
	void updateBySelective(TbEquipment selectiveRecord);
}
