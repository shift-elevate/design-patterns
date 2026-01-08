package com.designpatterns.structural.proxy;

public interface Image {
    void display();
    void loadFullResolution();
    ImageMetadata getMetadata();
}
