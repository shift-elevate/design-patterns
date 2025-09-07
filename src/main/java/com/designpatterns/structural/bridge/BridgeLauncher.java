package com.designpatterns.structural.bridge;

public class BridgeLauncher {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("🌉 BRIDGE PATTERN DEMONSTRATION");
        System.out.println("=".repeat(60));
        
        System.out.println("\n🎨 INITIAL RENDERING");
        System.out.println("-".repeat(40));
        
        Renderer opengl = new OpenGLRenderer();
        Renderer directx = new DirectXRenderer();

        Shape circle = new Circle(opengl, 10, 20, 5);
        Shape rectangle = new Rectangle(directx, 0, 0, 15, 10);

        System.out.println("Circle with OpenGL renderer:");
        circle.draw();
        System.out.println("Rectangle with DirectX renderer:");
        rectangle.draw();

        System.out.println("\n🔄 SWITCHING RENDERERS");
        System.out.println("-".repeat(40));
        
        circle.setRenderer(directx);
        rectangle.setRenderer(opengl);

        System.out.println("Circle switched to DirectX renderer:");
        circle.draw();
        System.out.println("Rectangle switched to OpenGL renderer:");
        rectangle.draw();
        
        System.out.println("\n⚡ RUNTIME FLEXIBILITY DEMO");
        System.out.println("-".repeat(40));
        demonstrateRuntimeFlexibility();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ BRIDGE PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
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
