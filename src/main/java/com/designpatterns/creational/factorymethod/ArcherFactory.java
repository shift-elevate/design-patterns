package com.designpatterns.creational.factorymethod;


public class ArcherFactory extends CharacterFactory {
    
    @Override
    public GameCharacter createCharacter() {
        return new Archer();
    }
} 