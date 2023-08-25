package com.example.demo.model.entity;

import org.springframework.data.neo4j.core.schema.Node;

@Node(labels = {"Entrada"})
public class EntryEntity extends EveryEntity{
    
    // @Id
    // @GeneratedValue
    // private Long id;

    // private String name;

    public EntryEntity(Long id, String name) {
        this.id = id;
        this.name = name;
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

}
