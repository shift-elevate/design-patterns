package com.designpatterns.behavioural.chainofresponsibility;

public class ExpenseRequest {

    private String employeeName;
    private String description;
    private double amount;
    private String category;

    public ExpenseRequest(String employeeName, String description,
                         double amount, String category) {
        this.employeeName = employeeName;
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getEmployeeName() { return employeeName; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("%s - %s ($%.2f) [%s]",
                employeeName, description, amount, category);
    }
}
