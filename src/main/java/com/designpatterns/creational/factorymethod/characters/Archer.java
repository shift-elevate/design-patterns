package com.designpatterns.creational.factorymethod.characters;

public class Archer implements GameCharacter {
    private int health = 90;
    
    @Override
    public void attack() {
        System.out.println("Archer shoots precise arrow! Dealing 20 damage with 30% crit chance.");
    }
    
    @Override
    public void defend() {
        System.out.println("Archer dodges with agility, avoiding 70% of attacks");
    }
    
    @Override
    public int getHealth() { 
        return health; 
    }
} 