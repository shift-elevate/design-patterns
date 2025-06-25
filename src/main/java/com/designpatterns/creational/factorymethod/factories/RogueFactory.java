package com.designpatterns.creational.factorymethod.factories;

import com.designpatterns.creational.factorymethod.characters.GameCharacter;
import com.designpatterns.creational.factorymethod.characters.Rogue;

/**
 * RogueFactory - Concrete factory for creating Rogue characters
 * Implements the factory method to return Rogue instances
 */
public class RogueFactory extends CharacterFactory {
    
    @Override
    public GameCharacter createCharacter() {
        return new Rogue();
    }
} 