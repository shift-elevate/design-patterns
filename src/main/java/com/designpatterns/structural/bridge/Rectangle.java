package com.designpatterns.structural.bridge;

public class Rectangle extends Shape {
    private double x, y, width, height;
    
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
    
    public void resize(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
} 