package cz.nachtman.omnichat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "bridge")
public class TelegramProperties {

    private Telegram telegram;
    private List<ChannelMapping> channels;

    @Data
    public static class Telegram {
        private String botToken;
        private String botUsername;
    }

    @Data
    public static class ChannelMapping {
        private String name;
        private String telegramId;
    }
}
