package com.designpatterns.structural.adapter;

public interface PaymentProcessor {
    
    PaymentResult processPayment(PaymentRequest request);
    
    boolean validatePayment(PaymentRequest request);
} 