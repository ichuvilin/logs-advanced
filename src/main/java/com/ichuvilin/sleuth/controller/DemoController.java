package com.ichuvilin.sleuth.controller;

import com.ichuvilin.sleuth.service.FakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("demo")
@RequiredArgsConstructor
public class DemoController {
    private final FakerService fakerService;

    @GetMapping
    public String greetings() {
        var firstName = fakerService.getRandomName();
        log.info("first name is {}", firstName);
        return "Hello, %s".formatted(firstName);
    }

    @GetMapping("/error")
    public void error() throws IOException {
        log.error("IOException");
        throw new IOException("Just check error");
    }
}
