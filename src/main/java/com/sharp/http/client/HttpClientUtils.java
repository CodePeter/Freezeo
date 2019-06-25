package com.sharp.http.client;

import com.sharp.http.client.base.HttpExecutor;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.util.concurrent.TimeUnit;

public class HttpClientUtils {

    public static HttpExecutor httpExecutor = new HttpExecutor();

    public static CloseableHttpResponse httpGetResponse(String url) {
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = httpExecutor.execute(httpget);
        return response;
    }

//    public static
}
