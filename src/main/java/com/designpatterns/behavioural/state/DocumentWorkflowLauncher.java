package com.designpatterns.behavioural.state;

public class DocumentWorkflowLauncher {

    public static void main(String[] args) {
        System.out.println("=== Document Workflow State Pattern Demo ===\n");

        DocumentWorkflow document = new DocumentWorkflow("Design Patterns Guide", "John Doe");

        System.out.println("\n=== Phase 1: Draft Phase ===");
        document.edit();
        document.edit();

        System.out.println("\n=== Phase 2: Approval ===");
        document.submitForApproval();
        document.edit();

        System.out.println("\n=== Phase 3: Publishing ===");
        document.releaseToPublic();
        document.edit();

        System.out.println("\n=== Document Status ===");
        System.out.println("Current State: " + document.getCurrentState());

        System.out.println("\n=== Testing Invalid Transitions ===");
        DocumentWorkflow newDoc = new DocumentWorkflow("Another Doc", "Jane Smith");
        newDoc.releaseToPublic();
    }
}
