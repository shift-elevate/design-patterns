package com.designpatterns.creational.builder.builders;

import com.designpatterns.creational.builder.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * ProductBuilder - Abstract builder class that defines the construction interface
 * This class provides fluent interface methods for building products step by step
 * Subclasses decide how to construct the final product
 */
public abstract class ProductBuilder {
    protected String name;
    protected double price;
    protected String description;
    protected List<String> tags = new ArrayList<>();
    
    // Fluent interface methods - each returns 'this' for method chaining
    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }
    
    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }
    
    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
    
    public ProductBuilder addTag(String tag) {
        this.tags.add(tag);
        return this;
    }
    
    // Abstract method - subclasses decide how to build the final product
    public abstract Product build();
    
    // Validation method - ensures required fields are set
    protected void validate() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Product name is required");
        }
        if (price < 0) {
            throw new IllegalStateException("Product price cannot be negative");
        }
    }
    
    // Reset method - allows builder reuse
    public ProductBuilder reset() {
        this.name = null;
        this.price = 0;
        this.description = null;
        this.tags = new ArrayList<>();
        return this;
    }
} 