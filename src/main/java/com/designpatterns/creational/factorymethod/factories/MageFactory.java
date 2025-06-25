package com.designpatterns.creational.factorymethod.factories;

import com.designpatterns.creational.factorymethod.characters.GameCharacter;
import com.designpatterns.creational.factorymethod.characters.Mage;

/**
 * MageFactory - Concrete factory for creating Mage characters
 * Implements the factory method to return Mage instances
 */
public class MageFactory extends CharacterFactory {
    
    @Override
    public GameCharacter createCharacter() {
        return new Mage();
    }
} 