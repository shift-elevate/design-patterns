package com.designpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Prototype Pattern Demonstration ===\n");
        
        Shape circlePrototype = new Circle(10, "red");
        Shape rectanglePrototype = new Rectangle(20, 10, "blue");
        
        System.out.println("1. Basic Prototype Cloning:");
        System.out.println("Original circle prototype:");
        circlePrototype.draw();
        
        Shape circle1 = circlePrototype.clone();
        Shape circle2 = circlePrototype.clone();
        Shape rectangle1 = rectanglePrototype.clone();
        
        System.out.println("\nCloned shapes:");
        circle1.draw();
        circle2.draw();
        rectangle1.draw();
        
        System.out.println("\n2. Prototype Registry Demonstration:");
        PrototypeRegistry registry = new PrototypeRegistry();
        
        registry.registerPrototype("red-circle", new Circle(10, "red"));
        registry.registerPrototype("blue-rectangle", new Rectangle(20, 10, "blue"));
        registry.registerPrototype("green-circle", new Circle(15, "green"));
        registry.registerPrototype("yellow-rectangle", new Rectangle(30, 20, "yellow"));
        
        System.out.println("Registered " + registry.size() + " prototypes in registry");
        
        Shape newCircle = registry.getPrototype("red-circle");
        Shape newRectangle = registry.getPrototype("blue-rectangle");
        Shape greenCircle = registry.getPrototype("green-circle");
        Shape yellowRectangle = registry.getPrototype("yellow-rectangle");
        
        System.out.println("\nShapes cloned from registry:");
        newCircle.draw();
        newRectangle.draw();
        greenCircle.draw();
        yellowRectangle.draw();
        
        System.out.println("\n3. Performance Comparison:");
        demonstratePerformanceComparison();
        
        System.out.println("\n4. Deep vs Shallow Cloning:");
        demonstrateDeepCloning();
    }
    
    private static void demonstratePerformanceComparison() {
        System.out.println("Creating 1000 shapes using traditional approach vs prototype cloning...");
        
        long startTime = System.currentTimeMillis();
        List<Shape> traditionalShapes = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            traditionalShapes.add(new Circle(10, "red"));
        }
        long traditionalTime = System.currentTimeMillis() - startTime;
        
        Shape circlePrototype = new Circle(10, "red");
        startTime = System.currentTimeMillis();
        List<Shape> prototypeShapes = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            prototypeShapes.add(circlePrototype.clone());
        }
        long prototypeTime = System.currentTimeMillis() - startTime;
        
        System.out.println("Traditional approach: " + traditionalTime + "ms");
        System.out.println("Prototype approach: " + prototypeTime + "ms");
        System.out.println("Performance improvement: " + 
            String.format("%.1f", (double) traditionalTime / prototypeTime) + "x faster");
    }
    
    private static void demonstrateDeepCloning() {
        System.out.println("Demonstrating independent clones...");
        
        Shape originalCircle = new Circle(10, "red");
        Shape clonedCircle = originalCircle.clone();
        
        if (originalCircle instanceof Circle) {
            ((Circle) originalCircle).setRadius(20);
            ((Circle) originalCircle).setColor("blue");
        }
        
        System.out.println("Original circle (modified):");
        originalCircle.draw();
        
        System.out.println("Cloned circle (unchanged):");
        clonedCircle.draw();
        
        System.out.println("✓ Clones are independent - modifying one doesn't affect the other");
    }
} 