package com.designpatterns.creational.abstractfactory;

public class SciFiFactory implements WorldFactory {
    @Override
    public GameCharacter createCharacter() {
        return new SciFiSoldier();
    }
    
    @Override
    public Weapon createWeapon() {
        return new LaserGun();
    }
    
    @Override
    public Armor createArmor() {
        return new SciFiArmor();
    }
} 