package com.designpatterns.structural.composite;

public class CompositeLauncher {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("🌳 COMPOSITE PATTERN DEMONSTRATION");
        System.out.println("=".repeat(60));
        
        System.out.println("\n🏢 ORGANIZATIONAL CHART SETUP");
        System.out.println("-".repeat(40));
        
        Manager ceo = new Manager("Sarah Johnson", "CEO");
        Manager cto = new Manager("Mike Chen", "CTO");
        Manager engineeringManager = new Manager("Lisa Wang", "Engineering Manager");
        
        IndividualContributor dev1 = new IndividualContributor("Alex Smith", "Senior Developer");
        IndividualContributor dev2 = new IndividualContributor("Emma Davis", "Developer");
        IndividualContributor qa = new IndividualContributor("Tom Wilson", "QA Engineer");
        
        System.out.println("Creating organizational hierarchy...");
        engineeringManager.addSubordinate(dev1);
        engineeringManager.addSubordinate(dev2);
        engineeringManager.addSubordinate(qa);
        cto.addSubordinate(engineeringManager);
        ceo.addSubordinate(cto);
        
        System.out.println("✅ Organizational structure created successfully!");
        
        System.out.println("\n📊 ORGANIZATIONAL CHART DISPLAY");
        System.out.println("-".repeat(40));
        ceo.display(0);
        
        System.out.println("\n📈 TEAM SIZE ANALYSIS");
        System.out.println("-".repeat(40));
        System.out.println("CTO team size: " + cto.getTeamSize() + " people");
        System.out.println("Engineering team size: " + engineeringManager.getTeamSize() + " people");
        System.out.println("Total company size: " + ceo.getTeamSize() + " people");
        
        System.out.println("\n🔍 COMPOSITE PATTERN BENEFITS");
        System.out.println("-".repeat(40));
        System.out.println("✓ Uniform treatment of individual and composite objects");
        System.out.println("✓ Recursive structure handling");
        System.out.println("✓ Easy addition of new employee types");
        System.out.println("✓ Simplified client code for tree operations");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ COMPOSITE PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }
}
