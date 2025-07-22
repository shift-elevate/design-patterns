package com.designpatterns.strategy.bridge;

/**
 * Abstraction class for the Bridge pattern.
 * Defines the high-level interface and maintains a reference to the implementor.
 */
public abstract class Shape {
    protected Renderer renderer;
    
    /**
     * Constructor that takes a renderer implementation.
     * 
     * @param renderer The renderer implementation to use
     */
    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    
    /**
     * Abstract method that must be implemented by concrete shapes.
     * Each shape defines how it should be drawn using its renderer.
     */
    public abstract void draw();
    
    /**
     * Allows changing the renderer at runtime.
     * 
     * @param renderer The new renderer to use
     */
    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
} 