package com.designpatterns.creational.factorymethod.characters;

/**
 * Rogue - Concrete implementation of GameCharacter
 * Stealth assassin with high damage and evasion abilities
 */
public class Rogue implements GameCharacter {
    private int health = 85;
    
    @Override
    public void attack() {
        System.out.println("Rogue strikes from shadows! Dealing 30 damage with poison effect.");
    }
    
    @Override
    public void defend() {
        System.out.println("Rogue vanishes into stealth, becoming untargetable for 3 seconds");
    }
    
    @Override
    public int getHealth() { 
        return health; 
    }
} 