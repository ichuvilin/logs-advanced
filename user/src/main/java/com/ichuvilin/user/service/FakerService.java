package com.ichuvilin.user.service;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FakerService {
    private static final Faker faker = new Faker();

    public String getUser() {
        return faker.name().firstName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getTitle() {
        return faker.dune().title();
    }
}
