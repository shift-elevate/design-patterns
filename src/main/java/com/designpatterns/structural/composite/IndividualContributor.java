package com.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class IndividualContributor extends Employee {
    
    public IndividualContributor(String name, String title) {
        super(name, title);
    }
    
    @Override
    public void display(int level) {
        String indent = "  ".repeat(level);
        System.out.println(indent + "👤 " + name + " (" + title + ")");
    }
    
    @Override
    public void addSubordinate(Employee employee) {
        throw new UnsupportedOperationException("Individual contributors cannot have subordinates");
    }
    
    @Override
    public void removeSubordinate(Employee employee) {
        throw new UnsupportedOperationException("Individual contributors cannot have subordinates");
    }
    
    @Override
    public List<Employee> getSubordinates() {
        return new ArrayList<>();
    }
}
