package com.designpatterns.structural.flyweight;

public class FlyweightLauncher {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();
        TextEditor editor = new TextEditor(characterFactory);
        
        FontInfo arial12 = new FontInfo("Arial", 12);
        FontInfo times14 = new FontInfo("Times New Roman", 14);
        
        editor.addCharacter('H', new Position(0, 0), "black", false, arial12);
        editor.addCharacter('H', new Position(1, 0), "red", true, times14);
        
        editor.displayDocument();
    }
}
