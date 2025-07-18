package com.designpatterns.creational.builder.builders;

import com.designpatterns.creational.builder.Product;
import com.designpatterns.creational.builder.products.StandardProduct;

public class StandardProductBuilder extends ProductBuilder {
    
    @Override
    public Product build() {
        validate();
        return new StandardProduct(name, price, description, tags);
    }
} 