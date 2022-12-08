package com.example.allowcorsfromdatabase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/data")
    public ResponseEntity<?> getData() {
        return ResponseEntity.ok("Data test");
    }
}
