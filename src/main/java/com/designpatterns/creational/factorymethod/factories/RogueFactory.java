package com.designpatterns.creational.factorymethod.factories;

import com.designpatterns.creational.factorymethod.characters.GameCharacter;
import com.designpatterns.creational.factorymethod.characters.Rogue;

public class RogueFactory extends CharacterFactory {
    
    @Override
    public GameCharacter createCharacter() {
        return new Rogue();
    }
} 