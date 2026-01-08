package com.designpatterns.creational.builder;

import com.designpatterns.creational.builder.Product;

public class StandardProductBuilder extends ProductBuilder {
    
    @Override
    public Product build() {
        validate();
        return new StandardProduct(name, price, description, tags);
    }
} 