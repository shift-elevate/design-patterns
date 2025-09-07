package com.designpatterns.behavioural.command.receivers;

public class Light {
    private String location;
    private boolean isOn = false;
    
    public Light(String location) {
        this.location = location;
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println(location + " light is now ON");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println(location + " light is now OFF");
    }
    
    public boolean isOn() { 
        return isOn; 
    }
    
    public String getLocation() {
        return location;
    }
}
