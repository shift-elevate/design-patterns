package com.designpatterns.creational.builder.products;

import com.designpatterns.creational.builder.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * PremiumProduct - Enhanced implementation of Product interface
 * This class represents a premium product with additional features
 * like warranty and premium support
 */
public class PremiumProduct implements Product {
    private final String name;
    private final double price;
    private final String description;
    private final List<String> tags;
    private final int warrantyMonths;
    private final String supportLevel;
    
    // Package-private constructor - only builders can create products
    public PremiumProduct(String name, double price, String description, 
                         List<String> tags, int warrantyMonths, String supportLevel) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.tags = new ArrayList<>(tags);
        this.warrantyMonths = warrantyMonths;
        this.supportLevel = supportLevel;
    }
    
    @Override
    public String getName() { 
        return name; 
    }
    
    @Override
    public double getPrice() { 
        return price; 
    }
    
    @Override
    public String getDescription() { 
        return description; 
    }
    
    @Override
    public List<String> getTags() { 
        return new ArrayList<>(tags); 
    }
    
    public int getWarrantyMonths() {
        return warrantyMonths;
    }
    
    public String getSupportLevel() {
        return supportLevel;
    }
} 