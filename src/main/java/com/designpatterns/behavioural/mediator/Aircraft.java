package com.designpatterns.behavioural.mediator;

public class Aircraft {
    private String name;
    private ControlTower tower;

    public Aircraft(String name, ControlTower tower) {
        this.name = name;
        this.tower = tower;
        tower.registerAircraft(this);
    }

    public void requestLanding() {
        System.out.println(name + ": Requesting landing clearance");
        tower.requestLanding(this);
    }

    public void requestTakeoff() {
        System.out.println(name + ": Requesting takeoff clearance");
        tower.requestTakeoff(this);
    }

    public void reportPosition(String position) {
        System.out.println(name + ": Reporting position - " + position);
        tower.reportPosition(this, position);
    }

    public void receiveMessage(String message) {
        System.out.println(name + " received: " + message);
    }

    public String getName() {
        return name;
    }
}
