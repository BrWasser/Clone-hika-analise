package com.example.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.entity.MixProofEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface MixProofRepository extends ReactiveNeo4jRepository<MixProofEntity, Long>{
    @Query("MATCH (n: MixProof) RETURN n")
    Flux<MixProofEntity> findAllMixProofs();

    @Query("CREATE (n: MixProof{name: $name, local: $location, sentido: $way}) RETURN n")
    Mono<MixProofEntity> createMixProof(@Param("name") String name, @Param("location") String location, @Param("way") String way);

    @Query("MATCH (n:MixProof) WHERE id(n) = $id SET n.name = $name, n.local = $location, n.sentido = $way RETURN n")
    Mono<MixProofEntity> updateMixProof(Long id, String name, String location, String way);

    @Query("MATCH (n: MixProof) WHERE id(n) = $id DELETE n")
    Mono<MixProofEntity> deleteMixProof(Long id);

    @Query("MATCH (m:MixProof), (t:Tanque) WHERE m.name = $mixproof AND t.name = $tank " +
    "RETURN EXISTS((m)-[:ROTA]->(t))")
    Boolean checkRelationshipValveTank(String valvulaName, String tankName);

    @Query("MATCH (a:MixProof {name: $nameMP})" + "MATCH (b:Tanque {name: $nameT})" + "CREATE (a)-[:ROTA]->(b)")
    Mono<MixProofEntity> createRMixProof(@Param("nameMP") String nameMP, @Param("nameT") String nameT);
}
