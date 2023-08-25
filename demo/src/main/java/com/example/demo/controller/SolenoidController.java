package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SolenoidService;
import com.example.demo.model.entity.SolenoidEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/solenoid")
public class SolenoidController {
    private final SolenoidService solenoidService;

    public SolenoidController(SolenoidService solenoidService){
        this.solenoidService= solenoidService;
    }

    @GetMapping()
    public Flux<SolenoidEntity> findAllSolenoids(){       
        return solenoidService.findAllSolenoids();
    }
    
    @PostMapping()
    public Mono<SolenoidEntity> createSolenoid(@RequestBody SolenoidEntity solenoid){
        return solenoidService.createSolenoid(solenoid);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<SolenoidEntity>> updateSolenoid(@PathVariable Long id, @RequestBody SolenoidEntity solenoid){
        Mono<SolenoidEntity> updatedSolenoid= solenoidService.updateSolenoid(id, solenoid);
        return updatedSolenoid.map(updated -> ResponseEntity.ok(updated))
        .defaultIfEmpty(ResponseEntity.notFound().build());    
    }
    @DeleteMapping("/{id}")
    public Mono<SolenoidEntity> deleteSolenoid(@PathVariable Long id){
        return solenoidService.deleteSolenoid(id);
    }
}
