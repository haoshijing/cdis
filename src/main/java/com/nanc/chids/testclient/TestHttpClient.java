package com.nanc.chids.testclient;

import io.netty.channel.DefaultEventLoop;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.AsyncClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.net.URI;

public class TestHttpClient {
    public static void main(String[] args) throws Exception{
        AsyncClientHttpRequest asyncClientHttpRequest =
                new Netty4ClientHttpRequestFactory(new DefaultEventLoopGroup(2,new DefaultThreadFactory("HttpClientThread"))).
                createAsyncRequest( URI.create("http://localhost:8082/index"), HttpMethod.GET);
        asyncClientHttpRequest.executeAsync().addCallback(new ListenableFutureCallback<ClientHttpResponse>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("throwable = [" + throwable + "]");
            }

            @Override
            public void onSuccess(ClientHttpResponse clientHttpResponse) {
                System.out.println("clientHttpResponse = [" + clientHttpResponse + "]");
            }
        });

        System.in.read();
    }
}
