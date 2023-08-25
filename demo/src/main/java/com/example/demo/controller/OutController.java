package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OutService;
import com.example.demo.model.entity.OutEntity;
import reactor.core.publisher.Flux;

@RestController
public class OutController {
    private final OutService outService;

    public OutController(OutService out_Service){
        this.outService= out_Service;
    }

    @GetMapping("/out")
    public Flux<OutEntity> findAllOuts(){       
        return outService.findAllOuts();
    }
}
