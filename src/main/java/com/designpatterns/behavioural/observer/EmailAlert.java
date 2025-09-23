package com.designpatterns.behavioural.observer;

public class EmailAlert implements StockObserver {
    private String email;
    
    public EmailAlert(String email) {
        this.email = email;
    }
    
    @Override
    public void update(String stockSymbol, double price, double change) {
        System.out.println("📧 Email to " + email + ": " + 
            stockSymbol + " is now $" + price);
    }
    
    @Override
    public String getObserverName() {
        return "Email Alert";
    }
    
    public String getEmail() { return email; }
}
