package com.example.demo.service;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.EveryEntity;
import com.example.demo.model.entity.MixProofEntity;
import com.example.demo.repository.EveryRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service 
public class EveryService {
      private final EveryRepository everyRepository;

      public EveryService(EveryRepository everyRepository) {
         this.everyRepository = everyRepository;
     }

     public Flux<EveryEntity> findAllNodes(){
        return everyRepository.findAllNodes();
     }

   //    public Flux<EveryEntity> findAllRelationships(){
   //      return everyRepository.findAllRelationships();
   //   }

      public Mono<EveryEntity> createRMixProof(EveryEntity every, EveryEntity every2){ 
      return everyRepository.createRMixProof(
         every.getName(),
         every2.getName()
         ); 
   }
}

