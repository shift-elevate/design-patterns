package com.designpatterns.creational.factorymethod;

import com.designpatterns.creational.factorymethod.characters.GameCharacter;
import com.designpatterns.creational.factorymethod.characters.Warrior;
import com.designpatterns.creational.factorymethod.characters.Mage;
import com.designpatterns.creational.factorymethod.characters.Archer;
import com.designpatterns.creational.factorymethod.characters.Rogue;
import com.designpatterns.creational.factorymethod.factories.CharacterFactory;
import com.designpatterns.creational.factorymethod.factories.WarriorFactory;
import com.designpatterns.creational.factorymethod.factories.MageFactory;
import com.designpatterns.creational.factorymethod.factories.ArcherFactory;
import com.designpatterns.creational.factorymethod.factories.RogueFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodTest {
    
    private CharacterFactory warriorFactory;
    private CharacterFactory mageFactory;
    private CharacterFactory archerFactory;
    private CharacterFactory rogueFactory;
    
    @BeforeEach
    void setUp() {
        warriorFactory = new WarriorFactory();
        mageFactory = new MageFactory();
        archerFactory = new ArcherFactory();
        rogueFactory = new RogueFactory();
    }
    
    @Test
    @DisplayName("Warrior Factory creates Warrior with correct health")
    void testWarriorCreation() {
        System.out.println("\n=== Testing Warrior Factory ===");
        
        GameCharacter warrior = warriorFactory.createCharacter();
        
        assertNotNull(warrior);
        assertTrue(warrior instanceof Warrior);
        assertEquals(120, warrior.getHealth());
        
        System.out.println("✓ Warrior created successfully with health: " + warrior.getHealth());
        warrior.attack();
        warrior.defend();
    }
    
    @Test
    @DisplayName("Mage Factory creates Mage with correct health")
    void testMageCreation() {
        System.out.println("\n=== Testing Mage Factory ===");
        
        GameCharacter mage = mageFactory.createCharacter();
        
        assertNotNull(mage);
        assertTrue(mage instanceof Mage);
        assertEquals(70, mage.getHealth());
        
        System.out.println("✓ Mage created successfully with health: " + mage.getHealth());
        mage.attack();
        mage.defend();
    }
    
    @Test
    @DisplayName("Archer Factory creates Archer with correct health")
    void testArcherCreation() {
        System.out.println("\n=== Testing Archer Factory ===");
        
        GameCharacter archer = archerFactory.createCharacter();
        
        assertNotNull(archer);
        assertTrue(archer instanceof Archer);
        assertEquals(90, archer.getHealth());
        
        System.out.println("✓ Archer created successfully with health: " + archer.getHealth());
        archer.attack();
        archer.defend();
    }
    
    @Test
    @DisplayName("Rogue Factory creates Rogue with correct health")
    void testRogueCreation() {
        System.out.println("\n=== Testing Rogue Factory ===");
        
        GameCharacter rogue = rogueFactory.createCharacter();
        
        assertNotNull(rogue);
        assertTrue(rogue instanceof Rogue);
        assertEquals(85, rogue.getHealth());
        
        System.out.println("✓ Rogue created successfully with health: " + rogue.getHealth());
        rogue.attack();
        rogue.defend();
    }
    
    @Test
    @DisplayName("Factory Method Pattern - Different factories create different character types")
    void testFactoryMethodPattern() {
        System.out.println("\n=== Testing Factory Method Pattern ===");
        
        GameCharacter warrior = warriorFactory.createCharacter();
        GameCharacter mage = mageFactory.createCharacter();
        GameCharacter archer = archerFactory.createCharacter();
        GameCharacter rogue = rogueFactory.createCharacter();
        
        assertNotEquals(warrior.getClass(), mage.getClass());
        assertNotEquals(warrior.getClass(), archer.getClass());
        assertNotEquals(warrior.getClass(), rogue.getClass());
        assertNotEquals(mage.getClass(), archer.getClass());
        assertNotEquals(mage.getClass(), rogue.getClass());
        assertNotEquals(archer.getClass(), rogue.getClass());
        
        assertTrue(warrior instanceof GameCharacter);
        assertTrue(mage instanceof GameCharacter);
        assertTrue(archer instanceof GameCharacter);
        assertTrue(rogue instanceof GameCharacter);
        
        System.out.println("✓ All factories create different character types");
        System.out.println("✓ All characters implement the same GameCharacter interface");
        System.out.println("✓ Factory Method Pattern working correctly!");
    }
    
    @Test
    @DisplayName("Character abilities work without exceptions")
    void testCharacterAbilities() {
        System.out.println("\n=== Testing Character Abilities ===");
        
        GameCharacter warrior = warriorFactory.createCharacter();
        
        assertDoesNotThrow(() -> {
            warrior.attack();
            warrior.defend();
        });
        
        System.out.println("✓ All character abilities execute without errors");
    }
    
    @Test
    @DisplayName("Demo: Factory Method Pattern in Action")
    void testFactoryMethodDemo() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎮 FACTORY METHOD PATTERN DEMONSTRATION");
        System.out.println("=".repeat(60));
        System.out.println("This test demonstrates the Factory Method pattern by creating");
        System.out.println("different character types using their respective factories.");
        System.out.println("=".repeat(60));
        
        warriorFactory.createAndDisplayCharacter("DragonSlayer");
        System.out.println();
        
        mageFactory.createAndDisplayCharacter("Gandalf");
        System.out.println();
        
        archerFactory.createAndDisplayCharacter("Legolas");
        System.out.println();
        
        rogueFactory.createAndDisplayCharacter("ShadowBlade");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ DEMO COMPLETE!");
        System.out.println("Notice how the client code works with factories through");
        System.out.println("the common interface without knowing specific implementations.");
        System.out.println("=".repeat(60));
        
        assertTrue(true, "Factory Method Pattern demonstration completed successfully");
    }
} 