package com.capco.expensesapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MainController {

    @GetMapping("/")
    public ResponseEntity<String> getHelloText() {
        log.info("getHelloText()");
        return ResponseEntity.ok().body("My CAPCO family is the best!");
    }
}
