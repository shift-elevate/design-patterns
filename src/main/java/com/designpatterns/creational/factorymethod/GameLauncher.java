package com.designpatterns.creational.factorymethod;

import com.designpatterns.creational.factorymethod.factories.CharacterFactory;
import com.designpatterns.creational.factorymethod.factories.WarriorFactory;
import com.designpatterns.creational.factorymethod.factories.MageFactory;
import com.designpatterns.creational.factorymethod.factories.ArcherFactory;

/**
 * GameLauncher - Client code that demonstrates the Factory Method pattern
 * This class shows how to use different character factories without knowing
 * the specific implementations
 */
public class GameLauncher {
    
    public static void main(String[] args) {
        // Client code works with factories through the common interface
        CharacterFactory warriorFactory = new WarriorFactory();
        CharacterFactory mageFactory = new MageFactory();
        CharacterFactory archerFactory = new ArcherFactory();
        
        // Create characters without knowing specific implementations
        warriorFactory.createAndDisplayCharacter("DragonSlayer");
        System.out.println();
        mageFactory.createAndDisplayCharacter("Gandalf");
        System.out.println();
        archerFactory.createAndDisplayCharacter("Legolas");
    }
} 