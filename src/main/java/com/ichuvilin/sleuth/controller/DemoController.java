package com.ichuvilin.sleuth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("demo")
public class DemoController {

    @GetMapping
    public String greetings() {
        log.info("greeting EP");
        var s = generateName();
        log.info("name:{}", s);
        return "Hello, %s".formatted(s);
    }

    private String generateName() {
        return "Ivan";
    }
}
