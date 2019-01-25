package com.tomcat360.admin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * JSON响应对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JSONData {

    private String code;
    private String msg;
    @JSONField(name = "data",serialzeFeatures = {SerializerFeature.WriteMapNullValue})
    private Map<String, ?> data;
}
