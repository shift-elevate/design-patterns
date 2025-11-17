package com.designpatterns.creational.factorymethod;

import com.designpatterns.creational.factorymethod.factories.CharacterFactory;
import com.designpatterns.creational.factorymethod.factories.WarriorFactory;
import com.designpatterns.creational.factorymethod.factories.MageFactory;
import com.designpatterns.creational.factorymethod.factories.ArcherFactory;

public class GameLauncher {

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("FACTORY METHOD PATTERN - GAME CHARACTER CREATION");
        System.out.println("=".repeat(60));

        CharacterFactory warriorFactory = new WarriorFactory();
        CharacterFactory mageFactory = new MageFactory();
        CharacterFactory archerFactory = new ArcherFactory();

        System.out.println("\n1. Creating Warrior Character:");
        System.out.println("-".repeat(60));
        warriorFactory.createAndDisplayCharacter("DragonSlayer");

        System.out.println("\n2. Creating Mage Character:");
        System.out.println("-".repeat(60));
        mageFactory.createAndDisplayCharacter("Gandalf");

        System.out.println("\n3. Creating Archer Character:");
        System.out.println("-".repeat(60));
        archerFactory.createAndDisplayCharacter("Legolas");

        System.out.println("\n" + "=".repeat(60));
        System.out.println("FACTORY METHOD PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }
} 