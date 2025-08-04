package com.designpatterns.structural.bridge;

public class DirectXRenderer implements Renderer {
    
    @Override
    public void renderCircle(double x, double y, double radius) {
        System.out.println("DirectX: Drawing circle at (" + x + ", " + y + ") with radius " + radius);
    }
    
    @Override
    public void renderRectangle(double x, double y, double width, double height) {
        System.out.println("DirectX: Drawing rectangle at (" + x + ", " + y + ") with width " + width + " and height " + height);
    }
} 