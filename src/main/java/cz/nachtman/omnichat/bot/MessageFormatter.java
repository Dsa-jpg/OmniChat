package cz.nachtman.omnichat.bot;

import cz.nachtman.omnichat.model.UnifiedMessage;

public interface MessageFormatter {

    String format(UnifiedMessage unifiedMessage);
}
