package com.ichuvilin.company.controller;

import com.ichuvilin.company.service.FakerService;
import com.ichuvilin.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CompanyController {
    private final FakerService fakerService;
    private final UserService userService;

    @GetMapping
    public String getCompany() {
        return fakerService.getCompany();
    }

    @GetMapping("/users")
    public String getUsersForCompany() {
        var users = userService.getUsers();
        return "Users for company: %s".formatted(users);
    }
}
