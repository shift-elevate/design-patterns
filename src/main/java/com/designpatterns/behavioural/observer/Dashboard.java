package com.designpatterns.behavioural.observer;

public class Dashboard implements StockObserver {
    private String name;
    
    public Dashboard(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String stockSymbol, double price, double change) {
        System.out.println("📊 " + name + ": " + 
            stockSymbol + " = $" + price);
    }
    
    @Override
    public String getObserverName() {
        return "Dashboard";
    }
    
    public String getName() { return name; }
}
