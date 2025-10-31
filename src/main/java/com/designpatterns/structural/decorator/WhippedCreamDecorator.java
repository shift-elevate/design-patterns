package com.designpatterns.structural.decorator;

public class WhippedCreamDecorator extends CoffeeDecorator {

    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", whipped cream";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.8;
    }
}
