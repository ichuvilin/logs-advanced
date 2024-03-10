package com.ichuvilin.sleuth.service;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FakerService {
    private static final Faker faker = new Faker();

    @Scheduled(fixedDelay = 2000)
    public void generated() {
        log.info("This just logs with random name: {}", faker.name().firstName());
    }

    public String getRandomName() {
        return faker.name().firstName();
    }

}
