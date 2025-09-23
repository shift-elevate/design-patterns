package com.designpatterns.behavioural.observer;

public class ObserverLauncher {
    
    public static void main(String[] args) {
        StockPriceService techStock = new StockPriceService("TECH", 150.00);
        
        EmailAlert emailAlert = new EmailAlert("trader@example.com");
        Dashboard mainDashboard = new Dashboard("Main Dashboard");
        
        techStock.registerObserver(emailAlert);
        techStock.registerObserver(mainDashboard);
        
        techStock.updatePrice(155.50);
        
        techStock.removeObserver(emailAlert);
        techStock.updatePrice(160.00);
    }
}
