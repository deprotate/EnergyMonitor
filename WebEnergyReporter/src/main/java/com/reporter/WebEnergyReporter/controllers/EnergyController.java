package com.reporter.WebEnergyReporter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import org.springframework.http.HttpStatus;


import java.util.Map;

import com.reporter.WebEnergyReporter.services.EnergyService;
import com.reporter.WebEnergyReporter.DTO.EnergyRequestDTO;

@RestController
@RequestMapping("/api/energy/v1.0")
@CrossOrigin(origins = "http://localhost:3000")
public class EnergyController {
    @Autowired
    private EnergyService service;


    @GetMapping("/report")
    public ResponseEntity<Map<Integer, Integer>> getEnergy() {
        return ResponseEntity.ok(service.getEnergy());
    }

    @GetMapping("/report2")
    public ResponseEntity<Map<Integer, Integer>> getEnergy2() {
       // service.saveEnergy(2,1);
        return ResponseEntity.ok(service.getEnergy());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEnergy(@RequestBody EnergyRequestDTO requestDTO) {
        boolean isAdded = service.addEnergy(requestDTO);

        if (isAdded) {
            return new ResponseEntity<>("Energy entry added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Invalid password", HttpStatus.UNAUTHORIZED);

        }
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