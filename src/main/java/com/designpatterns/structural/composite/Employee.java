package com.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    protected String name;
    protected String title;
    
    public Employee(String name, String title) {
        this.name = name;
        this.title = title;
    }
    
    public abstract void display(int level);
    public abstract void addSubordinate(Employee employee);
    public abstract void removeSubordinate(Employee employee);
    public abstract List<Employee> getSubordinates();
    
    public int getTeamSize() {
        int size = 1;
        for (Employee subordinate : this.getSubordinates()) {
            size += subordinate.getTeamSize();
        }
        return size;
    }
    
    public String getName() { 
        return name; 
    }
    
    public String getTitle() { 
        return title; 
    }
}
