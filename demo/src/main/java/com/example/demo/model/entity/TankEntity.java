package com.example.demo.model.entity;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node(labels = {"Tanque"})
public class TankEntity extends EveryEntity{
    
    // @Id
    // @GeneratedValue
    // private Long id;

    // private String name;

    @Property(name = "estado")
    private String status;

    @Property(name = "local")
    private String location;

    @Property(name = "condicao")
    private String condition;

    @Property(name = "sentido")
    private String way;

    public TankEntity(Long id, String name, String status, String location, String condition, String way) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.location = location;
        this.condition = condition;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
        
}
