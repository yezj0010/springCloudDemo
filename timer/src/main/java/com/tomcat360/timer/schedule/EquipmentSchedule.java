package com.tomcat360.timer.schedule;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tomcat360.timer.model.TbEquipmentFaulLog;
import com.tomcat360.timer.model.TbSettings;
import com.tomcat360.timer.service.EquipmentFaulLogService;
import com.tomcat360.timer.service.TbSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.timer.model.TbEquipmentStatus;
import com.tomcat360.timer.properties.AppProperties;
import com.tomcat360.timer.service.EquipmentStatusService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * @description 定期更新设备状态
 * @author jin.Deng
 * @date 2018年8月28日
 * @copyright 浙江雄猫软件开发有限公司
 */
@Component
@Slf4j
public class EquipmentSchedule {
	
	@Autowired
	private EquipmentStatusService equipmentStatusService;
	
	@Autowired
	private AppProperties appProperties;

	@Autowired
	private EquipmentFaulLogService equipmentFaulLogService;

	@Autowired
	private TbSettingsService tbSettingsService;
	
	/**
	 * 自动更新设备网络状态
	 */
	@Scheduled(cron = "0 0/10 * * * ?")//每10分钟跑批一次
	@Transactional
	public void updateNetworkStatus(){
		log.info("定时任务开始-----自动更新设备网络状态");
		
		//查询出所有用户，做一下分页查询
		boolean f = true;
		Integer page = 1;
		Integer size = 100;
		Integer pingInterval = 3;
		TbSettings pingIntervalSet = tbSettingsService.queryBySettingsCode("pingInterval");
		if(pingIntervalSet!=null&&!StringUtils.isEmpty(pingIntervalSet.getSettingsValue())){
			pingInterval = Integer.parseInt(pingIntervalSet.getSettingsValue());
		}
		log.info("通信检查间隔时间 "+pingInterval+" 分钟");
		while(f){
			Page<TbEquipmentStatus> list = PageHelper.startPage(page, size);
			Map<String,Object> params = new HashMap<String,Object>();
			equipmentStatusService.selectByCondition(params);
			Integer totalPage = list.getPages();//总页数
			page = list.getPageNum();//从1开始
			List<TbEquipmentStatus> equipmentList = list.getResult();
			log.info("page"+page);
			for(TbEquipmentStatus equipment : equipmentList){
				//判断上一次更新时间是不是5分钟（和atm调用间隔时间保持一致）前
				Date now = new Date();
				Long nowt = now.getTime();
				Date updateTime = equipment.getUpdateTime();
				if("1".equals(equipment.getConnectStatus())){//如果状态已经是断网状态，忽略
					continue;
				}
				if(updateTime==null){
					equipment.setConnectStatus("1");//连接状态 0-正常 1-断网
					if("0".equals(equipment.getRunningStatus())) {//如果整机状态是正常
						equipment.setRunningStatus("3");//整机状态 0设备正常  ,1未激活 , 2-停用 3-异常
					}
					equipmentStatusService.update(equipment);
					logFault(equipment.getId());
					log.info("设备"+equipment.getId()+"网络状态更改为离线");
				}else{
					Long lastUpdate = updateTime.getTime();
					Long interval = (nowt - lastUpdate)/1000;//秒
					if(interval > pingInterval*2*60){//如果现在距离最近一次检测的时间差大于通信检测间隔时间的2倍
						equipment.setConnectStatus("1");//连接状态 0-正常 1-断网
						if("0".equals(equipment.getRunningStatus())) {//如果整机状态是正常
							equipment.setRunningStatus("3");
						}
						equipmentStatusService.update(equipment);
						logFault(equipment.getId());
						log.info("设备"+equipment.getId()+"网络状态更改为离线");
					}
				}
			}
			if(page >= totalPage){//如果是最后一页甚至超出最后一页，跳出循环
				break;
			}
			page++;
		}

		
		log.info("定时任务结束-----自动更新设备网络状态");
	}

	/**
	 * 将断网信息记录在故障表中
	 * @param equipmentId
	 */
	public void logFault(String equipmentId){
		TbEquipmentFaulLog tbEquipmentFaulLog = new TbEquipmentFaulLog();
		tbEquipmentFaulLog.setEquipmentId(equipmentId);
		tbEquipmentFaulLog.setCreateTime(new Date());
		tbEquipmentFaulLog.setConnectStatus("1");//网络连接状态 0-正常 1-断网
		tbEquipmentFaulLog.setIfDown("0");//是否关机
		equipmentFaulLogService.insert(tbEquipmentFaulLog);
	}

}
