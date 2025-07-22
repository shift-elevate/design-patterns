package com.designpatterns.structural.bridge;

/**
 * Concrete implementor for OpenGL rendering.
 * Implements the Renderer interface for OpenGL graphics API.
 */
public class OpenGLRenderer implements Renderer {
    
    @Override
    public void renderCircle(double x, double y, double radius) {
        System.out.println("OpenGL: Drawing circle at (" + x + ", " + y + ") with radius " + radius);
    }
    
    @Override
    public void renderRectangle(double x, double y, double width, double height) {
        System.out.println("OpenGL: Drawing rectangle at (" + x + ", " + y + ") with width " + width + " and height " + height);
    }
} 