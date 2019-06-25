package com.sharp.http.client;

import com.sharp.freezeo.Product;
import com.sharp.http.client.base.JsonResponseHandler;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientTest {
    public static void main(String[] args) throws IOException {
//        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
//// Increase max total connection to 200
//        cm.setMaxTotal(200);
//// Increase default max connection per route to 20
//        cm.setDefaultMaxPerRoute(20);
//// Increase max connections for localhost:80 to 50
//        HttpHost localhost = new HttpHost("locahost", 80);
//        cm.setMaxPerRoute(new HttpRoute(localhost), 50);
//
//        CloseableHttpClient httpClient = HttpClients.custom()
//                .setConnectionManager(cm)
//                .build();
//        HttpClients.createDefault();
//        HttpGet httpget = new HttpGet("http://localhost/");
//        CloseableHttpResponse response = httpClient.execute(httpget);
        //Creating an HttpHost object for proxy
//        HttpHost proxyhost = new HttpHost("zhaopin.com");
//
//        //Creating an HttpHost object for target
//        HttpHost targethost = new HttpHost("baidu.com");
//
//        //creating a RoutePlanner object
//        HttpRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxyhost);
//
//        //Setting the route planner to the HttpClientBuilder object
//        HttpClientBuilder clientBuilder = HttpClients.custom();
//        clientBuilder = clientBuilder.setRoutePlanner(routePlanner);
//
//        //Building a CloseableHttpClient
//        CloseableHttpClient httpclient = clientBuilder.build();
//
//        //Creating an HttpGet object
//        HttpGet httpget = new HttpGet("/");
//
//        //Executing the Get request
//        HttpResponse httpresponse = httpclient.execute(targethost, httpget);
//
//        //Printing the status line
//        System.out.println(httpresponse.getStatusLine());
//
//        //Printing all the headers of the response
//        Header[] headers = httpresponse.getAllHeaders();
//
//        for (int i = 0; i < headers.length; i++) {
//            System.out.println(headers[i]);
//        }
//
//        //Printing the body of the response
//        HttpEntity entity = httpresponse.getEntity();
//
//        if (entity != null) {
//            System.out.println(EntityUtils.toString(entity));
//
//
//        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://localhost/json");

//        ResponseHandler<MyJsonObject> rh = new ResponseHandler<MyJsonObject>() {
//
//            @Override
//            public JsonObject handleResponse(
//                    final HttpResponse response) throws IOException {
//                StatusLine statusLine = response.getStatusLine();
//                HttpEntity entity = response.getEntity();
//                if (statusLine.getStatusCode() >= 300) {
//                    throw new HttpResponseException(
//                            statusLine.getStatusCode(),
//                            statusLine.getReasonPhrase());
//                }
//                if (entity == null) {
//                    throw new ClientProtocolException("Response contains no content");
//                }
//                Gson gson = new GsonBuilder().create();
//                ContentType contentType = ContentType.getOrDefault(entity);
//                Charset charset = contentType.getCharset();
//                Reader reader = new InputStreamReader(entity.getContent(), charset);
//                return gson.fromJson(reader, MyJsonObject.class);
//            }
//        };
        Product myjson = httpclient.execute(httpget, new JsonResponseHandler<Product>());
    }
}
