package com.designpatterns.creational.builder;

import com.designpatterns.creational.builder.Product;
import java.util.ArrayList;
import java.util.List;

public abstract class ProductBuilder {
    protected String name;
    protected double price;
    protected String description;
    protected List<String> tags = new ArrayList<>();
    
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
    
    public abstract Product build();
    
    protected void validate() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Product name is required");
        }
        if (price < 0) {
            throw new IllegalStateException("Product price cannot be negative");
        }
    }
    
    public ProductBuilder reset() {
        this.name = null;
        this.price = 0;
        this.description = null;
        this.tags = new ArrayList<>();
        return this;
    }
} 