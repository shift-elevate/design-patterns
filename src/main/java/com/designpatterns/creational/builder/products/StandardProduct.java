package com.designpatterns.creational.builder.products;

import com.designpatterns.creational.builder.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * StandardProduct - Concrete implementation of Product interface
 * This class represents a standard product with all the common attributes
 * Uses package-private constructor to ensure only builders can create instances
 */
public class StandardProduct implements Product {
    private final String name;
    private final double price;
    private final String description;
    private final List<String> tags;
    
    // Package-private constructor - only builders can create products
    public StandardProduct(String name, double price, String description, List<String> tags) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.tags = new ArrayList<>(tags);
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
} 