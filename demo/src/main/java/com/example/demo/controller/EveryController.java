package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EveryService;
import com.example.demo.model.entity.EveryEntity;
import com.example.demo.model.entity.RouteEntity;
import com.example.demo.repository.RouteRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class EveryController {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private EveryService everyService;


    @GetMapping("/every")
    public Flux<EveryEntity> findAllNodes(){       
        return everyService.findAllNodes();
    }

    // @GetMapping("/everyR")
    // public Flux<EveryEntity> findAllRelationships(){       
    //     return everyService.findAllRelationships();
    // }

    @PostMapping("/teste")
    public Mono<EveryEntity> createRMixProof(@RequestBody EveryEntity every, EveryEntity every2){
        return everyService.createRMixProof(every, every2);
    }
    @PostMapping("/pihidi")
    public List<RouteEntity> createEdge(@RequestBody RouteEntity every){
        String every1_route= every.getEvery1();
        String every2_route= every.getEvery2();
        
        

        return routeRepository.createEdgeBiDirectional(every1_route, every2_route);
        
    }
}
