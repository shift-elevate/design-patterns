package com.designpatterns.strategy;

public class LegacyPaymentSystem {
    
    public String makePayment(String cardNumber, String expiryDate, double amount) {
        System.out.println("Legacy Payment System: Processing payment...");
        System.out.println("Card: " + maskCardNumber(cardNumber));
        System.out.println("Expiry: " + expiryDate);
        System.out.println("Amount: $" + String.format("%.2f", amount));
        
        if (isValidPayment(cardNumber, expiryDate, amount)) {
            String transactionId = "TXN_" + System.currentTimeMillis();
            System.out.println("Legacy Payment System: Payment successful - " + transactionId);
            return transactionId;
        } else {
            System.out.println("Legacy Payment System: Payment failed");
            return null;
        }
    }
    
    public boolean checkCardValidity(String cardNumber, String expiryDate) {
        return cardNumber != null 
               && cardNumber.length() == 16 
               && cardNumber.matches("\\d+")
               && expiryDate != null 
               && expiryDate.matches("\\d{2}/\\d{2}");
    }
    
    public boolean checkPaymentLimit(double amount) {
        return amount > 0 && amount <= 10000.0;
    }
    
    public double calculateTransactionFee(double amount) {
        return amount > 100.0 ? amount * 0.025 : amount * 0.015;
    }
    
    private boolean isValidPayment(String cardNumber, String expiryDate, double amount) {
        return checkCardValidity(cardNumber, expiryDate) && checkPaymentLimit(amount);
    }
    
    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 8) {
            return "****";
        }
        return cardNumber.substring(0, 4) + "****" + cardNumber.substring(cardNumber.length() - 4);
    }
} 