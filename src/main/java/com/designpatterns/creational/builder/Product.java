package com.designpatterns.creational.builder;

import java.util.List;

/**
 * Product interface - defines the contract for all products
 * This interface represents the common operations that all products must support
 */
public interface Product {
    String getName();
    double getPrice();
    String getDescription();
    List<String> getTags();
} 