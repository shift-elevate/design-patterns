package com.designpatterns.creational.abstractfactory;

public class LaserGun implements Weapon {
    @Override
    public void use() {
        System.out.println("Firing the laser gun!");
    }
} 