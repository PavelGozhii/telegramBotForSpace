package com.pavelgo;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by u7070 on 03.02.2020.
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) throws UnknownHostException {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
//        HttpHost httpHost = new HttpHost("srv-gw-proxy02.BANK-BS.local", 3128);
//        RequestConfig requestConfig = RequestConfig.custom()
//                .setProxy(httpHost)
//                .build();
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP Address" + inetAddress.getHostAddress());
//        botOptions.setRequestConfig(requestConfig);
        try {
            SpringApplication.run(Main.class, args);
            telegramBotsApi.registerBot(new Bot(botOptions));
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
}
