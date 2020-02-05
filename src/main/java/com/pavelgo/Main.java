package com.pavelgo;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by u7070 on 03.02.2020.
 */
public class Main {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
        HttpHost httpHost = new HttpHost("srv-gw-proxy02.BANK-BS.local", 3128);
        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy(httpHost)
                .build();
        botOptions.setRequestConfig(requestConfig);

        try {
            telegramBotsApi.registerBot(new Bot(botOptions));
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
}
