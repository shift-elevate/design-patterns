package com.designpatterns.structural.flyweight;

public class DocumentCharacter {
    private Character character;
    private Position position;
    private String color;
    private boolean bold;
    
    public DocumentCharacter(Character character, Position position, String color, boolean bold) {
        this.character = character;
        this.position = position;
        this.color = color;
        this.bold = bold;
    }
    
    public void display() {
        character.display(position, color, bold);
    }
    
    public Character getCharacter() { return character; }
    public Position getPosition() { return position; }
    public String getColor() { return color; }
    public boolean isBold() { return bold; }
}

