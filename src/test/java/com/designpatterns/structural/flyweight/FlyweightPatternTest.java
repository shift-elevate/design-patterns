package com.designpatterns.structural.flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class FlyweightPatternTest {
    
    private CharacterFactory characterFactory;
    private TextEditor textEditor;
    
    @BeforeEach
    void setUp() {
        characterFactory = new CharacterFactory();
        textEditor = new TextEditor(characterFactory);
    }
    
    @Test
    @DisplayName("Character flyweight should store intrinsic state correctly")
    void testCharacterFlyweightIntrinsicState() {
        FontInfo font = new FontInfo("Arial", 12);
        Character character = new CharacterFlyweight('A', font);
        
        assertEquals('A', character.getLetter());
        assertEquals(font, character.getFontInfo());
        assertEquals("Arial", character.getFontInfo().getFontFamily());
        assertEquals(12, character.getFontInfo().getFontSize());
    }
    
    @Test
    @DisplayName("FontInfo should support equality")
    void testFontInfoEquality() {
        FontInfo font1 = new FontInfo("Arial", 12);
        FontInfo font2 = new FontInfo("Arial", 12);
        FontInfo font3 = new FontInfo("Times", 12);
        
        assertEquals(font1, font2);
        assertNotEquals(font1, font3);
        assertEquals(font1.hashCode(), font2.hashCode());
        assertNotEquals(font1.hashCode(), font3.hashCode());
    }
    
    @Test
    @DisplayName("Character factory should reuse flyweight instances")
    void testCharacterFactoryReuse() {
        FontInfo font = new FontInfo("Arial", 12);
        
        Character char1 = characterFactory.getCharacter('A', font);
        Character char2 = characterFactory.getCharacter('A', font);
        Character char3 = characterFactory.getCharacter('B', font);
        
        assertSame(char1, char2);
        assertNotSame(char1, char3);
        assertEquals(2, characterFactory.getCacheSize());
    }
    
    @Test
    @DisplayName("Character factory should handle different fonts correctly")
    void testCharacterFactoryDifferentFonts() {
        FontInfo arial = new FontInfo("Arial", 12);
        FontInfo times = new FontInfo("Times", 12);
        
        Character charA1 = characterFactory.getCharacter('A', arial);
        Character charA2 = characterFactory.getCharacter('A', times);
        
        assertNotSame(charA1, charA2);
        assertEquals(2, characterFactory.getCacheSize());
    }
    
    @Test
    @DisplayName("Text editor should manage document characters correctly")
    void testTextEditorBasicFunctionality() {
        FontInfo font = new FontInfo("Arial", 12);
        
        textEditor.addCharacter('H', new Position(0, 0), "black", false, font);
        textEditor.addCharacter('e', new Position(1, 0), "red", true, font);
        
        assertEquals(2, characterFactory.getCacheSize());
    }
    
    @Test
    @DisplayName("Factory should handle cache clearing correctly")
    void testFactoryCacheClearing() {
        FontInfo font = new FontInfo("Arial", 12);
        
        characterFactory.getCharacter('A', font);
        characterFactory.getCharacter('B', font);
        
        assertEquals(2, characterFactory.getCacheSize());
        
        characterFactory.clearCache();
        
        assertEquals(0, characterFactory.getCacheSize());
    }
}
