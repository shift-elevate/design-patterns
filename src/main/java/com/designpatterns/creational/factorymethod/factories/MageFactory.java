package com.designpatterns.creational.factorymethod.factories;

import com.designpatterns.creational.factorymethod.characters.GameCharacter;
import com.designpatterns.creational.factorymethod.characters.Mage;

public class MageFactory extends CharacterFactory {
    
    @Override
    public GameCharacter createCharacter() {
        return new Mage();
    }
} 