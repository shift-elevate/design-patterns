package com.designpatterns.behavioural.mediator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class MediatorPatternTest {

    private AirTrafficControlTower tower;
    private Aircraft flight1;
    private Aircraft flight2;
    private GroundControl groundControl;

    @BeforeEach
    void setUp() {
        tower = new AirTrafficControlTower();
        groundControl = new GroundControl("Ground Control");
        tower.notifyGroundControl(groundControl);
        flight1 = new Aircraft("Flight 101", tower);
        flight2 = new Aircraft("Flight 202", tower);
    }

    @Test
    @DisplayName("AirTrafficControlTower - basic functionality")
    void testAirTrafficControlTowerBasicFunctionality() {
        assertEquals(2, tower.getAircraftCount());
        assertTrue(tower.isRunwayAvailable());
    }

    @Test
    @DisplayName("Aircraft - basic functionality")
    void testAircraftBasicFunctionality() {
        Aircraft testFlight = new Aircraft("Test Flight", tower);
        assertEquals("Test Flight", testFlight.getName());
        assertEquals(3, tower.getAircraftCount());
    }

    @Test
    @DisplayName("GroundControl - basic functionality")
    void testGroundControlBasicFunctionality() {
        GroundControl gc = new GroundControl("Test Ground Control");
        assertEquals("Test Ground Control", gc.getName());
    }

    @Test
    @DisplayName("Aircraft Registration")
    void testAircraftRegistration() {
        assertEquals(2, tower.getAircraftCount());

        Aircraft flight3 = new Aircraft("Flight 303", tower);
        assertEquals(3, tower.getAircraftCount());

        Aircraft flight4 = new Aircraft("Flight 404", tower);
        assertEquals(4, tower.getAircraftCount());
    }

    @Test
    @DisplayName("Runway Availability - Landing")
    void testRunwayAvailabilityLanding() {
        assertTrue(tower.isRunwayAvailable());

        flight1.requestLanding();
        assertFalse(tower.isRunwayAvailable());

        flight1.reportPosition("Gate A");
        assertTrue(tower.isRunwayAvailable());
    }

    @Test
    @DisplayName("Runway Availability - Takeoff")
    void testRunwayAvailabilityTakeoff() {
        assertTrue(tower.isRunwayAvailable());

        flight1.requestTakeoff();
        assertFalse(tower.isRunwayAvailable());
    }

    @Test
    @DisplayName("Multiple Aircraft Coordination")
    void testMultipleAircraftCoordination() {
        flight1.requestLanding();
        assertFalse(tower.isRunwayAvailable());

        flight2.requestLanding();
        assertFalse(tower.isRunwayAvailable());

        flight1.reportPosition("Gate B");
        assertTrue(tower.isRunwayAvailable());

        flight2.requestLanding();
        assertFalse(tower.isRunwayAvailable());
    }

    @Test
    @DisplayName("Ground Control Notification")
    void testGroundControlNotification() {
        assertDoesNotThrow(() -> flight1.requestLanding());
        assertDoesNotThrow(() -> flight1.reportPosition("Gate C"));
    }

    @Test
    @DisplayName("Mediator Pattern Integration")
    void testMediatorPatternIntegration() {
        AirTrafficControlTower tower1 = new AirTrafficControlTower();
        AirTrafficControlTower tower2 = new AirTrafficControlTower();

        GroundControl gc1 = new GroundControl("GC Tower 1");
        GroundControl gc2 = new GroundControl("GC Tower 2");

        tower1.notifyGroundControl(gc1);
        tower2.notifyGroundControl(gc2);

        Aircraft airportA1 = new Aircraft("AA Flight 1", tower1);
        Aircraft airportA2 = new Aircraft("AA Flight 2", tower1);
        Aircraft airportB1 = new Aircraft("BB Flight 1", tower2);

        assertEquals(2, tower1.getAircraftCount());
        assertEquals(1, tower2.getAircraftCount());

        airportA1.requestLanding();
        assertFalse(tower1.isRunwayAvailable());
        assertTrue(tower2.isRunwayAvailable());

        airportB1.requestLanding();
        assertFalse(tower2.isRunwayAvailable());
    }

    @Test
    @DisplayName("Edge Cases")
    void testEdgeCases() {
        flight1.requestLanding();
        flight1.requestLanding();
        assertFalse(tower.isRunwayAvailable());

        flight1.reportPosition("Parking");
        assertTrue(tower.isRunwayAvailable());

        assertDoesNotThrow(() -> flight2.requestTakeoff());
    }

    @Test
    @DisplayName("Demo: Mediator Pattern in Action")
    void testMediatorPatternDemo() {
        MediatorLauncher.main(new String[]{});
        assertTrue(true, "Mediator Pattern demonstration completed successfully");
    }
}
