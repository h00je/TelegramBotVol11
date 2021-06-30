package ksendr;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    private long chat_id;
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

    public void onUpdateReceived(Update update) {
        update.getUpdateId();


        chat_id = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage()
                .setChatId(chat_id)
                .setText(getMessage(update.getMessage().getText()));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }


    public String getBotUsername() {
        return "@KsendrBot";
    }

    public String getBotToken() {
        return "1802368336:AAFF5MBmpXnu6eiG3Fvn31aCFxg1HXtc6aU";
    }

    public String getMessage(String msg) {
        ArrayList<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        if (msg.equals("Привет") || msg.equals("Меню") || msg.equals("/start") || msg.equals("Вернуться назад")) {
            keyboard.clear(); // чиста клавиатуры
            keyboardFirstRow.add("Обо мне"); // кнопки первого ряда
            keyboardFirstRow.add("Работы");
            keyboardFirstRow.add("Полезная информация");
            keyboardSecondRow.add("Свободные места"); // кнопки второго ряда
            keyboardSecondRow.add("Как записаться");
            keyboardSecondRow.add("Фоточки Цирюхи");
            keyboard.add(keyboardFirstRow); //Добавление рядов
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard); // Обвновление клавиатуры
            return "Выберите пункт меню";
        }
        if (msg.equals("Фоточки Цирюхи")) {
            return "Пока в разработке";
        }
        if (msg.equals("Обо мне")) {
            return "Я Костриж, я Бомжук";
        }
        if (msg.equals("Работы")) {
            return "Я правда делаю красивые реснички";
        }
        if (msg.equals("Полезная информация")) {
            keyboard.clear(); // чиста клавиатуры
            keyboardFirstRow.add("Длительность процедур"); // кнопки первого ряда
            keyboardFirstRow.add("Разница в видах наращивания");
            keyboardSecondRow.add("Как ухаживать за ресничками");
            keyboardSecondRow.add("Вернуться назад");// кнопки второго ряда
            keyboard.add(keyboardFirstRow); //Добавление рядов
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard); // Обвновление клавиатуры
            return "Выберите пункт меню";
        }

        if (msg.equals("Как записаться")) {
            return "@ksenika_7";
        }
        return "Если возникли проблемы, воспользуйтесь /start";

    }

}
