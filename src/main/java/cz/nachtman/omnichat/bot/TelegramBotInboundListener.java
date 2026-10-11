package cz.nachtman.omnichat.bot;

import cz.nachtman.omnichat.config.TelegramProperties;

import cz.nachtman.omnichat.model.SourcePlatform;
import cz.nachtman.omnichat.model.UnifiedMessage;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class TelegramBotInboundListener extends TelegramLongPollingBot {

    private final TelegramProperties bridgeProperties;

    public TelegramBotInboundListener(TelegramProperties bridgeProperties){
        this.bridgeProperties = bridgeProperties;
    }

    @Override
    public String getBotUsername() {
        return bridgeProperties.getTelegram().getBotUsername();
    }

    @Override
    public String getBotToken() {
        return bridgeProperties.getTelegram().getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            var msg = update.getMessage();

            var message = new UnifiedMessage(SourcePlatform.TELEGRAM, msg.getChatId(), msg.getFrom().getFirstName().concat(msg.getFrom().getLastName()) , msg.getText(), msg.getMessageId().longValue() );


            System.out.println(message);
        }

    }
}
