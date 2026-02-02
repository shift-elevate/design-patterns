package com.designpatterns.behavioural.chainofresponsibility;

public class ExpenseApprovalLauncher {

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("CHAIN OF RESPONSIBILITY - EXPENSE APPROVAL WORKFLOW");
        System.out.println("=".repeat(60));

        ExpenseApprover teamLead = new TeamLead();
        ExpenseApprover manager = new Manager();
        ExpenseApprover director = new Director();

        teamLead.setNextApprover(manager);
        manager.setNextApprover(director);

        buildAndProcessRequests(teamLead);

        System.out.println("\n" + "=".repeat(60));
        System.out.println("CHAIN OF RESPONSIBILITY DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }

    private static void buildAndProcessRequests(ExpenseApprover chain) {
        ExpenseRequest[] requests = {
                new ExpenseRequest("Alice", "Office supplies", 750.00, "SUPPLIES"),
                new ExpenseRequest("Bob", "Team building event", 2500.00, "ENTERTAINMENT"),
                new ExpenseRequest("Carol", "Conference registration", 4800.00, "TRAINING"),
                new ExpenseRequest("David", "Server infrastructure", 15000.00, "EQUIPMENT")
        };

        System.out.println("\n1. Building Approval Chain:");
        System.out.println("-".repeat(60));
        System.out.println("   Team Lead ($1,000) -> Manager ($5,000) -> Director (Unlimited)");

        System.out.println("\n2. Processing Expense Requests:");
        System.out.println("-".repeat(60));

        for (ExpenseRequest request : requests) {
            System.out.println("\nRequest: " + request);
            ApprovalResult result = chain.approve(request);
            System.out.println("Result: " + result);
        }
    }
}
