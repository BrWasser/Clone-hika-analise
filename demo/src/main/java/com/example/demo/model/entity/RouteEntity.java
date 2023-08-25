package com.example.demo.model.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;


@RelationshipProperties
public class RouteEntity {

    @Id @GeneratedValue 
    private long id;
    String name;

    private String every1;

    private String every2;

    public RouteEntity() {
    }

    public RouteEntity(String every1, String every2){
        this.every1= every1;
        this.every2= every2;
    }


    // Id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    // Name
    public String getEvery1() {
        return every1;
    }
    public void setEvery1(String every1) {
        this.every1 = every1;
    }

        // Name
    public String getEvery2() {
        return every2;
    }
    public void setEvery2(String every2) {
        this.every2 = every2;
    }

}
