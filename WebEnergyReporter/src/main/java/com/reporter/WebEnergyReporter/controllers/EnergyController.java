package com.reporter.WebEnergyReporter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import com.reporter.WebEnergyReporter.services.EnergyService;

@RestController
@RequestMapping("/api/energy/v1.0")
@CrossOrigin(origins = "http://localhost:3000")
public class EnergyController {
    @Autowired
    private EnergyService service;

    //Надо пост оформить
    @GetMapping("/report")
    public ResponseEntity<Map<Integer, Integer>> getEnergy() {
        return ResponseEntity.ok(service.getEnergy());
    }

    @GetMapping("/report2")
    public ResponseEntity<Map<Integer, Integer>> getEnergy2() {
        service.saveEnergy(2,1);
        return ResponseEntity.ok(service.getEnergy());
    }
}

//@PostMapping
//public ResponseEntity<?> saveNumber(@RequestBody Map<String, Integer> payload) {
//    try {
//        int number = payload.get("number");
//        service.saveEnergy(1,2);
//        return ResponseEntity.ok().build();
//    } catch (IllegalArgumentException e) {
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }
//}