package com.designpatterns.creational.factorymethod.factories;

import com.designpatterns.creational.factorymethod.characters.GameCharacter;
import com.designpatterns.creational.factorymethod.characters.Archer;

public class ArcherFactory extends CharacterFactory {
    
    @Override
    public GameCharacter createCharacter() {
        return new Archer();
    }
} 