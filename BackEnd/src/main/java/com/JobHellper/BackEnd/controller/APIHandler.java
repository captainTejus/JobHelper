package com.JobHellper.BackEnd.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JobHellper.BackEnd.services.NumberServices;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173") // Vite default port
public class APIHandler {

    private final NumberServices numberService;

    @Autowired
    public APIHandler(NumberServices numberService) {
        this.numberService = numberService;
    }
     
    @GetMapping("/test/{count}")
    public ResponseEntity<Map<String, Object>> processNumber(@PathVariable int count) {
        int result = numberService.processedNumber(count);
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Processed count: " + count);
        response.put("result", result);
        response.put("count", count);
           return ResponseEntity.ok(response);
    }

}
