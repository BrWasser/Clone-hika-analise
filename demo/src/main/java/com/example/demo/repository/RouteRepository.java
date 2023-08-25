package com.example.demo.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.entity.EveryEntity;
import com.example.demo.model.entity.RouteEntity;
import com.example.demo.model.entity.SolenoidEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RouteRepository extends ReactiveNeo4jRepository<EveryEntity, Long>{
    @Query("MATCH (every1:$every1),(every2: $every2) MERGE (every1)-[r:ROTA]->(every2) MERGE (every2)-[r2:ROTA]->(every1) RETURN r, r2")
    List<RouteEntity> createEdgeBiDirectional(@Param("every1") String every1, @Param("every2") String every2);
}
