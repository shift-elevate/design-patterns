package com.designpatterns.behavioural.mediator;

public interface ControlTower {
    void requestLanding(Aircraft aircraft);
    void requestTakeoff(Aircraft aircraft);
    void reportPosition(Aircraft aircraft, String position);
    void registerAircraft(Aircraft aircraft);
    void notifyGroundControl(GroundControl groundControl);
}
