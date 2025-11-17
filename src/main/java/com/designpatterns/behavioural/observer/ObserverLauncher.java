package com.designpatterns.behavioural.observer;

public class ObserverLauncher {

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("OBSERVER PATTERN - STOCK PRICE MONITORING");
        System.out.println("=".repeat(60));

        StockPriceService techStock = new StockPriceService("TECH", 150.00);

        EmailAlert emailAlert = new EmailAlert("trader@example.com");
        Dashboard mainDashboard = new Dashboard("Main Dashboard");

        System.out.println("\n1. Registering Observers:");
        System.out.println("-".repeat(60));
        techStock.registerObserver(emailAlert);
        techStock.registerObserver(mainDashboard);
        System.out.println("Registered 2 observers: Email Alert and Dashboard");

        System.out.println("\n2. First Price Update (All Observers Notified):");
        System.out.println("-".repeat(60));
        techStock.updatePrice(155.50);

        System.out.println("\n3. Removing Email Observer:");
        System.out.println("-".repeat(60));
        techStock.removeObserver(emailAlert);
        System.out.println("Removed Email Alert observer");

        System.out.println("\n4. Second Price Update (Only Dashboard Notified):");
        System.out.println("-".repeat(60));
        techStock.updatePrice(160.00);

        System.out.println("\n" + "=".repeat(60));
        System.out.println("OBSERVER PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }
}
