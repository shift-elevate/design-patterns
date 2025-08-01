package com.designpatterns.creational.abstractfactory;

public class MedievalArmor implements Armor {
    @Override
    public void equip() {
        System.out.println("Equipping medieval plate armor!");
    }
} 