package com.designpatterns;

import com.designpatterns.creational.factorymethod.GameLauncher;
import com.designpatterns.structural.bridge.DrawingApp;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Design Patterns in Java - Educational Project");
        System.out.println("=".repeat(70));
        
        System.out.println("CREATIONAL PATTERNS:");
        System.out.println("=".repeat(70));
        
        System.out.println("\nFACTORY METHOD PATTERN");
        System.out.println("-".repeat(40));
        GameLauncher.main(args);
        
        System.out.println("\n\nABSTRACT FACTORY PATTERN");
        System.out.println("-".repeat(40));
        com.designpatterns.creational.abstractfactory.GameLauncher.main(args);
        
        System.out.println("\n\nBUILDER PATTERN");
        System.out.println("-".repeat(40));
        com.designpatterns.creational.builder.ECommerceLauncher.main(args);
        
        System.out.println("\n\nPROTOTYPE PATTERN");
        System.out.println("-".repeat(40));
        com.designpatterns.creational.prototype.PrototypeDemo.main(args);
        
        System.out.println("\n" + "=".repeat(70));
        
        System.out.println("BEHAVIOURAL PATTERNS:");
        System.out.println("=".repeat(70));
        
        System.out.println("\nOBSERVER PATTERN");
        System.out.println("-".repeat(40));
        com.designpatterns.behavioural.observer.ObserverLauncher.main(args);
        
        System.out.println("\n\nCOMMAND PATTERN");
        System.out.println("-".repeat(40));
        com.designpatterns.behavioural.command.SmartHomeLauncher.main(args);
        
        System.out.println("\n" + "=".repeat(70));
        
        System.out.println("STRUCTURAL PATTERNS:");
        System.out.println("=".repeat(70));
        
        System.out.println("\nADAPTER PATTERN");
        System.out.println("-".repeat(40));
        com.designpatterns.structural.adapter.ECommerceLauncher.main(args);

        System.out.println("\n\nCOMPOSITE PATTERN");
        System.out.println("-".repeat(40));
        com.designpatterns.structural.composite.OrganizationalChart.main(args);
        
        System.out.println("\n\nBRIDGE PATTERN");
        System.out.println("-".repeat(40));
        DrawingApp.main(args);
        
        System.out.println("\n\nFACADE PATTERN");
        System.out.println("-".repeat(40));
        com.designpatterns.structural.facade.CodeEditorClient.main(args);
        
        System.out.println("\n\nFLYWEIGHT PATTERN");
        System.out.println("-".repeat(40));
        com.designpatterns.structural.flyweight.FlyweightLauncher.main(args);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("For comprehensive testing and detailed demonstrations:");
        System.out.println("mvn test                    # Run all tests");
        System.out.println("mvn test -Dtest=FactoryMethodTest");
        System.out.println("mvn test -Dtest=AbstractFactoryTest");
        System.out.println("mvn test -Dtest=BuilderPatternTest");
        System.out.println("mvn test -Dtest=PrototypePatternTest");
        System.out.println("mvn test -Dtest=ObserverPatternTest");
        System.out.println("mvn test -Dtest=CommandPatternTest");
        System.out.println("mvn test -Dtest=AdapterPatternTest");
        System.out.println("mvn test -Dtest=CompositePatternTest");
        System.out.println("mvn test -Dtest=BridgePatternTest");
        System.out.println("mvn test -Dtest=FacadePatternTest");
        System.out.println("mvn test -Dtest=FlyweightPatternTest");
        System.out.println("=".repeat(70));
    }
} 