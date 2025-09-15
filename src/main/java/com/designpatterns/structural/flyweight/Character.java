package com.designpatterns.structural.flyweight;

public interface Character {
    void display(Position position, String color, boolean bold);
    char getLetter();
    FontInfo getFontInfo();
}
