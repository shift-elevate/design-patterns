package com.designpatterns.behavioural.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class StrategyPatternTest {

    private NavigationSystem navigation;
    private Location home;
    private Location office;

    @BeforeEach
    void setUp() {
        navigation = new NavigationSystem();
        home = new Location("Home", 37.7749, -122.4194);
        office = new Location("Downtown Office", 37.8044, -122.2712);
        navigation.setCurrentLocation(home);
    }

    @Test
    @DisplayName("Location - basic functionality")
    void testLocationBasicFunctionality() {
        assertEquals("Home", home.getName());
        assertEquals(37.7749, home.getLatitude(), 0.0001);
        assertEquals(-122.4194, home.getLongitude(), 0.0001);
        assertEquals("Home", home.toString());
    }

    @Test
    @DisplayName("Route - basic functionality")
    void testRouteBasicFunctionality() {
        Route route = new Route(home, office, 20.0, 30, 5.50, "Test route");

        assertEquals(home, route.getStart());
        assertEquals(office, route.getDestination());
        assertEquals(20.0, route.getDistance(), 0.01);
        assertEquals(30, route.getEstimatedTime());
        assertEquals(5.50, route.getFuelCost(), 0.01);
        assertEquals("Test route", route.getDescription());
        assertNotNull(route.toString());
    }

    @Test
    @DisplayName("FastestRouteStrategy - basic functionality")
    void testFastestRouteStrategy() {
        RouteStrategy strategy = new FastestRouteStrategy();

        assertEquals("Fastest Route (via highways)", strategy.getStrategyName());

        Route route = strategy.calculateRoute(home, office);
        assertNotNull(route);
        assertEquals(home, route.getStart());
        assertEquals(office, route.getDestination());
        assertTrue(route.getDistance() > 0);
        assertEquals(32, route.getEstimatedTime());
        assertEquals(6.50, route.getFuelCost(), 0.01);
    }

    @Test
    @DisplayName("ShortestRouteStrategy - basic functionality")
    void testShortestRouteStrategy() {
        RouteStrategy strategy = new ShortestRouteStrategy();

        assertEquals("Shortest Route (via city center)", strategy.getStrategyName());

        Route route = strategy.calculateRoute(home, office);
        assertNotNull(route);
        assertEquals(home, route.getStart());
        assertEquals(office, route.getDestination());
        assertTrue(route.getDistance() > 0);
        assertEquals(55, route.getEstimatedTime());
        assertEquals(5.80, route.getFuelCost(), 0.01);
    }

    @Test
    @DisplayName("EcoFriendlyRouteStrategy - basic functionality")
    void testEcoFriendlyRouteStrategy() {
        RouteStrategy strategy = new EcoFriendlyRouteStrategy();

        assertEquals("Eco-Friendly Route (fuel optimized)", strategy.getStrategyName());

        Route route = strategy.calculateRoute(home, office);
        assertNotNull(route);
        assertEquals(home, route.getStart());
        assertEquals(office, route.getDestination());
        assertTrue(route.getDistance() > 0);
        assertEquals(42, route.getEstimatedTime());
        assertEquals(4.90, route.getFuelCost(), 0.01);
    }

    @Test
    @DisplayName("NavigationSystem - default strategy")
    void testNavigationSystemDefaultStrategy() {
        Route route = navigation.planRoute(office);
        assertNotNull(route);
        assertEquals(32, route.getEstimatedTime());
    }

    @Test
    @DisplayName("NavigationSystem - strategy switching")
    void testNavigationSystemStrategySwitching() {
        Route fastestRoute = navigation.planRoute(office);
        assertEquals(32, fastestRoute.getEstimatedTime());

        navigation.setRouteStrategy(new ShortestRouteStrategy());
        Route shortestRoute = navigation.planRoute(office);
        assertEquals(55, shortestRoute.getEstimatedTime());

        navigation.setRouteStrategy(new EcoFriendlyRouteStrategy());
        Route ecoRoute = navigation.planRoute(office);
        assertEquals(42, ecoRoute.getEstimatedTime());
    }

    @Test
    @DisplayName("NavigationSystem - different strategies produce different results")
    void testDifferentStrategiesProduceDifferentResults() {
        FastestRouteStrategy fastest = new FastestRouteStrategy();
        ShortestRouteStrategy shortest = new ShortestRouteStrategy();
        EcoFriendlyRouteStrategy eco = new EcoFriendlyRouteStrategy();

        Route fastestRoute = fastest.calculateRoute(home, office);
        Route shortestRoute = shortest.calculateRoute(home, office);
        Route ecoRoute = eco.calculateRoute(home, office);

        assertNotEquals(fastestRoute.getDistance(), shortestRoute.getDistance());
        assertNotEquals(fastestRoute.getEstimatedTime(), shortestRoute.getEstimatedTime());
        assertNotEquals(shortestRoute.getFuelCost(), ecoRoute.getFuelCost());
    }

    @Test
    @DisplayName("NavigationSystem - location not set throws exception")
    void testNavigationSystemLocationNotSet() {
        NavigationSystem newNav = new NavigationSystem();

        assertThrows(IllegalStateException.class, () -> {
            newNav.planRoute(office);
        });
    }

    @Test
    @DisplayName("Strategy Pattern Integration")
    void testStrategyPatternIntegration() {
        Location sanFrancisco = new Location("San Francisco", 37.7749, -122.4194);
        Location losAngeles = new Location("Los Angeles", 34.0522, -118.2437);

        NavigationSystem nav = new NavigationSystem();
        nav.setCurrentLocation(sanFrancisco);

        Route fastest = nav.planRoute(losAngeles);
        assertNotNull(fastest);

        nav.setRouteStrategy(new ShortestRouteStrategy());
        Route shortest = nav.planRoute(losAngeles);
        assertNotNull(shortest);

        nav.setRouteStrategy(new EcoFriendlyRouteStrategy());
        Route eco = nav.planRoute(losAngeles);
        assertNotNull(eco);

        assertTrue(fastest.getDistance() > shortest.getDistance());
        assertTrue(eco.getFuelCost() < fastest.getFuelCost());
    }

    @Test
    @DisplayName("Demo: Strategy Pattern in Action")
    void testStrategyPatternDemo() {
        NavigationLauncher.main(new String[]{});
        assertTrue(true, "Strategy Pattern demonstration completed successfully");
    }
}
