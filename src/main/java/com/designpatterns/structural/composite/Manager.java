package com.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    private List<Employee> subordinates = new ArrayList<>();
    
    public Manager(String name, String title) {
        super(name, title);
    }
    
    @Override
    public void display(int level) {
        String indent = "  ".repeat(level);
        System.out.println(indent + "👔 " + name + " (" + title + ") [Team: " + getTeamSize() + "]");
        for (Employee subordinate : subordinates) {
            subordinate.display(level + 1);
        }
    }
    
    @Override
    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }
    
    @Override
    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
    }
    
    @Override
    public List<Employee> getSubordinates() {
        return new ArrayList<>(subordinates);
    }
}
