package com.designpatterns.strategy.bridge;

/**
 * Implementor interface for the Bridge pattern.
 * Defines the contract for different rendering implementations.
 */
public interface Renderer {
    /**
     * Renders a circle at the specified coordinates with given radius.
     * 
     * @param x X-coordinate of the circle center
     * @param y Y-coordinate of the circle center
     * @param radius Radius of the circle
     */
    void renderCircle(double x, double y, double radius);
    
    /**
     * Renders a rectangle at the specified coordinates with given dimensions.
     * 
     * @param x X-coordinate of the rectangle top-left corner
     * @param y Y-coordinate of the rectangle top-left corner
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     */
    void renderRectangle(double x, double y, double width, double height);
} 