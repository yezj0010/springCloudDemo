package com.tomcat360.third.model;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by jin.Deng on 2019/1/25.
 */
@Data
public class DingMessage {
	private String text;
	private List<String> atMobiles;
	private boolean isAtAll;

	public DingMessage(String text) {
		this.text = text;
	}

	public String toJsonString() {
		Map<String, Object> items = Maps.newHashMap();
		items.put("msgtype", "text");

		Map<String, String> textContent = Maps.newHashMap();
		if (StringUtils.isBlank(text)) {
			throw new IllegalArgumentException("text should not be blank");
		}
		textContent.put("content", text);
		items.put("text", textContent);

		Map<String, Object> atItems = Maps.newHashMap();
		if (!CollectionUtils.isEmpty(atMobiles)) {
			atItems.put("atMobiles", atMobiles);
		}
		if (isAtAll) {
			atItems.put("isAtAll", isAtAll);
		}
		items.put("at", atItems);

		return JSON.toJSONString(items);
	}
}
