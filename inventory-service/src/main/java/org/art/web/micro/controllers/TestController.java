package org.art.web.micro.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${message:Hello default}")
    private String helloProp;

    @GetMapping("/hello")
    public String hello() {
        return this.helloProp;
    }
}
