package com.designpatterns.behavioural.command;

public class Fan {
    private String location;
    private int speed = 0;
    
    public Fan(String location) {
        this.location = location;
    }
    
    public void setSpeed(int speed) {
        this.speed = Math.max(0, Math.min(3, speed));
        if (this.speed == 0) {
            System.out.println(location + " fan is OFF");
        } else {
            System.out.println(location + " fan speed set to " + this.speed);
        }
    }
    
    public int getSpeed() { 
        return speed; 
    }
    
    public String getLocation() {
        return location;
    }
}
