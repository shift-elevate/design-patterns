package com.designpatterns.creational.prototype;

public class Circle implements Shape {
    private int radius;
    private String color;
    private String name;

    public Circle(int radius, String color) {
        this.radius = radius;
        this.color = color;
        this.name = "Circle";
    }

    @Override
    public Shape clone() {
        return new Circle(this.radius, this.color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle with radius " + radius);
    }

    @Override
    public String getName() {
        return name;
    }

    public int getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }
} 