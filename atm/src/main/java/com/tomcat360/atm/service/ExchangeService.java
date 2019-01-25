package com.tomcat360.atm.service;

import javax.servlet.http.HttpServletRequest;

import com.tomcat360.atm.model.JSONData;
import com.tomcat360.atm.model.TbTrans;

public interface ExchangeService {
	
	/**
	 * 获取二维码
	 * @param termNo 
	 * @return
	 */
	public JSONData getQRCode(String termNo);
	
	/**
	 * 二维码登录
	 * @param qrtoken
	 * @return
	 */
	public JSONData loginByQRCode(HttpServletRequest request, String qrtoken,String date);
	
	/**
	 * 发送短信验证码
	 * @param account
	 * @param type
	 * @return
	 */
	public JSONData sendValidateMsg(String account,String type, String language);
	
	/**
	 * 用户密码验证码登录
	 * @param request
	 * @param password
	 * @return
	 */
	public JSONData login(HttpServletRequest request, String userName, String password);
	
	/**
	 * 登录检验
	 * @return
	 */
	public JSONData loginCheck(HttpServletRequest request);
	
	/**
	 * 退出登录
	 * @param localToken
	 * @param exchangeToken
	 * @return
	 */
	public JSONData logout(String localToken, String exchangeToken);
	
	/**
	 *  获取用户资产信息
	 * @param request
	 * @return
	 */
	public JSONData getUserAccount(HttpServletRequest request, String exchangeToken, String currency);
	
	/**
	 *  获取防重码
	 * @param request
	 * @param termNo
	 * @return
	 */
	public JSONData getCaptcha(HttpServletRequest request, String termNo);
	
	/**
	 *  扣款
	 * @param request
	 * @return
	 */
	public JSONData drawMoney(HttpServletRequest request,String deductCurrency,String drawCurrency,
			double drawMoney);
	
	/**
	 *  冲正
	 * @param request
	 * @param transId：P端流水
	 * @return
	 */
	public JSONData transCorrect(HttpServletRequest request,String transId);


	/**
	 * 获取扣款币种手续费
	 * @param deductAndPrice
	 * @param drawMoneystr
	 * @return
	 */
	public JSONData getTransFee(String deductAndPrice, String drawMoneystr, String equipmentId);

	/**
	 * 吐钞通知
	 * @param id
	 * @param amount
	 * @param language
	 * @param extoken
	 * @param spitMoneyStatus 
	 * @param tbTrans 
	 * @return
	 */
	public JSONData spitMoneyResult(String id, String amount, String language, String extoken, TbTrans tbTrans, String spitMoneyStatus);

	/**
	 * 交易对账
	 * @return
	 */
	public JSONData checkTrans(HttpServletRequest request);
}
