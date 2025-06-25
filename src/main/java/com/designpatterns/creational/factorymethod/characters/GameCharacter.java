package com.designpatterns.creational.factorymethod.characters;

/**
 * GameCharacter Interface - Defines the common interface for all character types
 * Part of the Factory Method Pattern implementation
 */
public interface GameCharacter {
    void attack();
    void defend();
    int getHealth();
} 