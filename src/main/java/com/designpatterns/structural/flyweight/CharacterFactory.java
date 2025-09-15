package com.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private Map<String, Character> characterCache = new HashMap<>();
    
    public Character getCharacter(char letter, FontInfo fontInfo) {
        String key = letter + "_" + fontInfo.hashCode();
        
        return characterCache.computeIfAbsent(key, k -> {
            System.out.println("Creating new character: '" + letter + "' (" + fontInfo.getFontFamily() + ")");
            return new CharacterFlyweight(letter, fontInfo);
        });
    }
    
    public int getCacheSize() {
        return characterCache.size();
    }
    
    public void clearCache() {
        characterCache.clear();
    }
}
