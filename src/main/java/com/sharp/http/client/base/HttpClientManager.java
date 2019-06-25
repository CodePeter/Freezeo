package com.sharp.http.client.base;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.util.concurrent.TimeUnit;

public class HttpClientManager {

    private final PoolingHttpClientConnectionManager manager;

    private final CloseableHttpClient client;

    public HttpClientManager() {
        manager = new PoolingHttpClientConnectionManager(60, TimeUnit.SECONDS);
        manager.setDefaultMaxPerRoute(100);
        manager.setMaxTotal(500);
        client = HttpClients.custom()
                .setConnectionManager(manager)
                .build();
    }

//    public static
}
