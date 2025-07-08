package com.designpatterns.creational.builder;

import com.designpatterns.creational.builder.builders.ProductBuilder;
import com.designpatterns.creational.builder.builders.PremiumProductBuilder;

/**
 * ProductDirector - Orchestrates the construction process for common product configurations
 * This class encapsulates the knowledge of how to build different types of products
 * using the builder pattern
 */
public class ProductDirector {
    
    /**
     * Creates a basic product with minimal configuration
     */
    public Product createBasicProduct(ProductBuilder builder, String name, double price) {
        return builder
            .setName(name)
            .setPrice(price)
            .setDescription("Basic product description")
            .build();
    }
    
    /**
     * Creates a featured product with enhanced visibility and marketing
     */
    public Product createFeaturedProduct(ProductBuilder builder, String name, 
                                       double price, String description) {
        return builder
            .setName(name)
            .setPrice(price)
            .setDescription(description)
            .addTag("bestseller")
            .addTag("featured")
            .build();
    }
    
    /**
     * Creates a gaming product with gaming-specific configuration
     */
    public Product createGamingProduct(ProductBuilder builder, String name, 
                                     double price, String description) {
        return builder
            .setName(name)
            .setPrice(price)
            .setDescription(description)
            .addTag("gaming")
            .addTag("high-performance")
            .addTag("rgb")
            .build();
    }
    
    /**
     * Creates a premium product with extended warranty and premium support
     * This method demonstrates working with specific builder types
     */
        public Product createPremiumProduct(PremiumProductBuilder builder, String name, 
                                       double price, String description) {
        return builder
            .setName(name)
            .setPrice(price)
            .setDescription(description)
            .addTag("premium")
            .addTag("professional")
            .setWarrantyMonths(36)
            .setSupportLevel("Premium")
            .build();
    }
    
    /**
     * Creates a business product optimized for enterprise use
     */
    public Product createBusinessProduct(ProductBuilder builder, String name, 
                                       double price, String description) {
        return builder
            .setName(name)
            .setPrice(price)
            .setDescription(description)
            .addTag("business")
            .addTag("enterprise")
            .addTag("productivity")
            .build();
    }
} 