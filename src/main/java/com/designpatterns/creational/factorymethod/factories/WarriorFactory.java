package com.designpatterns.creational.factorymethod.factories;

import com.designpatterns.creational.factorymethod.characters.GameCharacter;
import com.designpatterns.creational.factorymethod.characters.Warrior;

/**
 * WarriorFactory - Concrete factory for creating Warrior characters
 * Implements the factory method to return Warrior instances
 */
public class WarriorFactory extends CharacterFactory {
    
    @Override
    public GameCharacter createCharacter() {
        return new Warrior();
    }
} 