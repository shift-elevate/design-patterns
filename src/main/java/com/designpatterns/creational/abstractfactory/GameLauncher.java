package com.designpatterns.creational.abstractfactory;

public class GameLauncher {
    public static void main(String[] args) {
        WorldFactory medievalFactory = new MedievalFactory();
        GameCharacter medievalHero = medievalFactory.createCharacter();
        Weapon medievalWeapon = medievalFactory.createWeapon();
        Armor medievalArmor = medievalFactory.createArmor();

        System.out.println("=== Medieval World Equipment Set ===");
        medievalHero.attack();
        medievalWeapon.use();
        medievalArmor.equip();
        medievalHero.defend();

        System.out.println("\n=== Sci-Fi World Equipment Set ===");
        WorldFactory sciFiFactory = new SciFiFactory();
        GameCharacter sciFiHero = sciFiFactory.createCharacter();
        Weapon sciFiWeapon = sciFiFactory.createWeapon();
        Armor sciFiArmor = sciFiFactory.createArmor();

        sciFiHero.attack();
        sciFiWeapon.use();
        sciFiArmor.equip();
        sciFiHero.defend();
    }
} 