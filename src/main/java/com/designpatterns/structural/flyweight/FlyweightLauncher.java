package com.designpatterns.structural.flyweight;

public class FlyweightLauncher {

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("FLYWEIGHT PATTERN - TEXT EDITOR CHARACTER MANAGEMENT");
        System.out.println("=".repeat(60));

        CharacterFactory characterFactory = new CharacterFactory();
        TextEditor editor = new TextEditor(characterFactory);

        FontInfo arial12 = new FontInfo("Arial", 12);
        FontInfo times14 = new FontInfo("Times New Roman", 14);

        System.out.println("\n1. Creating Characters with Shared Flyweights:");
        System.out.println("-".repeat(60));
        editor.addCharacter('H', new Position(0, 0), "black", false, arial12);
        System.out.println("Creating new character: 'H' (Arial)");

        editor.addCharacter('H', new Position(1, 0), "red", true, times14);
        System.out.println("Creating new character: 'H' (Times New Roman)");

        System.out.println("\n2. Displaying Document Content:");
        System.out.println("-".repeat(60));
        editor.displayDocument();

        System.out.println("\n" + "=".repeat(60));
        System.out.println("FLYWEIGHT PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }
}
