package ksendr;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();

        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());

        if(update.getMessage().getText().equals("Привет")){
            sendMessage.setText("Приветствую!");
            try {
                execute(sendMessage);
        }catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String getBotUsername() {
        return "@KsendrBot";
    }

       @Override
    public String getBotToken() {
        return "1802368336:AAFF5MBmpXnu6eiG3Fvn31aCFxg1HXtc6aU";
    }
}
