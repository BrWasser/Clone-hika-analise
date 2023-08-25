package com.example.demo.model.entity;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node(labels = {"MixProof"})
public class MixProofEntity extends EveryEntity{
    // @Id
    // @GeneratedValue
    // private Long id;

    // private String name;

    @Property(name = "local")
    private String location;

    @Property(name = "sentido")
    private String way;


    public MixProofEntity(Long id, String name, String location, String way) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.way = way;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

     public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
}
