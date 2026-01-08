package com.designpatterns.creational.factorymethod;


public class RogueFactory extends CharacterFactory {
    
    @Override
    public GameCharacter createCharacter() {
        return new Rogue();
    }
} 