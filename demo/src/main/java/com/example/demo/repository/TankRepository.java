package com.example.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.entity.TankEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TankRepository extends ReactiveNeo4jRepository<TankEntity, Long> {
    @Query("MATCH (n: Tanque) RETURN n")
    Flux<TankEntity> findAllTanks();

    @Query("CREATE (n: Tanque{name: $name, estado: $status, local: $location, condicao: $condition, sentido: $way}) RETURN n")
    Mono<TankEntity> createTank(@Param("name") String name, @Param("status") String status, @Param("condition") String condition, @Param("location") String location,  @Param("way") String way);

    @Query("MATCH (n:Tanque) WHERE id(n) = $id SET n.name = $name, n.estado = $status, n.local = $location, n.condicao = $condition, n.sentido = $way RETURN n")
    Mono<TankEntity> updateTank(Long id, String name, String status, String location, String condition, String way);

    @Query("MATCH (n:Tanque) WHERE id(n) = $id DELETE n")
    Mono<TankEntity> deleteTank(Long id);
}

