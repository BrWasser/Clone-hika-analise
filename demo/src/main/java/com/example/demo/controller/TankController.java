package com.example.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.TankService;
import com.example.demo.model.entity.TankEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/tank")
public class TankController {
    private final TankService tankService;

    public TankController(TankService tankService){
        this.tankService= tankService;
    }

    @GetMapping()
    public Flux<TankEntity> findAllTanks(){       
        return tankService.findAllTanks();
    }

    @PostMapping()
    public Mono<TankEntity> createTank(@RequestBody TankEntity tank){
        return tankService.createTank(tank);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<TankEntity>> updateTank(@PathVariable Long id, @RequestBody TankEntity tank){
        Mono<TankEntity> updatedTank= tankService.updateTank(id, tank);
        return updatedTank.map(updated -> ResponseEntity.ok(updated))
        .defaultIfEmpty(ResponseEntity.notFound().build());    
    }
    @DeleteMapping("/{id}")
    public Mono<TankEntity> deleteTank(@PathVariable Long id){
        return tankService.deleteTank(id);
    }
}
