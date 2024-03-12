package com.ichuvilin.user.controller;

import com.ichuvilin.user.service.CompanyService;
import com.ichuvilin.user.service.FakerService;
import com.ichuvilin.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController {
    private final FakerService fakerService;
    private final CompanyService companyService;
    private final UserService userService;

    @GetMapping
    public String getUser() {
        return fakerService.getUser();
    }

    @GetMapping("/company")
    public String getCompany() {
        var company = companyService.getCompany();
        var user = fakerService.getUser();
        return "User %s work in company name: %s".formatted(user, company);
    }

    @GetMapping("/users")
    public List<String> getUsers() {
        return userService.getUsers();
    }
}
