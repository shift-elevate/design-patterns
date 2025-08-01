package com.designpatterns.creational.abstractfactory;

public class MedievalSword implements Weapon {
    @Override
    public void use() {
        System.out.println("Swinging the medieval broadsword!");
    }
} 