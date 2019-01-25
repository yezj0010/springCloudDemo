package com.tomcat360.admin.model.mongodb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jin.Deng on 2019/1/25.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlowInfo {

	private Long id;

	private String operation;

	private Long time;

}
