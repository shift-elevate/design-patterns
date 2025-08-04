package com.designpatterns.creational.abstractfactory;

public class MedievalWarrior implements GameCharacter {
    private int health = 120;
    
    @Override
    public void attack() {
        System.out.println("Medieval Warrior swings mighty sword! Dealing 25 damage.");
    }
    
    @Override
    public void defend() {
        System.out.println("Medieval Warrior raises shield, reducing incoming damage by 50%");
    }
    
    @Override
    public int getHealth() { 
        return health; 
    }
} 