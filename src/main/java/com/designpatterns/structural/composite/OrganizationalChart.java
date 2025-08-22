package com.designpatterns.structural.composite;

public class OrganizationalChart {
    
    public static void main(String[] args) {
        Manager ceo = new Manager("Sarah Johnson", "CEO");
        Manager cto = new Manager("Mike Chen", "CTO");
        Manager engineeringManager = new Manager("Lisa Wang", "Engineering Manager");
        
        IndividualContributor dev1 = new IndividualContributor("Alex Smith", "Senior Developer");
        IndividualContributor dev2 = new IndividualContributor("Emma Davis", "Developer");
        IndividualContributor qa = new IndividualContributor("Tom Wilson", "QA Engineer");
        
        engineeringManager.addSubordinate(dev1);
        engineeringManager.addSubordinate(dev2);
        engineeringManager.addSubordinate(qa);
        cto.addSubordinate(engineeringManager);
        ceo.addSubordinate(cto);
        
        System.out.println("=== Organizational Chart ===");
        ceo.display(0);
        
        System.out.println("\n=== Team Size Analysis ===");
        System.out.println("CTO team size: " + cto.getTeamSize() + " people");
        System.out.println("Engineering team size: " + engineeringManager.getTeamSize() + " people");
        System.out.println("Total company size: " + ceo.getTeamSize() + " people");
    }
}
