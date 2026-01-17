package com.github.gustavodscruz.vota_logo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok("Hello world!");
    }
}
