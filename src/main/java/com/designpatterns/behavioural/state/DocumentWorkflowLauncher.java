package com.designpatterns.behavioural.state;

public class DocumentWorkflowLauncher {

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("STATE PATTERN - DOCUMENT WORKFLOW MANAGEMENT");
        System.out.println("=".repeat(60));

        DocumentWorkflow document = new DocumentWorkflow("Design Patterns Guide", "John Doe");

        System.out.println("\n1. Draft State Operations:");
        System.out.println("-".repeat(60));
        document.edit();
        document.edit();

        System.out.println("\n2. Transitioning to Approval State:");
        System.out.println("-".repeat(60));
        document.submitForApproval();
        document.edit();

        System.out.println("\n3. Transitioning to Published State:");
        System.out.println("-".repeat(60));
        document.releaseToPublic();
        document.edit();

        System.out.println("\n4. Checking Document Status:");
        System.out.println("-".repeat(60));
        System.out.println("Current State: " + document.getCurrentState());

        System.out.println("\n5. Testing Invalid State Transitions:");
        System.out.println("-".repeat(60));
        DocumentWorkflow newDoc = new DocumentWorkflow("Another Doc", "Jane Smith");
        newDoc.releaseToPublic();

        System.out.println("\n" + "=".repeat(60));
        System.out.println("STATE PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }
}
