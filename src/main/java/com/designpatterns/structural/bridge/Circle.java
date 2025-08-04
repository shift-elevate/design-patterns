package com.designpatterns.structural.bridge;

public class Circle extends Shape {
    private double x, y, radius;
    
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
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
} 