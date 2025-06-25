package com.designpatterns.creational.factorymethod.factories;

import com.designpatterns.creational.factorymethod.characters.GameCharacter;
import com.designpatterns.creational.factorymethod.characters.Archer;

/**
 * ArcherFactory - Concrete factory for creating Archer characters
 * Implements the factory method to return Archer instances
 */
public class ArcherFactory extends CharacterFactory {
    
    @Override
    public GameCharacter createCharacter() {
        return new Archer();
    }
} 