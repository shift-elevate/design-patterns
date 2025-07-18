package com.designpatterns.creational.factorymethod.factories;

import com.designpatterns.creational.factorymethod.characters.GameCharacter;
import com.designpatterns.creational.factorymethod.characters.Warrior;

public class WarriorFactory extends CharacterFactory {
    
    @Override
    public GameCharacter createCharacter() {
        return new Warrior();
    }
} 