package com.designpatterns.creational.abstractfactory;

public class MedievalFactory implements WorldFactory {
    @Override
    public GameCharacter createCharacter() {
        return new MedievalWarrior();
    }
    
    @Override
    public Weapon createWeapon() {
        return new MedievalSword();
    }
    
    @Override
    public Armor createArmor() {
        return new MedievalArmor();
    }
} 