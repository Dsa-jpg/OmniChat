package cz.nachtman.omnichat.bot;


import cz.nachtman.omnichat.model.UnifiedMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageRouter {

    private final MessageFormatter messageFormatter;
    
    public MessageRouter(MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    public void route(UnifiedMessage unifiedMessage){
        var message = messageFormatter.format(unifiedMessage);
        sendMessage(message);

    }

    private void sendMessage(String message){

    }


}
