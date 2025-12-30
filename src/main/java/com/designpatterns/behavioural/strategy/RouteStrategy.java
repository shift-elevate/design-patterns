package com.designpatterns.behavioural.strategy;

public interface RouteStrategy {
    Route calculateRoute(Location start, Location destination);
    String getStrategyName();
}
