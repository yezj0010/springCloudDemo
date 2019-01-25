package com.tomcat360.admin.model.mq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jin.Deng on 2019/1/22.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseMessage {

	private String type;

	private String messge;
}
