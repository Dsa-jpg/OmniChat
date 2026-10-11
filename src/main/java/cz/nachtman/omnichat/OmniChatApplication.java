package cz.nachtman.omnichat;

import cz.nachtman.omnichat.config.TelegramProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class OmniChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(OmniChatApplication.class, args);
    }

}
