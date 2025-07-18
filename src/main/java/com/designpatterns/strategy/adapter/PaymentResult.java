package com.designpatterns.strategy.adapter;

public class PaymentResult {
    private final boolean success;
    private final String transactionId;
    private final String message;
    private final double amount;
    
    public PaymentResult(boolean success, String transactionId, String message, double amount) {
        this.success = success;
        this.transactionId = transactionId;
        this.message = message;
        this.amount = amount;
    }
    
    public PaymentResult(boolean success, String transactionId, String message) {
        this(success, transactionId, message, 0.0);
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public String getTransactionId() {
        return transactionId;
    }
    
    public String getMessage() {
        return message;
    }
    
    public double getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return "PaymentResult{" +
                "success=" + success +
                ", transactionId='" + transactionId + '\'' +
                ", message='" + message + '\'' +
                ", amount=" + amount +
                '}';
    }
} 