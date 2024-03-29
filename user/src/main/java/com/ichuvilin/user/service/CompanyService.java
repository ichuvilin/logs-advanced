package com.ichuvilin.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(name = "company")
public interface CompanyService {

    @GetMapping("/company")
    String getCompany();
}
