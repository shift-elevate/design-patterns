package com.designpatterns.structural.bridge;

public interface Renderer {
    void renderCircle(double x, double y, double radius);
    
    void renderRectangle(double x, double y, double width, double height);
} 