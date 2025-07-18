package com.designpatterns.creational.factorymethod;

import com.designpatterns.creational.factorymethod.factories.CharacterFactory;
import com.designpatterns.creational.factorymethod.factories.WarriorFactory;
import com.designpatterns.creational.factorymethod.factories.MageFactory;
import com.designpatterns.creational.factorymethod.factories.ArcherFactory;

public class GameLauncher {
    
    public static void main(String[] args) {
        CharacterFactory warriorFactory = new WarriorFactory();
        CharacterFactory mageFactory = new MageFactory();
        CharacterFactory archerFactory = new ArcherFactory();
        
        warriorFactory.createAndDisplayCharacter("DragonSlayer");
        System.out.println();
        mageFactory.createAndDisplayCharacter("Gandalf");
        System.out.println();
        archerFactory.createAndDisplayCharacter("Legolas");
    }
} 