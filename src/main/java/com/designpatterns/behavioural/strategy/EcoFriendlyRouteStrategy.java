package com.designpatterns.behavioural.strategy;

public class EcoFriendlyRouteStrategy implements RouteStrategy {

    @Override
    public Route calculateRoute(Location start, Location destination) {
        double distance = calculateDistance(start, destination) * 1.05;
        int estimatedTime = 42;
        double fuelCost = 4.90;

        String description = "Via Suburban Roads (optimized for fuel efficiency)";

        return new Route(start, destination, distance, estimatedTime, fuelCost, description);
    }

    @Override
    public String getStrategyName() {
        return "Eco-Friendly Route (fuel optimized)";
    }

    private double calculateDistance(Location start, Location destination) {
        double latDiff = destination.getLatitude() - start.getLatitude();
        double lonDiff = destination.getLongitude() - start.getLongitude();
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff) * 111;
    }
}
