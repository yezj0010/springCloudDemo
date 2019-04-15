package com.tomcat360.admin.microservice;

import com.tomcat360.admin.microservice.impl.DingDingServiceBack;
import com.tomcat360.admin.model.JSONData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jin.Deng on 2019/4/12.
 */
@FeignClient(value = "third", fallback = DingDingServiceBack.class)
public interface DingDingService {

	/**
	 * 发送钉钉消息
	 * @param message
	 * @return
	 */
	@PostMapping("/dingding/send")
	public JSONData send(@RequestParam("message") String message);

}
