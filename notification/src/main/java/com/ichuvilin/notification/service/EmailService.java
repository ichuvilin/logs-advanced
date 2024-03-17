package com.ichuvilin.notification.service;

import com.ichuvilin.notification.dto.NotificationDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EmailService {
    @RabbitListener(queues = "email")
    private void processNotify(NotificationDTO dto) {
        log.info("processing notify: {}", dto);
    }
}
