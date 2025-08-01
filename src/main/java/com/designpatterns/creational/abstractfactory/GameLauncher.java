package com.designpatterns.creational.abstractfactory;

public class GameLauncher {
    public static void main(String[] args) {
        // Create complete Medieval equipment set
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
        // Create complete Sci-Fi equipment set
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