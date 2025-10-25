package com.designpatterns.behavioural.state;

public class PublishedState implements DocumentState {

    @Override
    public void edit(DocumentWorkflow document) {
        System.out.println("❌ Cannot edit published document. Create new version instead.");
    }

    @Override
    public void submitForApproval(DocumentWorkflow document) {
        System.out.println("❌ Published document is already approved.");
    }

    @Override
    public void releaseToPublic(DocumentWorkflow document) {
        System.out.println("📖 Document '" + document.getTitle() + "' is already published");
    }

    @Override
    public String getStateName() {
        return "PUBLISHED";
    }
}
