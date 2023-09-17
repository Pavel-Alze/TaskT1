package com.example.taskT1.controllers;

import com.example.taskT1.services.Service;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
public class MainController {

private final Service service;

    public MainController(Service service) {
        this.service = service;
    }

    @GetMapping(value = "/task")
    public ResponseEntity<?> task(@RequestParam String str){
        try {
            LinkedHashMap response;
            response = service.sort(str);
            return new ResponseEntity<>(response.entrySet(), HttpStatusCode.valueOf(200));
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatusCode.valueOf(500));
        }
    }
}
