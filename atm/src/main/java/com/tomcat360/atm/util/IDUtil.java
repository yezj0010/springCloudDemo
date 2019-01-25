package com.tomcat360.atm.util;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by jin.Deng on 2018/9/28.
 */
@Component
@Slf4j
public class IDUtil {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public static String getId() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}

	public String getTimestamp() {
		long l1 = 0;
		String key = "getTimestamp";
		int i = 1;
		//如果没有获取到，就一直获取
		while(l1 == 0){
			log.info("第"+i+"次获取流水");//后期删除此代码
			i++;
			try {
				String test = stringRedisTemplate.opsForValue().get(key);
				//判断是否被锁住
				if (StringUtils.isEmpty(test)) {
					//如果没有被锁住，则锁住
					stringRedisTemplate.opsForValue().set(key, "timestamp");
					try{
						//获取流水号
						l1 = Long.valueOf((System.currentTimeMillis() + "").substring(1) + (System.nanoTime() + "").substring(7, 10));
					}catch(Throwable e){
						log.error("获取流水号失败");
						throw e;
					}finally {
						//解锁
						stringRedisTemplate.opsForValue().set(key, "");
					}
				} else {
					//如果被锁住，停2毫秒
					Thread.sleep(2);
				}

				if(l1 == 0 && i > 10){
					log.error("等待10次后，直接获取流水号");
					//如果等了10次，还是锁住状态，直接获取流水号，重复了就算了，避免获取redis中数据值不对，导致的等待
					l1 = Long.valueOf((System.currentTimeMillis() + "").substring(1) + (System.nanoTime() + "").substring(7, 10));
				}
			} catch (Throwable e) {
				log.info("线程休眠失败");
				//如果抛异常，则直接获取流水号
				l1 = Long.valueOf((System.currentTimeMillis() + "").substring(1) + (System.nanoTime() + "").substring(7, 10));
				e.printStackTrace();
			}
		}

		return l1 + "";
	}

}
