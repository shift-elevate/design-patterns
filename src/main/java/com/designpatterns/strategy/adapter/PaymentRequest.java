package com.designpatterns.strategy.adapter;

public class PaymentRequest {
    private final String cardNumber;
    private final String expiryDate;
    private final double amount;
    
    public PaymentRequest(String cardNumber, String expiryDate, double amount) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.amount = amount;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public String getExpiryDate() {
        return expiryDate;
    }
    
    public double getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return "PaymentRequest{" +
                "cardNumber='" + maskCardNumber(cardNumber) + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", amount=" + amount +
                '}';
    }
    
    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 8) {
            return "****";
        }
        return cardNumber.substring(0, 4) + "****" + cardNumber.substring(cardNumber.length() - 4);
    }
} 