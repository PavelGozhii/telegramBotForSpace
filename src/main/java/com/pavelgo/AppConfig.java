package com.pavelgo;

import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by u7070 on 03.02.2020.
 */
@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        HttpHost httpHost = new HttpHost("srv-gw-proxy02.BANK-BS.local", 3128);
        CloseableHttpClient client = HttpClients.custom()
                .setProxy(httpHost)
                .build();

        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpComponentsClientHttpRequestFactory.setHttpClient(client);
        return new RestTemplate(httpComponentsClientHttpRequestFactory);
    }
}
