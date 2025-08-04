package com.designpatterns.creational.abstractfactory;

public class SciFiSoldier implements GameCharacter {
    private int health = 100;
    
    @Override
    public void attack() {
        System.out.println("Sci-Fi Soldier fires laser gun! Dealing 40 damage.");
    }
    
    @Override
    public void defend() {
        System.out.println("Sci-Fi Soldier activates energy shield, blocking 60% damage");
    }
    
    @Override
    public int getHealth() { 
        return health; 
    }
} 