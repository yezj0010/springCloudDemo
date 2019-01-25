package com.tomcat360.atm.service;

import com.tomcat360.atm.model.TbPCheckTrans;
import com.tomcat360.atm.model.TbPCheckTransExample;

import java.util.List;

/**
 * Created by jin.Deng on 2018/9/19.
 */
public interface TbPCheckTransService {

	void insert(TbPCheckTrans tbPCheckTrans);

	List<TbPCheckTrans> findByExample(TbPCheckTransExample tbPCheckTransExample);

	void update(TbPCheckTrans tbPCheckTrans);
}
