package com.example.demo.requests;

public class ValveToTankRequest {
    private String valveName;
    private String tankName;
    
    public ValveToTankRequest() {
    }

    public ValveToTankRequest(String valveName, String tankName) {
        this.valveName = valveName;
        this.tankName = tankName;
    }

    public String getValveName() {
        return valveName;
    }

    public void setValveName(String valveName) {
        this.valveName = valveName;
    }

    public String getTankName() {
        return tankName;
    }

    public void setTankName(String tankName) {
        this.tankName = tankName;
    }

    
    
}
