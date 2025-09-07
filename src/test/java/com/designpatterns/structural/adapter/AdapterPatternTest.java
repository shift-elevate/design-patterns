package com.designpatterns.structural.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class AdapterPatternTest {
    
    private LegacyPaymentSystem legacySystem;
    private LegacyPaymentAdapter adapter;
    private PaymentService paymentService;
    
    @BeforeEach
    void setUp() {
        legacySystem = new LegacyPaymentSystem();
        adapter = new LegacyPaymentAdapter(legacySystem);
        paymentService = new PaymentService(adapter);
    }
    
    @Test
    @DisplayName("Should create adapter with legacy system")
    void testAdapterCreation() {
        assertNotNull(adapter);
        assertSame(legacySystem, adapter.getLegacySystem());
    }
    
    @Test
    @DisplayName("Should process valid payment successfully through adapter")
    void testValidPaymentProcessing() {
        PaymentRequest request = new PaymentRequest(
            "1234567890123456",
            "12/25",
            99.99
        );
        
        PaymentResult result = adapter.processPayment(request);
        
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertNotNull(result.getTransactionId());
        assertTrue(result.getTransactionId().startsWith("TXN_"));
        assertTrue(result.getMessage().contains("successfully"));
        assertEquals(99.99, result.getAmount(), 0.01);
    }
    
    @Test
    @DisplayName("Should validate payment correctly through adapter")
    void testPaymentValidation() {
        PaymentRequest validRequest = new PaymentRequest(
            "1234567890123456",
            "12/25",
            99.99
        );
        
        assertTrue(adapter.validatePayment(validRequest));
        
        PaymentRequest invalidCard = new PaymentRequest(
            "1234",
            "12/25",
            99.99
        );
        
        assertFalse(adapter.validatePayment(invalidCard));
    }
    
    @Test
    @DisplayName("Should handle null payment request gracefully")
    void testNullPaymentRequest() {
        assertFalse(adapter.validatePayment(null));
        
        PaymentResult result = adapter.processPayment(null);
        assertNotNull(result);
        assertFalse(result.isSuccess());
        assertEquals("Payment validation failed", result.getMessage());
    }
    
    @Test
    @DisplayName("Should handle payment amount limits correctly")
    void testPaymentAmountLimits() {
        PaymentRequest validAmount = new PaymentRequest(
            "1234567890123456",
            "12/25",
            5000.00
        );
        
        assertTrue(adapter.validatePayment(validAmount));
        
        PaymentRequest excessiveAmount = new PaymentRequest(
            "1234567890123456",
            "12/25",
            15000.00
        );
        
        assertFalse(adapter.validatePayment(excessiveAmount));
        
        PaymentRequest negativeAmount = new PaymentRequest(
            "1234567890123456",
            "12/25",
            -100.00
        );
        
        assertFalse(adapter.validatePayment(negativeAmount));
    }
    
    @Test
    @DisplayName("Should calculate transaction fees correctly")
    void testTransactionFeeCalculation() {
        double fee1 = adapter.calculateTransactionFee(200.00);
        assertEquals(5.00, fee1, 0.01);
        
        double fee2 = adapter.calculateTransactionFee(50.00);
        assertEquals(0.75, fee2, 0.01);
        
        double fee3 = adapter.calculateTransactionFee(100.00);
        assertEquals(1.50, fee3, 0.01);
    }
    
    @Test
    @DisplayName("Should handle legacy system failures gracefully")
    void testLegacySystemFailures() {
        PaymentRequest invalidRequest = new PaymentRequest(
            "invalid",
            "invalid",
            99.99
        );
        
        PaymentResult result = adapter.processPayment(invalidRequest);
        
        assertNotNull(result);
        assertFalse(result.isSuccess());
        assertNull(result.getTransactionId());
        assertTrue(result.getMessage().contains("validation failed"));
    }
    
    @Test
    @DisplayName("Should work seamlessly with PaymentService")
    void testPaymentServiceIntegration() {
        PaymentRequest request = new PaymentRequest(
            "1234567890123456",
            "12/25",
            149.99
        );
        
        PaymentResult result = paymentService.processCustomerPayment(request);
        
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertNotNull(result.getTransactionId());
        assertEquals(149.99, result.getAmount(), 0.01);
    }
    
    @Test
    @DisplayName("Should handle PaymentService validation failures")
    void testPaymentServiceValidationFailures() {
        PaymentResult nullResult = paymentService.processCustomerPayment(null);
        assertFalse(nullResult.isSuccess());
        assertEquals("Payment request cannot be null", nullResult.getMessage());
        
        PaymentRequest negativeRequest = new PaymentRequest(
            "1234567890123456",
            "12/25",
            -50.00
        );
        
        PaymentResult negativeResult = paymentService.processCustomerPayment(negativeRequest);
        assertFalse(negativeResult.isSuccess());
        assertEquals("Payment amount must be positive", negativeResult.getMessage());
        
        PaymentRequest invalidRequest = new PaymentRequest(
            "1234",
            "12/25",
            99.99
        );
        
        PaymentResult invalidResult = paymentService.processCustomerPayment(invalidRequest);
        assertFalse(invalidResult.isSuccess());
        assertTrue(invalidResult.getMessage().contains("validation failed"));
    }
    
    @Test
    @DisplayName("Should process refunds correctly")
    void testRefundProcessing() {
        PaymentRequest request = new PaymentRequest(
            "1234567890123456",
            "12/25",
            100.00
        );
        
        PaymentResult paymentResult = paymentService.processCustomerPayment(request);
        assertTrue(paymentResult.isSuccess());
        
        PaymentResult refundResult = paymentService.processRefund(
            paymentResult.getTransactionId(),
            25.00,
            "Customer requested refund"
        );
        
        assertTrue(refundResult.isSuccess());
        assertNotNull(refundResult.getTransactionId());
        assertTrue(refundResult.getTransactionId().startsWith("REF_"));
        assertEquals(25.00, refundResult.getAmount(), 0.01);
    }
    
    @Test
    @DisplayName("Should handle invalid refund requests")
    void testInvalidRefundRequests() {
        PaymentResult nullRefund = paymentService.processRefund(null, 25.00, "Refund");
        assertFalse(nullRefund.isSuccess());
        
        PaymentResult negativeRefund = paymentService.processRefund("TXN_123", -25.00, "Refund");
        assertFalse(negativeRefund.isSuccess());
    }
    
    @Test
    @DisplayName("Should validate payments without processing")
    void testValidationOnly() {
        PaymentRequest validRequest = new PaymentRequest(
            "1234567890123456",
            "12/25",
            99.99
        );
        
        assertTrue(paymentService.validatePaymentOnly(validRequest));
        
        PaymentRequest invalidRequest = new PaymentRequest(
            "1234",
            "12/25",
            99.99
        );
        
        assertFalse(paymentService.validatePaymentOnly(invalidRequest));
        
        assertFalse(paymentService.validatePaymentOnly(null));
        
        PaymentRequest negativeRequest = new PaymentRequest(
            "1234567890123456",
            "12/25",
            -50.00
        );
        
        assertFalse(paymentService.validatePaymentOnly(negativeRequest));
    }
    
    @Test
    @DisplayName("Should provide access to underlying payment processor")
    void testPaymentProcessorAccess() {
        PaymentProcessor processor = paymentService.getPaymentProcessor();
        assertNotNull(processor);
        assertTrue(processor instanceof LegacyPaymentAdapter);
    }
    
    @Test
    @DisplayName("Should demonstrate adapter pattern benefits")
    void testAdapterPatternDemo() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🔌 ADAPTER PATTERN DEMONSTRATION");
        System.out.println("=".repeat(60));
        
        PaymentRequest request = new PaymentRequest(
            "1234567890123456",
            "12/25",
            199.99
        );
        
        PaymentResult result = paymentService.processCustomerPayment(request);
        
        assertTrue(result.isSuccess());
        assertNotNull(result.getTransactionId());
        assertEquals(199.99, result.getAmount(), 0.01);
        
        System.out.println("✓ Modern interface working with legacy system");
        System.out.println("✓ Enhanced functionality added by adapter");
        System.out.println("✓ Transparent integration achieved");
        
        assertTrue(paymentService.validatePaymentOnly(request));
        
        if (paymentService.getPaymentProcessor() instanceof LegacyPaymentAdapter) {
            LegacyPaymentAdapter adapter = (LegacyPaymentAdapter) paymentService.getPaymentProcessor();
            double fee = adapter.calculateTransactionFee(199.99);
            assertEquals(5.00, fee, 0.01);
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ ADAPTER PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }
    
    @Test
    @DisplayName("Should handle PaymentRequest toString method safely")
    void testPaymentRequestToString() {
        PaymentRequest request = new PaymentRequest(
            "1234567890123456",
            "12/25",
            99.99
        );
        
        String toString = request.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("1234****3456"));
        assertTrue(toString.contains("12/25"));
        assertTrue(toString.contains("99.99"));
        assertFalse(toString.contains("1234567890123456"));
    }
} 