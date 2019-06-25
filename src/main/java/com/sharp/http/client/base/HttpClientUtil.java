package com.sharp.http.client.base;

import com.zhaopin.common3.http.builder.AbstractHttpRequestBuilder;
import com.zhaopin.common3.http.holder.JsonHttpResponseHandler;
import com.zhaopin.common3.http.holder.JsonResponseHolder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpClientUtil {

    public static CloseableHttpClient httpclient = HttpClients.createDefault();


    public static HttpRequestBuilder createGet(String url) {
        return new HttpRequestBuilder(url);
    }

//    public static <T> T build(HttpRequestBase request, JsonResponseHandler<T> jsonResponseHandler) {
//        T value = null;
//        try {
//            value = httpclient.execute(request, jsonResponseHandler);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return value;
//    }

//    public static HttpResponseBase queryAsJson(HttpRequestBuilder builder) {
//        return query(builder, new JsonHttpResponseHandler());
//    }

//    public static void main(String[] args) {
//        HttpClientUtil.createGet("").
//    }
}
