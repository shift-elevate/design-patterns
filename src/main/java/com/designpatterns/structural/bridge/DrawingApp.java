package com.designpatterns.structural.bridge;

public class DrawingApp {
    
    public static void main(String[] args) {
        System.out.println("🎨 Bridge Pattern: Drawing Application Demo");
        System.out.println("===========================================\n");
        
        Renderer opengl = new OpenGLRenderer();
        Renderer directx = new DirectXRenderer();

        Shape circle = new Circle(opengl, 10, 20, 5);
        Shape rectangle = new Rectangle(directx, 0, 0, 15, 10);

        System.out.println("=== Initial Rendering ===");
        circle.draw();
        rectangle.draw();

        System.out.println("\n=== Switching Renderers ===");
        circle.setRenderer(directx);
        rectangle.setRenderer(opengl);

        circle.draw();
        rectangle.draw();
        
        System.out.println("\n=== Runtime Flexibility Demo ===");
        demonstrateRuntimeFlexibility();
    }
    
    private static void demonstrateRuntimeFlexibility() {
        Renderer opengl = new OpenGLRenderer();
        Renderer directx = new DirectXRenderer();
        
        Circle circle = new Circle(opengl, 5, 5, 3);
        System.out.println("Circle created with OpenGL renderer:");
        circle.draw();
        
        circle.setRenderer(directx);
        System.out.println("Circle switched to DirectX renderer:");
        circle.draw();
        
        circle.setRenderer(opengl);
        System.out.println("Circle switched back to OpenGL renderer:");
        circle.draw();
        
        circle.setRadius(7);
        System.out.println("Circle radius increased to 7:");
        circle.draw();
    }
} 