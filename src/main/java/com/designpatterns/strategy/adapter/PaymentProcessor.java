package com.designpatterns.strategy.adapter;

public interface PaymentProcessor {
    
    PaymentResult processPayment(PaymentRequest request);
    
    boolean validatePayment(PaymentRequest request);
} 