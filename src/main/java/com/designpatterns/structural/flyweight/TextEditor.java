package com.designpatterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    private List<DocumentCharacter> document = new ArrayList<>();
    private CharacterFactory characterFactory;
    
    public TextEditor(CharacterFactory characterFactory) {
        this.characterFactory = characterFactory;
    }
    
    public void addCharacter(char letter, Position position, String color, boolean bold, FontInfo fontInfo) {
        Character character = characterFactory.getCharacter(letter, fontInfo);
        document.add(new DocumentCharacter(character, position, color, bold));
    }
    
    public void displayDocument() {
        System.out.println("=== Document Content ===");
        for (DocumentCharacter docChar : document) {
            docChar.display();
        }
        System.out.println("Total characters in document: " + document.size());
        System.out.println("Unique character objects: " + characterFactory.getCacheSize());
    }
}
