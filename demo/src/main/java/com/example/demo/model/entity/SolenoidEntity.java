package com.example.demo.model.entity;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;


@Node(labels = {"Solenoide"})
public class SolenoidEntity extends EveryEntity{

    // @Id
    // @GeneratedValue
    // private Long id;

    // private String name;

    @Property(name = "estado")
    private String status;

    @Property(name = "local")
    private String location;

    public SolenoidEntity(Long id, String name, String status, String location) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.location = location;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
}
