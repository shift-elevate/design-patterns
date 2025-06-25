package com.designpatterns.creational.factorymethod.characters;

/**
 * Warrior - Concrete implementation of GameCharacter
 * Tank class with high health and strong melee attacks
 */
public class Warrior implements GameCharacter {
    private int health = 120;
    
    @Override
    public void attack() {
        System.out.println("Warrior swings mighty sword! Dealing 25 damage.");
    }
    
    @Override
    public void defend() {
        System.out.println("Warrior raises shield, reducing incoming damage by 50%");
    }
    
    @Override
    public int getHealth() { 
        return health; 
    }
} 