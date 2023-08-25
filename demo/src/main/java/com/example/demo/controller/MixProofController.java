package com.example.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MixProofService;
import com.example.demo.model.entity.MixProofEntity;
import com.example.demo.requests.ValveToTankRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mixproof")
public class MixProofController {
    private final MixProofService mixProofService;

    public MixProofController(MixProofService mixproof_Service){
        this.mixProofService= mixproof_Service;
    }

    @GetMapping()
    public Flux<MixProofEntity> findAllMixProofs(){       
        return mixProofService.findAllMixProofs();
    }

    @PostMapping("/teste3")
    public Mono<MixProofEntity> createMixProof(@RequestBody MixProofEntity mixproof){
        return mixProofService.createMixProof(mixproof);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<MixProofEntity>> updateMixProof(@PathVariable Long id, @RequestBody MixProofEntity mixproof){
        Mono<MixProofEntity> updatedMixProof= mixProofService.updateMixProof(id, mixproof);
        return updatedMixProof.map(updated -> ResponseEntity.ok(updated))
        .defaultIfEmpty(ResponseEntity.notFound().build());    
    }
    @DeleteMapping("/{id}")
    public Mono<MixProofEntity> deleteMixProof(@PathVariable Long id){
        return mixProofService.deleteMixProof(id);
    }

    @PostMapping("/teste1")
    public ResponseEntity<String> connectValveToTank(@RequestBody ValveToTankRequest request){
        String valveName = request.getValveName();
        String tankName = request.getTankName();

        if(mixProofService.checkRelationshipValveTank(valveName, tankName)){
            return new ResponseEntity<String>("Conexão já existente entre Valvula " + valveName + " e Tanque " + tankName, HttpStatus.OK);
        }

        mixProofService.createRelationshipValveTank(valveName, tankName);

        return new ResponseEntity<String>("Conexao entre Valvula " + valveName + " e Tanque " + tankName, HttpStatus.OK);
    }
}
