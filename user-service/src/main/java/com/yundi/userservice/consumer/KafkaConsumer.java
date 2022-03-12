package com.yundi.userservice.consumer;

import com.yundi.userservice.user.model.User;
import com.yundi.userservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class KafkaConsumer {

    private final UserService userService;

    @Bean
    Consumer<UserData> userRegistration() {
        return userData -> {
            userService.save(new User(userData));
        };
    }
}
