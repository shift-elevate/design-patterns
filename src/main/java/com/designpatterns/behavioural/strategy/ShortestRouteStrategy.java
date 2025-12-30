package com.designpatterns.behavioural.strategy;

public class ShortestRouteStrategy implements RouteStrategy {

    @Override
    public Route calculateRoute(Location start, Location destination) {
        double distance = calculateDistance(start, destination);
        int estimatedTime = 55;
        double fuelCost = 5.80;

        String description = "Via City Center (shortest distance route)";

        return new Route(start, destination, distance, estimatedTime, fuelCost, description);
    }

    @Override
    public String getStrategyName() {
        return "Shortest Route (via city center)";
    }

    private double calculateDistance(Location start, Location destination) {
        double latDiff = destination.getLatitude() - start.getLatitude();
        double lonDiff = destination.getLongitude() - start.getLongitude();
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff) * 111;
    }
}
