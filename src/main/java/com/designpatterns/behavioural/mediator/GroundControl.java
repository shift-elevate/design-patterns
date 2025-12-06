package com.designpatterns.behavioural.mediator;

public class GroundControl {
    private String name;

    public GroundControl(String name) {
        this.name = name;
    }

    public void receiveNotification(String message) {
        System.out.println(name + " notified: " + message);
    }

    public String getName() {
        return name;
    }
}
