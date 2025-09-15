package com.designpatterns.structural.flyweight;

public class CharacterFlyweight implements Character {
    private char letter;
    private FontInfo fontInfo;
    
    public CharacterFlyweight(char letter, FontInfo fontInfo) {
        this.letter = letter;
        this.fontInfo = fontInfo;
    }
    
    @Override
    public void display(Position position, String color, boolean bold) {
        String boldText = bold ? " (bold)" : "";
        System.out.printf("'%c' (%s, %dpt) at %s in %s%s%n",
            letter, fontInfo.getFontFamily(), fontInfo.getFontSize(), 
            position, color, boldText);
    }
    
    @Override
    public char getLetter() {
        return letter;
    }
    
    @Override
    public FontInfo getFontInfo() {
        return fontInfo;
    }
}
