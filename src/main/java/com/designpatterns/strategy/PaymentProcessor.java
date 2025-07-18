package com.designpatterns.strategy;

public interface PaymentProcessor {
    
    PaymentResult processPayment(PaymentRequest request);
    
    boolean validatePayment(PaymentRequest request);
} 