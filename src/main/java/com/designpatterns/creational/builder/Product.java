package com.designpatterns.creational.builder;

import java.util.List;

public interface Product {
    String getName();
    double getPrice();
    String getDescription();
    List<String> getTags();
} 