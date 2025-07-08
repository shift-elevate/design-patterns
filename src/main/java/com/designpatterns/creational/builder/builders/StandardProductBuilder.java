package com.designpatterns.creational.builder.builders;

import com.designpatterns.creational.builder.Product;
import com.designpatterns.creational.builder.products.StandardProduct;

/**
 * StandardProductBuilder - Concrete builder for creating StandardProduct instances
 * This builder implements the abstract build() method to create standard products
 */
public class StandardProductBuilder extends ProductBuilder {
    
    @Override
    public Product build() {
        validate();
        return new StandardProduct(name, price, description, tags);
    }
} 