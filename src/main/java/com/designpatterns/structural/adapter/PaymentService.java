package com.designpatterns.structural.adapter;

public class PaymentService {
    
    private final PaymentProcessor paymentProcessor;
    
    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
    
    public PaymentResult processCustomerPayment(PaymentRequest request) {
        System.out.println("PaymentService: Processing customer payment...");
        System.out.println("Request: " + request);
        
        if (request == null) {
            return new PaymentResult(false, null, "Payment request cannot be null");
        }
        
        if (request.getAmount() <= 0) {
            return new PaymentResult(false, null, "Payment amount must be positive");
        }
        
        if (!paymentProcessor.validatePayment(request)) {
            return new PaymentResult(
                false, 
                null, 
                "Payment validation failed - please check your payment details",
                request.getAmount()
            );
        }
        
        PaymentResult result = paymentProcessor.processPayment(request);
        
        if (result.isSuccess()) {
            System.out.println("PaymentService: Payment successful - " + result.getTransactionId());
        } else {
            System.out.println("PaymentService: Payment failed - " + result.getMessage());
        }
        
        return result;
    }
    
    public PaymentResult processRefund(String transactionId, double amount, String reason) {
        System.out.println("PaymentService: Processing refund...");
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Amount: $" + String.format("%.2f", amount));
        System.out.println("Reason: " + reason);
        
        if (transactionId != null && amount > 0) {
            String refundId = "REF_" + System.currentTimeMillis();
            return new PaymentResult(
                true,
                refundId,
                "Refund processed successfully",
                amount
            );
        } else {
            return new PaymentResult(
                false,
                null,
                "Invalid refund request",
                amount
            );
        }
    }
    
    public boolean validatePaymentOnly(PaymentRequest request) {
        System.out.println("PaymentService: Validating payment (no processing)...");
        
        if (request == null || request.getAmount() <= 0) {
            return false;
        }
        
        return paymentProcessor.validatePayment(request);
    }
    
    public PaymentProcessor getPaymentProcessor() {
        return paymentProcessor;
    }
} 