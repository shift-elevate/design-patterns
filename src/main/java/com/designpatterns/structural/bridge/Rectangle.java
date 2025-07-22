package com.designpatterns.structural.bridge;

/**
 * Refined abstraction for Rectangle shape.
 * Extends the Shape abstraction to add specialized behavior for rectangles.
 */
public class Rectangle extends Shape {
    private double x, y, width, height;
    
    /**
     * Constructor for Rectangle with position and dimensions.
     * 
     * @param renderer The renderer implementation to use
     * @param x X-coordinate of the rectangle top-left corner
     * @param y Y-coordinate of the rectangle top-left corner
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     */
    public Rectangle(Renderer renderer, double x, double y, double width, double height) {
        super(renderer);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        renderer.renderRectangle(x, y, width, height);
    }
    
    /**
     * Resizes the rectangle to new dimensions.
     * 
     * @param width The new width
     * @param height The new height
     */
    public void resize(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    /**
     * Gets the current width of the rectangle.
     * 
     * @return The width value
     */
    public double getWidth() {
        return width;
    }
    
    /**
     * Gets the current height of the rectangle.
     * 
     * @return The height value
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * Gets the X-coordinate of the rectangle top-left corner.
     * 
     * @return The X-coordinate
     */
    public double getX() {
        return x;
    }
    
    /**
     * Gets the Y-coordinate of the rectangle top-left corner.
     * 
     * @return The Y-coordinate
     */
    public double getY() {
        return y;
    }
} 