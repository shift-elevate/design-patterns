package com.designpatterns.creational.builder;

import com.designpatterns.creational.builder.StandardProductBuilder;
import com.designpatterns.creational.builder.PremiumProductBuilder;
import com.designpatterns.creational.builder.StandardProduct;
import com.designpatterns.creational.builder.PremiumProduct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class BuilderPatternTest {
    
    private StandardProductBuilder standardBuilder;
    private PremiumProductBuilder premiumBuilder;
    private ProductDirector director;
    
    @BeforeEach
    void setUp() {
        standardBuilder = new StandardProductBuilder();
        premiumBuilder = new PremiumProductBuilder();
        director = new ProductDirector();
    }
    
    @Test
    @DisplayName("Should create standard product with all fields")
    void testStandardProductCreation() {
        Product product = standardBuilder
            .setName("Test Product")
            .setPrice(99.99)
            .setDescription("Test description")
            .addTag("tag1")
            .addTag("tag2")
            .build();
        
        assertNotNull(product);
        assertEquals("Test Product", product.getName());
        assertEquals(99.99, product.getPrice(), 0.01);
        assertEquals("Test description", product.getDescription());
        assertEquals(2, product.getTags().size());
        assertTrue(product.getTags().contains("tag1"));
        assertTrue(product.getTags().contains("tag2"));
        
        assertTrue(product instanceof StandardProduct);
    }
    
    @Test
    @DisplayName("Should create premium product with extended features")
    void testPremiumProductCreation() {
        Product product = premiumBuilder
            .setName("Premium Product")
            .setPrice(299.99)
            .setDescription("Premium description")
            .addTag("premium")
            .setWarrantyMonths(24)
            .setSupportLevel("Premium")
            .build();
        
        assertNotNull(product);
        assertEquals("Premium Product", product.getName());
        assertEquals(299.99, product.getPrice(), 0.01);
        assertEquals("Premium description", product.getDescription());
        assertTrue(product.getTags().contains("premium"));
        
        assertTrue(product instanceof PremiumProduct);
        PremiumProduct premiumProduct = (PremiumProduct) product;
        assertEquals(24, premiumProduct.getWarrantyMonths());
        assertEquals("Premium", premiumProduct.getSupportLevel());
    }
    
    @Test
    @DisplayName("Should validate required fields")
    void testValidationRequiredFields() {
        assertThrows(IllegalStateException.class, () -> {
            standardBuilder.setPrice(99.99).build();
        });
        
        assertThrows(IllegalStateException.class, () -> {
            standardBuilder.setName("").setPrice(99.99).build();
        });
        
        assertThrows(IllegalStateException.class, () -> {
            standardBuilder.setName("Test").setPrice(-10.0).build();
        });
    }
    
    @Test
    @DisplayName("Should support fluent interface method chaining")
    void testFluentInterface() {
        Product product = standardBuilder
            .setName("Fluent Test")
            .setPrice(50.0)
            .setDescription("Testing fluent interface")
            .addTag("fluent")
            .addTag("test")
            .build();
        
        assertNotNull(product);
        assertEquals("Fluent Test", product.getName());
        assertEquals(50.0, product.getPrice(), 0.01);
        assertEquals("Testing fluent interface", product.getDescription());
        assertEquals(2, product.getTags().size());
        assertTrue(product.getTags().contains("fluent"));
        assertTrue(product.getTags().contains("test"));
    }
    
    @Test
    @DisplayName("Should create immutable products")
    void testProductImmutability() {
        Product product = standardBuilder
            .setName("Immutable Test")
            .setPrice(75.0)
            .setDescription("Testing immutability")
            .addTag("original")
            .build();
        
        var tags = product.getTags();
        tags.add("modified");
        
        var originalTags = product.getTags();
        assertEquals(1, originalTags.size());
        assertTrue(originalTags.contains("original"));
        assertFalse(originalTags.contains("modified"));
    }
    
    @Test
    @DisplayName("Should support builder reuse with reset")
    void testBuilderReuse() {
        Product product1 = standardBuilder
            .setName("Product 1")
            .setPrice(100.0)
            .setDescription("First product")
            .addTag("tag1")
            .build();
        
        Product product2 = standardBuilder
            .reset()
            .setName("Product 2")
            .setPrice(200.0)
            .setDescription("Second product")
            .addTag("tag2")
            .build();
        
        assertEquals("Product 1", product1.getName());
        assertEquals("Product 2", product2.getName());
        assertEquals(100.0, product1.getPrice(), 0.01);
        assertEquals(200.0, product2.getPrice(), 0.01);
        assertEquals("First product", product1.getDescription());
        assertEquals("Second product", product2.getDescription());
        assertTrue(product1.getTags().contains("tag1"));
        assertTrue(product2.getTags().contains("tag2"));
    }
    
    @Test
    @DisplayName("Should create basic product using director")
    void testDirectorBasicProduct() {
        Product product = director.createBasicProduct(
            new StandardProductBuilder(), 
            "Director Basic", 
            25.0
        );
        
        assertNotNull(product);
        assertEquals("Director Basic", product.getName());
        assertEquals(25.0, product.getPrice(), 0.01);
        assertEquals("Basic product description", product.getDescription());
    }
    
    @Test
    @DisplayName("Should create featured product using director")
    void testDirectorFeaturedProduct() {
        Product product = director.createFeaturedProduct(
            new StandardProductBuilder(),
            "Director Featured",
            150.0,
            "Custom featured description"
        );
        
        assertNotNull(product);
        assertEquals("Director Featured", product.getName());
        assertEquals(150.0, product.getPrice(), 0.01);
        assertEquals("Custom featured description", product.getDescription());
        assertTrue(product.getTags().contains("bestseller"));
        assertTrue(product.getTags().contains("featured"));
    }
    
    @Test
    @DisplayName("Should create gaming product using director")
    void testDirectorGamingProduct() {
        Product product = director.createGamingProduct(
            new StandardProductBuilder(),
            "Gaming Product",
            299.0,
            "Gaming description"
        );
        
        assertNotNull(product);
        assertEquals("Gaming Product", product.getName());
        assertEquals(299.0, product.getPrice(), 0.01);
        assertEquals("Gaming description", product.getDescription());
        assertTrue(product.getTags().contains("gaming"));
        assertTrue(product.getTags().contains("high-performance"));
        assertTrue(product.getTags().contains("rgb"));
    }
    
    @Test
    @DisplayName("Should create premium product using director")
    void testDirectorPremiumProduct() {
        Product product = director.createPremiumProduct(
            new PremiumProductBuilder(),
            "Premium Product",
            599.0,
            "Premium description"
        );
        
        assertNotNull(product);
        assertEquals("Premium Product", product.getName());
        assertEquals(599.0, product.getPrice(), 0.01);
        assertEquals("Premium description", product.getDescription());
        
        PremiumProduct premiumProduct = (PremiumProduct) product;
        assertEquals(36, premiumProduct.getWarrantyMonths());
        assertEquals("Premium", premiumProduct.getSupportLevel());
        assertTrue(premiumProduct.getTags().contains("premium"));
        assertTrue(premiumProduct.getTags().contains("professional"));
    }
    
    @Test
    @DisplayName("Should create business product using director")
    void testDirectorBusinessProduct() {
        Product product = director.createBusinessProduct(
            new StandardProductBuilder(),
            "Business Product",
            799.0,
            "Business description"
        );
        
        assertNotNull(product);
        assertEquals("Business Product", product.getName());
        assertEquals(799.0, product.getPrice(), 0.01);
        assertEquals("Business description", product.getDescription());
        assertTrue(product.getTags().contains("business"));
        assertTrue(product.getTags().contains("enterprise"));
        assertTrue(product.getTags().contains("productivity"));
    }
    
    @Test
    @DisplayName("Should handle premium builder reset correctly")
    void testPremiumBuilderReset() {
        Product product1 = premiumBuilder
            .setName("Premium 1")
            .setPrice(500.0)
            .setDescription("First premium product")
            .setWarrantyMonths(36)
            .setSupportLevel("Premium")
            .build();
        
        Product product2 = ((PremiumProductBuilder) premiumBuilder.reset())
            .setName("Premium 2")
            .setPrice(600.0)
            .setDescription("Second premium product")
            .build();
        
        PremiumProduct premium1 = (PremiumProduct) product1;
        PremiumProduct premium2 = (PremiumProduct) product2;
        
        assertEquals(36, premium1.getWarrantyMonths());
        assertEquals("Premium", premium1.getSupportLevel());
        
        assertEquals(12, premium2.getWarrantyMonths());
        assertEquals("Standard", premium2.getSupportLevel());
    }
    
    @Test
    @DisplayName("Should demonstrate complete builder pattern workflow")
    void testCompleteWorkflow() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🏗️ BUILDER PATTERN DEMONSTRATION");
        System.out.println("=".repeat(60));
        
        Product laptop = new StandardProductBuilder()
            .setName("Gaming Laptop Pro")
            .setPrice(1299.99)
            .setDescription("High-performance gaming laptop with RTX 4070")
            .addTag("gaming")
            .addTag("laptop")
            .addTag("high-performance")
            .build();
        
        Product premiumHeadset = director.createPremiumProduct(
            new PremiumProductBuilder(),
            "Professional Gaming Headset",
            299.99,
            "Premium gaming headset with 7.1 surround sound"
        );
        
        assertEquals("Gaming Laptop Pro", laptop.getName());
        assertEquals("Professional Gaming Headset", premiumHeadset.getName());
        assertEquals(1299.99, laptop.getPrice(), 0.01);
        assertEquals(299.99, premiumHeadset.getPrice(), 0.01);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ BUILDER PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }
} 