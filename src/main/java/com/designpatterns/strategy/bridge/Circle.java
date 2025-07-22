package com.designpatterns.strategy.bridge;

/**
 * Refined abstraction for Circle shape.
 * Extends the Shape abstraction to add specialized behavior for circles.
 */
public class Circle extends Shape {
    private double x, y, radius;
    
    /**
     * Constructor for Circle with position and radius.
     * 
     * @param renderer The renderer implementation to use
     * @param x X-coordinate of the circle center
     * @param y Y-coordinate of the circle center
     * @param radius Radius of the circle
     */
    public Circle(Renderer renderer, double x, double y, double radius) {
        super(renderer);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        renderer.renderCircle(x, y, radius);
    }
    
    /**
     * Updates the radius of the circle.
     * 
     * @param radius The new radius value
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    /**
     * Gets the current radius of the circle.
     * 
     * @return The radius value
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Gets the X-coordinate of the circle center.
     * 
     * @return The X-coordinate
     */
    public double getX() {
        return x;
    }
    
    /**
     * Gets the Y-coordinate of the circle center.
     * 
     * @return The Y-coordinate
     */
    public double getY() {
        return y;
    }
} 