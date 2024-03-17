package com.ichuvilin.company.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyService {
    private final FakerService fakerService;
    private final UserService userService;


    public String getCompany() {
        return fakerService.getCompany();
    }

    public String getUsersForCompany() {
        var users = userService.getUsers();
        log.info("users: {}", users);
        return "Users for company: %s".formatted(users);
    }
}
