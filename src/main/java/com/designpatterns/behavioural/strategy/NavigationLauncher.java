package com.designpatterns.behavioural.strategy;

public class NavigationLauncher {

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("STRATEGY PATTERN - GPS NAVIGATION SYSTEM");
        System.out.println("=".repeat(60));

        Location home = new Location("Home", 37.7749, -122.4194);
        Location office = new Location("Downtown Office", 37.8044, -122.2712);

        NavigationSystem navigation = new NavigationSystem();
        navigation.setCurrentLocation(home);

        System.out.println("\n1. Displaying All Available Route Options:");
        System.out.println("-".repeat(60));
        navigation.displayRouteOptions(office);

        System.out.println("=".repeat(60));

        System.out.println("\n2. Using Fastest Route Strategy (Default):");
        System.out.println("-".repeat(60));
        Route fastestRoute = navigation.planRoute(office);
        System.out.println(fastestRoute);

        System.out.println("\n3. Switching to Shortest Route Strategy:");
        System.out.println("-".repeat(60));
        navigation.setRouteStrategy(new ShortestRouteStrategy());
        Route shortestRoute = navigation.planRoute(office);
        System.out.println(shortestRoute);

        System.out.println("\n4. Switching to Eco-Friendly Route Strategy:");
        System.out.println("-".repeat(60));
        navigation.setRouteStrategy(new EcoFriendlyRouteStrategy());
        Route ecoRoute = navigation.planRoute(office);
        System.out.println(ecoRoute);

        System.out.println("\n" + "=".repeat(60));
        System.out.println("STRATEGY PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }
}
