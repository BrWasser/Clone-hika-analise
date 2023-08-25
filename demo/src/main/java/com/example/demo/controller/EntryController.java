package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.service.EntryService;
import com.example.demo.model.entity.EntryEntity;
import reactor.core.publisher.Flux;

@RestController
public class EntryController {
    private final EntryService entryService;

    public EntryController(EntryService entry_Service){
        this.entryService= entry_Service;
    }

    @GetMapping("/entry")
    public Flux<EntryEntity> findAllEntries(){       
        return entryService.findAllEntries();
    }
}
