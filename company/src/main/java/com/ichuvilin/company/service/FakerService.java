package com.ichuvilin.company.service;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FakerService {
    private static final Faker faker = new Faker();

    public String getCompany() {
        var company = faker.company().name();
        log.info("company name: {}", company);
        return company;
    }

}
