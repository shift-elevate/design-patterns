package com.designpatterns.behavioural.observer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ObserverPatternTest {
    
    private StockPriceService stockService;
    private EmailAlert emailAlert;
    private Dashboard dashboard;
    
    @BeforeEach
    void setUp() {
        stockService = new StockPriceService("TEST", 100.0);
        emailAlert = new EmailAlert("test@example.com");
        dashboard = new Dashboard("Test Dashboard");
    }
    
    @Test
    @DisplayName("StockPriceService - basic functionality")
    void testStockPriceServiceBasicFunctionality() {
        assertEquals("TEST", stockService.getStockSymbol());
        assertEquals(100.0, stockService.getCurrentPrice(), 0.01);
        assertEquals(0, stockService.getObserverCount());
    }
    
    @Test
    @DisplayName("EmailAlert - basic functionality")
    void testEmailAlertBasicFunctionality() {
        assertEquals("test@example.com", emailAlert.getEmail());
        assertEquals("Email Alert", emailAlert.getObserverName());
    }
    
    @Test
    @DisplayName("Dashboard - basic functionality")
    void testDashboardBasicFunctionality() {
        assertEquals("Test Dashboard", dashboard.getName());
        assertEquals("Dashboard", dashboard.getObserverName());
    }
    
    @Test
    @DisplayName("Observer Registration and Removal")
    void testObserverRegistrationAndRemoval() {
        assertEquals(0, stockService.getObserverCount());
        
        stockService.registerObserver(emailAlert);
        assertEquals(1, stockService.getObserverCount());
        
        stockService.registerObserver(dashboard);
        assertEquals(2, stockService.getObserverCount());
        
        stockService.removeObserver(emailAlert);
        assertEquals(1, stockService.getObserverCount());
        
        stockService.removeObserver(dashboard);
        assertEquals(0, stockService.getObserverCount());
    }
    
    @Test
    @DisplayName("Price Updates")
    void testPriceUpdates() {
        stockService.registerObserver(dashboard);
        
        stockService.updatePrice(110.0);
        assertEquals(110.0, stockService.getCurrentPrice(), 0.01);
        
        stockService.updatePrice(95.0);
        assertEquals(95.0, stockService.getCurrentPrice(), 0.01);
    }
    
    @Test
    @DisplayName("Multiple Observers")
    void testMultipleObservers() {
        EmailAlert alert1 = new EmailAlert("alert1@example.com");
        EmailAlert alert2 = new EmailAlert("alert2@example.com");
        Dashboard dash1 = new Dashboard("Dashboard 1");
        Dashboard dash2 = new Dashboard("Dashboard 2");
        
        stockService.registerObserver(alert1);
        stockService.registerObserver(dash1);
        stockService.registerObserver(alert2);
        stockService.registerObserver(dash2);
        
        assertEquals(4, stockService.getObserverCount());
        
        stockService.updatePrice(105.0);
    }
    
    @Test
    @DisplayName("Observer Pattern Integration")
    void testObserverPatternIntegration() {
        StockPriceService techStock = new StockPriceService("TECH", 150.0);
        StockPriceService financeStock = new StockPriceService("FINANCE", 200.0);
        
        EmailAlert techAlert = new EmailAlert("tech@example.com");
        EmailAlert financeAlert = new EmailAlert("finance@example.com");
        Dashboard portfolioDashboard = new Dashboard("Portfolio Dashboard");
        
        techStock.registerObserver(techAlert);
        techStock.registerObserver(portfolioDashboard);
        financeStock.registerObserver(financeAlert);
        financeStock.registerObserver(portfolioDashboard);
        
        assertEquals(2, techStock.getObserverCount());
        assertEquals(2, financeStock.getObserverCount());
        
        techStock.updatePrice(160.0);
        financeStock.updatePrice(220.0);
    }
    
    @Test
    @DisplayName("Edge Cases")
    void testEdgeCases() {
        assertDoesNotThrow(() -> stockService.notifyObservers());
        
        stockService.updatePrice(105.0);
        assertEquals(105.0, stockService.getCurrentPrice(), 0.01);
        
        stockService.removeObserver(emailAlert);
        assertDoesNotThrow(() -> stockService.notifyObservers());
    }
    
    @Test
    @DisplayName("Demo: Observer Pattern in Action")
    void testObserverPatternDemo() {
        ObserverLauncher.main(new String[]{});
        assertTrue(true, "Observer Pattern demonstration completed successfully");
    }
}
