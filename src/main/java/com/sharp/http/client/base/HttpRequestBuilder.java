package com.sharp.http.client.base;

import com.zhaopin.common3.http.HttpUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;

public class HttpRequestBuilder {

    private String url;

    public HttpRequestBuilder(String url) {
        this.url = url;
    }

    public HttpRequestBase createGetRequest() {
        return new HttpGet(url);
    }

    public HttpRequestBuilder query() throws IOException {
        HttpRequestBase request = createGetRequest();
        HttpClientUtil.httpclient.execute(request, new JsonResponseHandler<HttpResponseBase>());
        return this;
    }

//    public HttpResponseBase queryAsJson() {
//        Http
//    }

    public static void main(String[] args) {

    }

}
