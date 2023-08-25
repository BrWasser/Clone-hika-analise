package com.example.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.example.demo.model.entity.EntryEntity;

import reactor.core.publisher.Flux;

public interface EntryRepository extends ReactiveNeo4jRepository<EntryEntity, Long>{
     @Query("MATCH (n: Entrada) RETURN n")

    Flux<EntryEntity> findAllEntries();
}
