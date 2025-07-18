package com.designpatterns.strategy;

public class ECommerceLauncher {
    
    public static void main(String[] args) {
        System.out.println("=== Adapter Pattern Demo: E-Commerce Payment Integration ===\n");
        
        LegacyPaymentSystem legacySystem = new LegacyPaymentSystem();
        
        PaymentProcessor processor = new LegacyPaymentAdapter(legacySystem);
        
        PaymentService paymentService = new PaymentService(processor);
        
        System.out.println("1. Successful Payment Processing:");
        System.out.println("=".repeat(50));
        
        PaymentRequest validRequest = new PaymentRequest(
            "1234567890123456",
            "12/25",
            99.99
        );
        
        PaymentResult result = paymentService.processCustomerPayment(validRequest);
        displayPaymentResult(result);
        System.out.println();
        
        System.out.println("2. Payment Validation Failure:");
        System.out.println("=".repeat(50));
        
        PaymentRequest invalidRequest = new PaymentRequest(
            "1234",
            "12/25",
            50.00
        );
        
        PaymentResult failureResult = paymentService.processCustomerPayment(invalidRequest);
        displayPaymentResult(failureResult);
        System.out.println();
        
        System.out.println("3. Payment Amount Limit Validation:");
        System.out.println("=".repeat(50));
        
        PaymentRequest limitRequest = new PaymentRequest(
            "1234567890123456",
            "12/25",
            15000.00
        );
        
        PaymentResult limitResult = paymentService.processCustomerPayment(limitRequest);
        displayPaymentResult(limitResult);
        System.out.println();
        
        System.out.println("4. Refund Processing:");
        System.out.println("=".repeat(50));
        
        if (result.isSuccess()) {
            PaymentResult refundResult = paymentService.processRefund(
                result.getTransactionId(),
                25.00,
                "Customer requested partial refund"
            );
            displayPaymentResult(refundResult);
        }
        System.out.println();
        
        System.out.println("5. Validation-Only Check:");
        System.out.println("=".repeat(50));
        
        PaymentRequest checkRequest = new PaymentRequest(
            "9876543210987654",
            "08/26",
            299.99
        );
        
        boolean isValid = paymentService.validatePaymentOnly(checkRequest);
        System.out.println("Payment validation result: " + (isValid ? "VALID" : "INVALID"));
        System.out.println();
        
        System.out.println("6. Adapter-Specific Functionality:");
        System.out.println("=".repeat(50));
        
        if (processor instanceof LegacyPaymentAdapter) {
            LegacyPaymentAdapter adapter = (LegacyPaymentAdapter) processor;
            double fee = adapter.calculateTransactionFee(199.99);
            System.out.println("Transaction fee for $199.99: $" + String.format("%.2f", fee));
            
            LegacyPaymentSystem legacy = adapter.getLegacySystem();
            System.out.println("Legacy system card validity check: " + 
                legacy.checkCardValidity("1234567890123456", "12/25"));
        }
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("Adapter Pattern Benefits Demonstrated:");
        System.out.println("• Legacy system integration without modification");
        System.out.println("• Modern interface for client code");
        System.out.println("• Transparent translation between incompatible interfaces");
        System.out.println("• Enhanced functionality added by adapter");
        System.out.println("• Clean separation of concerns");
        System.out.println("=".repeat(70));
    }
    
    private static void displayPaymentResult(PaymentResult result) {
        System.out.println("Payment Result:");
        System.out.println("  Success: " + result.isSuccess());
        System.out.println("  Transaction ID: " + result.getTransactionId());
        System.out.println("  Message: " + result.getMessage());
        System.out.println("  Amount: $" + String.format("%.2f", result.getAmount()));
    }
} 