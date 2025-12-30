package com.designpatterns.behavioural.strategy;

public class Route {
    private Location start;
    private Location destination;
    private double distance;
    private int estimatedTime;
    private double fuelCost;
    private String description;

    public Route(Location start, Location destination, double distance,
                int estimatedTime, double fuelCost, String description) {
        this.start = start;
        this.destination = destination;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
        this.fuelCost = fuelCost;
        this.description = description;
    }

    public Location getStart() {
        return start;
    }

    public Location getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Route: %s → %s\n" +
                           "  %s\n" +
                           "  Distance: %.1f km\n" +
                           "  Time: %d minutes\n" +
                           "  Fuel Cost: $%.2f",
                start.getName(), destination.getName(),
                description, distance, estimatedTime, fuelCost);
    }
}
