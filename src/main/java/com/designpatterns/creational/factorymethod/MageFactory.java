package com.designpatterns.creational.factorymethod;


public class MageFactory extends CharacterFactory {
    
    @Override
    public GameCharacter createCharacter() {
        return new Mage();
    }
} 