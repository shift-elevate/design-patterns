package com.designpatterns.behavioural.observer;

public interface StockObserver {
    void update(String stockSymbol, double price, double change);
    String getObserverName();
}
