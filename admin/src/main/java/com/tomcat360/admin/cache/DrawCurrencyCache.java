package com.tomcat360.admin.cache;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tomcat360.admin.service.TbWithdrawCurrencyService;

@Component
public class DrawCurrencyCache {
	
	@Autowired
	private TbWithdrawCurrencyService TbWithdrawCurrencyService;
	
	public static List<String> drawCurrencyList = new ArrayList<String>();
	
	@PostConstruct
	public void init(){
		drawCurrencyList = TbWithdrawCurrencyService.selectAllDrawCurrency();
	}
	
	public static boolean ifExist(String drawCurrency){
		if(drawCurrencyList.contains(drawCurrency)){
			return true;
		}
		return false;
	}
	
}
