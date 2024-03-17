package com.ichuvilin.company.controller;

import com.ichuvilin.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public String getCompany() {
        return companyService.getCompany();
    }

    @GetMapping("/users")
    public String getUsersForCompany() {
        var users = companyService.getUsersForCompany();
        return "Users for company: %s".formatted(users);
    }
}
