package com.ichuvilin.user.service;

import com.ichuvilin.user.dto.NotificationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    public static final Random RANDOM = new Random();
    private final FakerService fakerService;
    private final RabbitTemplate rabbitTemplate;

    public List<String> getUsers() {
        List<String> res = new LinkedList<>();
        if (RANDOM.nextBoolean()) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < 5; i++) {
            res.add(fakerService.getUser());
        }
        log.info("Users: {}", res);
        return res;
    }

    @Scheduled(fixedDelay = 20000L)
    public void sendNotification() {
        var email = fakerService.getEmail();
        var title = fakerService.getTitle();
        var notify = new NotificationDTO(email, title);
        log.info("send notify: {}", notify);
        rabbitTemplate.convertAndSend("notification", "notification-email", notify);
    }
}
