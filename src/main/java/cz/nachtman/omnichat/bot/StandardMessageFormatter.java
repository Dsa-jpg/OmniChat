package cz.nachtman.omnichat.bot;

import cz.nachtman.omnichat.model.UnifiedMessage;
import org.springframework.stereotype.Component;

@Component
public class StandardMessageFormatter implements MessageFormatter {

    @Override
    public String format(UnifiedMessage unifiedMessage) {
        return String.format("[%s - %s]: %s",
                unifiedMessage.sourcePlatform(),
                unifiedMessage.senderName(),
                unifiedMessage.textPayload());
    }
}
