package com.designpatterns.structural.adapter;

public class LegacyPaymentAdapter implements PaymentProcessor {
    
    private final LegacyPaymentSystem legacySystem;
    
    public LegacyPaymentAdapter(LegacyPaymentSystem legacySystem) {
        this.legacySystem = legacySystem;
    }
    
    @Override
    public PaymentResult processPayment(PaymentRequest request) {
        System.out.println("Adapter: Converting modern payment request to legacy format...");
        
        if (request == null) {
            return new PaymentResult(
                false, 
                null, 
                "Payment validation failed", 
                0.0
            );
        }
        
        if (!validatePayment(request)) {
            return new PaymentResult(
                false, 
                null, 
                "Payment validation failed", 
                request.getAmount()
            );
        }
        
        String transactionId = legacySystem.makePayment(
            request.getCardNumber(),
            request.getExpiryDate(),
            request.getAmount()
        );
        
        if (transactionId != null) {
            double fee = legacySystem.calculateTransactionFee(request.getAmount());
            return new PaymentResult(
                true,
                transactionId,
                String.format("Payment processed successfully. Fee: $%.2f", fee),
                request.getAmount()
            );
        } else {
            return new PaymentResult(
                false,
                null,
                "Payment processing failed in legacy system",
                request.getAmount()
            );
        }
    }
    
    @Override
    public boolean validatePayment(PaymentRequest request) {
        System.out.println("Adapter: Validating payment using legacy system...");
        
        if (request == null) {
            return false;
        }
        
        boolean cardValid = legacySystem.checkCardValidity(
            request.getCardNumber(),
            request.getExpiryDate()
        );
        
        boolean amountValid = legacySystem.checkPaymentLimit(request.getAmount());
        
        return cardValid && amountValid;
    }
    
    public LegacyPaymentSystem getLegacySystem() {
        return legacySystem;
    }
    
    public double calculateTransactionFee(double amount) {
        return legacySystem.calculateTransactionFee(amount);
    }
} 