package com.designpatterns;

import com.designpatterns.creational.factorymethod.GameLauncher;
import com.designpatterns.strategy.bridge.DrawingApp;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Design Patterns in Java - Educational Project");
        System.out.println("=".repeat(70));
        System.out.println("Demonstrating Creational Design Patterns");
        System.out.println("=".repeat(70));
        
        System.out.println("\n1. FACTORY METHOD PATTERN");
        System.out.println("-".repeat(40));
        GameLauncher.main(args);
        
        System.out.println("\n\n2. BUILDER PATTERN");
        System.out.println("-".repeat(40));
        com.designpatterns.creational.builder.ECommerceLauncher.main(args);
        
        // New section for structural patterns
        System.out.println("\n" + "=".repeat(70));
        System.out.println("Demonstrating Structural Design Patterns");
        System.out.println("=".repeat(70));
        
        System.out.println("\n3. ADAPTER PATTERN");
        System.out.println("-".repeat(40));
        com.designpatterns.strategy.adapter.ECommerceLauncher.main(args);
        
        System.out.println("\n\n4. BRIDGE PATTERN");
        System.out.println("-".repeat(40));
        DrawingApp.main(args);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("For comprehensive testing and detailed demonstrations:");
        System.out.println("mvn test                    # Run all tests");
        System.out.println("mvn test -Dtest=FactoryMethodTest");
        System.out.println("mvn test -Dtest=BuilderPatternTest");
        System.out.println("mvn test -Dtest=AdapterPatternTest");
        System.out.println("mvn test -Dtest=BridgePatternTest");
        System.out.println("=".repeat(70));
    }
} 