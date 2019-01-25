package com.tomcat360.atm.controller;

import com.tomcat360.atm.aspect.UserLog;
import com.tomcat360.atm.constant.AtmConstant;
import com.tomcat360.atm.enums.EnumResponseMsg;
import com.tomcat360.atm.model.JSONData;
import com.tomcat360.atm.model.TbEquipmentSettings;
import com.tomcat360.atm.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by jin.Deng on 2018/9/19.
 */
@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	private ExchangeService exchangeService;

	@UserLog(interfaceCode = "/api/pushTransData", interfaceDesc = "发送对账数据")
	@RequestMapping("/pushTransData")
	public JSONData pushTransData(HttpServletRequest request){

		String batchNo = (String)request.getAttribute("batchNo");//对账批次号
		String currencyCode = (String)request.getAttribute("currencyCode");//钞箱币种
		String AddAmt = (String)request.getAttribute("addAmt");//加钞总金额
		String balanceAmt = (String)request.getAttribute("balanceAmt");//剩余总金额
		String drawBalanceAmt = (String)request.getAttribute("drawBalanceAmt");//取款箱剩余总金额
		String depositBalanceAmt = (String)request.getAttribute("depositBalanceAmt");//存款箱剩余总金额

		String drawSucNum = (String)request.getAttribute("drawSucNum");//取款成功笔数
		String drawSucAmt = (String)request.getAttribute("drawSucAmt");//取款成功金额
		String drawFailNum = (String)request.getAttribute("drawFailNum");//取款失败笔数
		String drawFailAmt = (String)request.getAttribute("drawFailAmt");//取款失败金额
		String drawUnkNum = (String)request.getAttribute("drawUnkNum");//取款疑问笔数
		String drawUnkAmt = (String)request.getAttribute("drawUnkAmt");//取款疑问金额
		String drawRevNum = (String)request.getAttribute("drawRevNum");//取款冲正笔数
		String drawRevAmt = (String)request.getAttribute("drawRevAmt");//取款冲正金额

		String depositSucNum = (String)request.getAttribute("depositSucNum");//存款成功笔数
		String depositSucAmt = (String)request.getAttribute("depositSucAmt");//存款成功金额
		String depositFailNum = (String)request.getAttribute("depositFailNum");//存款失败笔数
		String depositFailAmt = (String)request.getAttribute("depositFailAmt");//存款失败金额
		String depositUnkNum = (String)request.getAttribute("depositUnkNum");//存款疑问笔数
		String depositUnkAmt = (String)request.getAttribute("depositUnkAmt");//存款疑问金额

		List<Map> drawUnkList = (List<Map>)request.getAttribute("drawUnkList");//取款疑问交易明细
		System.out.println("取款未知交易明细列表"+drawUnkList);

		if (StringUtils.isEmpty(batchNo) || StringUtils.isEmpty(currencyCode) ||
				StringUtils.isEmpty(AddAmt) || StringUtils.isEmpty(balanceAmt) ||
				StringUtils.isEmpty(drawBalanceAmt) || StringUtils.isEmpty(depositBalanceAmt) ||
				StringUtils.isEmpty(drawSucNum) || StringUtils.isEmpty(drawSucAmt) ||
				StringUtils.isEmpty(drawFailNum) || StringUtils.isEmpty(drawFailAmt) ||
				StringUtils.isEmpty(drawUnkNum) || StringUtils.isEmpty(drawUnkAmt) ||
				StringUtils.isEmpty(drawRevNum) || StringUtils.isEmpty(drawRevAmt) ||
				StringUtils.isEmpty(depositSucNum) || StringUtils.isEmpty(depositSucAmt) ||
				StringUtils.isEmpty(depositFailNum) || StringUtils.isEmpty(depositFailAmt) ||
				StringUtils.isEmpty(depositUnkNum) || StringUtils.isEmpty(depositUnkAmt) ||
				drawUnkList == null
				) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}

		for(Map map : drawUnkList) {
			String termSeq = (String) map.get("termSeq");
			String tempTermDate = (String) map.get("termDate");
			String status = (String) map.get("status");//0为成功，1为失败，2已冲正，3状态不明
			if(StringUtils.isEmpty(termSeq) || StringUtils.isEmpty(tempTermDate) ||
					StringUtils.isEmpty(status)){
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
			}

		}

		//校验取款币种是否是该设备支持的币种
		TbEquipmentSettings tbEquipmentSettings = (TbEquipmentSettings)request.getAttribute(AtmConstant.EQUIPMENT_SETTINGS);
		if(!currencyCode.equals(tbEquipmentSettings.getEquipmentSubType())){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getMsg()).build();
		}

		return exchangeService.checkTrans(request);
	}

}
