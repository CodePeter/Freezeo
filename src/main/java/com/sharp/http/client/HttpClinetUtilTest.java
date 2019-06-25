package com.sharp.http.client;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sharp.freezeo.Product;
import com.sharp.http.client.base.ResultPlatformModel;
import com.zhaopin.common3.http.HttpUtils;
import org.apache.http.entity.ContentType;

public class HttpClinetUtilTest {
    public static void main(String[] args) {
        ResultPlatformModel<Product> resultPlatformModel = HttpUtils.createPost("")
                .setContentType(ContentType.APPLICATION_JSON)
                .setRequestBody(JSON.toJSONString(new Object()))
//                .queryAsString()
                .queryAsJson()
                .getValue(new TypeReference<ResultPlatformModel<Product>>() {
                });
    }
}
