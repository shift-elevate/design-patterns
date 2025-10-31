package com.designpatterns.structural.decorator;

public class VanillaDecorator extends CoffeeDecorator {

    public VanillaDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", vanilla";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.6;
    }
}
