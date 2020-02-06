package com.pavelgo;

import com.pavelgo.model.absense.Absence;
import com.pavelgo.model.teams.Teams;
import com.pavelgo.services.SpaceService;
import com.pavelgo.services.TelegramService;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by u7070 on 03.02.2020.
 */
public class Bot extends TelegramLongPollingBot {

    private SpaceService spaceService = new SpaceService();

    private TelegramService telegramService = new TelegramService();

    protected Bot(DefaultBotOptions botOptions) {
        super(botOptions);
    }

    public void onUpdateReceived(Update update) {
        try {
            Absence absence = spaceService.getAbsenses();
            Teams teams = spaceService.getTeams();
            String teamsResponse = telegramService.generateReportForTeams(teams);
            sendMsg(update.getMessage().getChatId().toString(), teamsResponse);
            sendMsg(update.getMessage().getChatId().toString(), telegramService.getAbsenceInfo(absence));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        setButtons(sendMessage);
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/teams"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

    }


    public String getBotUsername() {
        return "spacethreesome_bot";
    }

    public String getBotToken() {
        return "1068917448:AAGVsXCQtYPMx7vq8Bi4UJzxphmBqTpwODc";
    }


}
