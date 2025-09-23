package com.designpatterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class StockPriceService implements StockSubject {
    private List<StockObserver> observers = new ArrayList<>();
    private String stockSymbol;
    private double currentPrice;
    
    public StockPriceService(String stockSymbol, double initialPrice) {
        this.stockSymbol = stockSymbol;
        this.currentPrice = initialPrice;
    }
    
    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(stockSymbol, currentPrice, 0);
        }
    }
    
    public void updatePrice(double newPrice) {
        this.currentPrice = newPrice;
        notifyObservers();
    }
    
    public String getStockSymbol() { return stockSymbol; }
    public double getCurrentPrice() { return currentPrice; }
    public int getObserverCount() { return observers.size(); }
}
