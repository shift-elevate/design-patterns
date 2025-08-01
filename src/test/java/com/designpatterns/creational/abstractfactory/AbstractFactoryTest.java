package com.designpatterns.creational.abstractfactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractFactoryTest {
    
    @Test
    public void testMedievalFactoryCreatesConsistentProducts() {
        WorldFactory factory = new MedievalFactory();
        
        GameCharacter character = factory.createCharacter();
        Weapon weapon = factory.createWeapon();
        Armor armor = factory.createArmor();
        
        // Verify all products are from the same family
        assertTrue(character instanceof MedievalWarrior);
        assertTrue(weapon instanceof MedievalSword);
        assertTrue(armor instanceof MedievalArmor);
    }
    
    @Test
    public void testSciFiFactoryCreatesConsistentProducts() {
        WorldFactory factory = new SciFiFactory();
        
        GameCharacter character = factory.createCharacter();
        Weapon weapon = factory.createWeapon();
        Armor armor = factory.createArmor();
        
        // Verify all products are from the same family
        assertTrue(character instanceof SciFiSoldier);
        assertTrue(weapon instanceof LaserGun);
        assertTrue(armor instanceof SciFiArmor);
    }
    
    @Test
    public void testMedievalCharacterBehavior() {
        GameCharacter warrior = new MedievalWarrior();
        
        assertEquals(120, warrior.getHealth());
        // Note: We can't easily test System.out.println output in unit tests
        // but we can verify the methods don't throw exceptions
        assertDoesNotThrow(() -> warrior.attack());
        assertDoesNotThrow(() -> warrior.defend());
    }
    
    @Test
    public void testSciFiCharacterBehavior() {
        GameCharacter soldier = new SciFiSoldier();
        
        assertEquals(100, soldier.getHealth());
        assertDoesNotThrow(() -> soldier.attack());
        assertDoesNotThrow(() -> soldier.defend());
    }
    
    @Test
    public void testWeaponAndArmorBehavior() {
        Weapon sword = new MedievalSword();
        Armor armor = new MedievalArmor();
        
        assertDoesNotThrow(() -> sword.use());
        assertDoesNotThrow(() -> armor.equip());
    }
} 