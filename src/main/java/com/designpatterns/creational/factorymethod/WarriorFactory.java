package com.designpatterns.creational.factorymethod;


public class WarriorFactory extends CharacterFactory {
    
    @Override
    public GameCharacter createCharacter() {
        return new Warrior();
    }
} 