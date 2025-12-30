package com.designpatterns.behavioural.strategy;

public class FastestRouteStrategy implements RouteStrategy {

    @Override
    public Route calculateRoute(Location start, Location destination) {
        double distance = calculateDistance(start, destination) * 1.15;
        int estimatedTime = 32;
        double fuelCost = 6.50;

        String description = "Via Highway 101 (fastest route with minimal traffic)";

        return new Route(start, destination, distance, estimatedTime, fuelCost, description);
    }

    @Override
    public String getStrategyName() {
        return "Fastest Route (via highways)";
    }

    private double calculateDistance(Location start, Location destination) {
        double latDiff = destination.getLatitude() - start.getLatitude();
        double lonDiff = destination.getLongitude() - start.getLongitude();
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff) * 111;
    }
}
