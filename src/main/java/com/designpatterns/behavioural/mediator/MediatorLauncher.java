package com.designpatterns.behavioural.mediator;

public class MediatorLauncher {

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("MEDIATOR PATTERN - AIR TRAFFIC CONTROL");
        System.out.println("=".repeat(60));

        ControlTower tower = new AirTrafficControlTower();

        GroundControl groundControl = new GroundControl("Ground Control");
        tower.notifyGroundControl(groundControl);

        Aircraft flight1 = new Aircraft("Flight 101", tower);
        Aircraft flight2 = new Aircraft("Flight 202", tower);

        System.out.println("\n1. Flight 1 Requests Landing:");
        System.out.println("-".repeat(60));
        flight1.requestLanding();

        System.out.println("\n2. Flight 2 Requests Landing (Runway Occupied):");
        System.out.println("-".repeat(60));
        flight2.requestLanding();

        System.out.println("\n3. Flight 1 Reports Position:");
        System.out.println("-".repeat(60));
        flight1.reportPosition("Gate A");

        System.out.println("\n4. Flight 2 Requests Landing Again (Runway Available):");
        System.out.println("-".repeat(60));
        flight2.requestLanding();

        System.out.println("\n" + "=".repeat(60));
        System.out.println("MEDIATOR PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }
}
