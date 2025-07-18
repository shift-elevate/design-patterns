package com.designpatterns.creational.factorymethod.characters;

public class Mage implements GameCharacter {
    private int health = 70;
    
    @Override
    public void attack() {
        System.out.println("Mage casts Fireball! Dealing 35 magic damage.");
    }
    
    @Override
    public void defend() {
        System.out.println("Mage creates magical barrier, absorbing 30 damage");
    }
    
    @Override
    public int getHealth() { 
        return health; 
    }
} 