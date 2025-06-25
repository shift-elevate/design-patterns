package com.designpatterns.creational.factorymethod.factories;

import com.designpatterns.creational.factorymethod.characters.GameCharacter;

/**
 * CharacterFactory - Abstract class that declares the character creation method
 * This is the core of the Factory Method Pattern
 */
public abstract class CharacterFactory {
    
    /**
     * Template method that uses the factory method
     * This method defines the algorithm for character creation and display
     */
    public final void createAndDisplayCharacter(String playerName) {
        GameCharacter character = createCharacter();
        
        System.out.println("=== Character Created for " + playerName + " ===");
        System.out.println("Health: " + character.getHealth());
        
        // Demonstrate character abilities
        character.attack();
        character.defend();
    }
    
    /**
     * Factory method - subclasses must implement this method
     * This is where the actual character creation happens
     */
    public abstract GameCharacter createCharacter();
} 