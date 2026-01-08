package com.designpatterns.creational.builder;


public class ProductDirector {
    
    public Product createBasicProduct(ProductBuilder builder, String name, double price) {
        return builder
            .setName(name)
            .setPrice(price)
            .setDescription("Basic product description")
            .build();
    }
    
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