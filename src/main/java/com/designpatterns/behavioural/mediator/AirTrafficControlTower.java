package com.designpatterns.behavioural.mediator;

import java.util.ArrayList;
import java.util.List;

public class AirTrafficControlTower implements ControlTower {
    private List<Aircraft> aircrafts = new ArrayList<>();
    private GroundControl groundControl;
    private boolean runwayAvailable = true;

    @Override
    public void registerAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    @Override
    public void notifyGroundControl(GroundControl groundControl) {
        this.groundControl = groundControl;
    }

    @Override
    public void requestLanding(Aircraft aircraft) {
        if (runwayAvailable) {
            runwayAvailable = false;
            System.out.println("Tower: " + aircraft.getName() + " cleared for landing");

            for (Aircraft other : aircrafts) {
                if (other != aircraft) {
                    other.receiveMessage("Hold position, " + aircraft.getName() + " is landing");
                }
            }

            if (groundControl != null) {
                groundControl.receiveNotification(aircraft.getName() + " is landing");
            }
        } else {
            aircraft.receiveMessage("Runway occupied, please hold");
        }
    }

    @Override
    public void requestTakeoff(Aircraft aircraft) {
        if (runwayAvailable) {
            runwayAvailable = false;
            System.out.println("Tower: " + aircraft.getName() + " cleared for takeoff");
        } else {
            aircraft.receiveMessage("Runway occupied, hold for takeoff");
        }
    }

    @Override
    public void reportPosition(Aircraft aircraft, String position) {
        System.out.println("Tower: " + aircraft.getName() + " reported at " + position);
        runwayAvailable = true;

        if (groundControl != null) {
            groundControl.receiveNotification(aircraft.getName() + " at " + position);
        }
    }

    public int getAircraftCount() { return aircrafts.size(); }
    public boolean isRunwayAvailable() { return runwayAvailable; }
}
