package com.example.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.example.demo.model.entity.OutEntity;

import reactor.core.publisher.Flux;

public interface OutRepository extends ReactiveNeo4jRepository<OutEntity, Long>{
     @Query("MATCH (n: Saida) RETURN n")

    Flux<OutEntity> findAllOuts();
}
