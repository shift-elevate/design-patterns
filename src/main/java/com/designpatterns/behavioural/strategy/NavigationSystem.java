package com.designpatterns.behavioural.strategy;

public class NavigationSystem {
    private RouteStrategy routeStrategy;
    private Location currentLocation;

    public NavigationSystem() {
        this.routeStrategy = new FastestRouteStrategy();
    }

    public void setRouteStrategy(RouteStrategy strategy) {
        this.routeStrategy = strategy;
        System.out.println("Route strategy changed to: " + strategy.getStrategyName());
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public Route planRoute(Location destination) {
        if (currentLocation == null) {
            throw new IllegalStateException("Current location not set");
        }

        System.out.println("\n=== Planning Route ===");
        System.out.println("Strategy: " + routeStrategy.getStrategyName());

        Route route = routeStrategy.calculateRoute(currentLocation, destination);

        return route;
    }

    public void displayRouteOptions(Location destination) {
        System.out.println("\n=== Available Route Options ===");
        System.out.println("From: " + currentLocation.getName());
        System.out.println("To: " + destination.getName());
        System.out.println();

        RouteStrategy[] strategies = {
            new FastestRouteStrategy(),
            new ShortestRouteStrategy(),
            new EcoFriendlyRouteStrategy()
        };

        for (RouteStrategy strategy : strategies) {
            Route route = strategy.calculateRoute(currentLocation, destination);
            System.out.println(route);
            System.out.println();
        }
    }
}
