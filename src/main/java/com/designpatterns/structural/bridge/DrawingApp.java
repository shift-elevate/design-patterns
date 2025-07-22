package com.designpatterns.structural.bridge;

/**
 * Client application demonstrating the Bridge pattern.
 * Shows how to mix and match different shapes with different renderers.
 */
public class DrawingApp {
    
    public static void main(String[] args) {
        System.out.println("🎨 Bridge Pattern: Drawing Application Demo");
        System.out.println("===========================================\n");
        
        // Create different renderers
        Renderer opengl = new OpenGLRenderer();
        Renderer directx = new DirectXRenderer();

        // Create shapes with different renderers
        Shape circle = new Circle(opengl, 10, 20, 5);
        Shape rectangle = new Rectangle(directx, 0, 0, 15, 10);

        // Draw with initial renderers
        System.out.println("=== Initial Rendering ===");
        circle.draw();      // OpenGL: Drawing circle at (10, 20) with radius 5
        rectangle.draw();   // DirectX: Drawing rectangle at (0, 0) with width 15 and height 10

        // Switch renderers dynamically
        System.out.println("\n=== Switching Renderers ===");
        circle.setRenderer(directx);
        rectangle.setRenderer(opengl);

        circle.draw();      // DirectX: Drawing circle at (10, 20) with radius 5
        rectangle.draw();   // OpenGL: Drawing rectangle at (0, 0) with width 15 and height 10
        
        // Demonstrate runtime flexibility
        System.out.println("\n=== Runtime Flexibility Demo ===");
        demonstrateRuntimeFlexibility();
    }
    
    /**
     * Demonstrates the runtime flexibility of the Bridge pattern.
     * Shows how shapes can switch renderers dynamically.
     */
    private static void demonstrateRuntimeFlexibility() {
        Renderer opengl = new OpenGLRenderer();
        Renderer directx = new DirectXRenderer();
        
        // Create a circle with OpenGL
        Circle circle = new Circle(opengl, 5, 5, 3);
        System.out.println("Circle created with OpenGL renderer:");
        circle.draw();
        
        // Switch to DirectX at runtime
        circle.setRenderer(directx);
        System.out.println("Circle switched to DirectX renderer:");
        circle.draw();
        
        // Switch back to OpenGL
        circle.setRenderer(opengl);
        System.out.println("Circle switched back to OpenGL renderer:");
        circle.draw();
        
        // Modify the circle and see the changes
        circle.setRadius(7);
        System.out.println("Circle radius increased to 7:");
        circle.draw();
    }
} 