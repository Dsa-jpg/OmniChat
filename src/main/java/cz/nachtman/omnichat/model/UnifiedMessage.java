package cz.nachtman.omnichat.model;

public record UnifiedMessage(
        SourcePlatform sourcePlatform,
        Long sourceGroupId,
        String senderName,
        String textPayload,
        Long messageId
) {}
