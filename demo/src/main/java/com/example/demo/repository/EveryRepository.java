package com.example.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.entity.EveryEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface EveryRepository extends ReactiveNeo4jRepository<EveryEntity, Long>{
    @Query("MATCH (n) RETURN n")

    Flux<EveryEntity> findAllNodes();

    @Query("MATCH (a:MixProof {name: $nameMP})" + "MATCH (b:Tanque {name: $nameT})" + "CREATE (a)-[:ROTA]->(b)")
    Mono<EveryEntity> createRMixProof(@Param("nameMP") String nameMP, @Param("nameT") String nameT);

    //Flux<EveryEntity> findAllRelationships();
}
