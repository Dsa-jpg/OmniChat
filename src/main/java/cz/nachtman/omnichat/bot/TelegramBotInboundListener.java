package cz.nachtman.omnichat.bot;

import cz.nachtman.omnichat.config.TelegramProperties;

import cz.nachtman.omnichat.model.SourcePlatform;
import cz.nachtman.omnichat.model.UnifiedMessage;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBotInboundListener extends TelegramLongPollingBot {

    private final TelegramProperties bridgeProperties;
    private final MessageRouter messageRouter;

    public TelegramBotInboundListener(TelegramProperties bridgeProperties, MessageRouter messageRouter){
        this.bridgeProperties = bridgeProperties;
        this.messageRouter = messageRouter;
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

            if (update.getMessage().getFrom().getIsBot()){
                return;
            }

            var msg = update.getMessage();

            var message = new UnifiedMessage(
                    SourcePlatform.TELEGRAM,
                    msg.getChatId(),
                    msg.getFrom().getFirstName() + " " + msg.getFrom().getLastName(),
                    msg.getText(),
                    msg.getMessageId().longValue());

            messageRouter.route(message);
        }
    }
}
