package com.aloo.exercisebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {

    @GetMapping("/sayhello")
    public String sayHelloWorld(){
        return "Hello World!";
    }
}


