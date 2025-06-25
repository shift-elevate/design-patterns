package com.designpatterns;

import com.designpatterns.creational.factorymethod.GameLauncher;

/**
 * Main entry point for the Design Patterns Educational Project
 * Simple demonstration of the Factory Method pattern
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Design Patterns in Java - Educational Project");
        System.out.println("=".repeat(50));
        System.out.println("Factory Method Pattern Demonstration");
        System.out.println("=".repeat(50));
        
        // Run the Factory Method pattern demo
        GameLauncher.main(args);
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("To see more detailed demonstrations, run the tests:");
        System.out.println("mvn test");
        System.out.println("=".repeat(50));
    }
} 