package com.sharp.http.client.base;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HttpExecutor {

    private final PoolingHttpClientConnectionManager manager;

    private final CloseableHttpClient client;

    public HttpExecutor() {
        manager = new PoolingHttpClientConnectionManager(60, TimeUnit.SECONDS);
        manager.setDefaultMaxPerRoute(100);
        manager.setMaxTotal(500);
        client = HttpClients.custom()
                .setConnectionManager(manager)
                .build();
    }

    public CloseableHttpResponse execute(HttpRequestBase requestBase) {
        CloseableHttpResponse response = null;
        try {
            response = client.execute(requestBase);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
