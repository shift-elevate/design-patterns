package com.designpatterns.structural.bridge;

public abstract class Shape {
    protected Renderer renderer;
    
    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    
    public abstract void draw();
    
    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
} 