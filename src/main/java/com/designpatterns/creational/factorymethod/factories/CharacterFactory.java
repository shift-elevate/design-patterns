package com.designpatterns.creational.factorymethod.factories;

import com.designpatterns.creational.factorymethod.characters.GameCharacter;

public abstract class CharacterFactory {
    
    public final void createAndDisplayCharacter(String playerName) {
        GameCharacter character = createCharacter();
        
        System.out.println("=== Character Created for " + playerName + " ===");
        System.out.println("Health: " + character.getHealth());
        
        character.attack();
        character.defend();
    }
    
    public abstract GameCharacter createCharacter();
} 