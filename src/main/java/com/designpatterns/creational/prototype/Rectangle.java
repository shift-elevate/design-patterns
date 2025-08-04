package com.designpatterns.creational.prototype;

public class Rectangle implements Shape {
    private int width;
    private int height;
    private String color;
    private String name;

    public Rectangle(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.name = "Rectangle";
    }

    @Override
    public Shape clone() {
        return new Rectangle(this.width, this.height, this.color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " rectangle " + width + "x" + height);
    }

    @Override
    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(String color) {
        this.color = color;
    }
} 