package com.designpatterns.creational.abstractfactory;

public interface WorldFactory {
    GameCharacter createCharacter();
    Weapon createWeapon();
    Armor createArmor();
} 