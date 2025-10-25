package com.designpatterns.behavioural.state;

public class DraftState implements DocumentState {

    @Override
    public void edit(DocumentWorkflow document) {
        System.out.println("✏️ Editing document '" + document.getTitle() + "' in DRAFT state");
        document.setContent("Updated content in draft...");
    }

    @Override
    public void submitForApproval(DocumentWorkflow document) {
        System.out.println("✅ Submitting document '" + document.getTitle() + "' for approval");
        document.setState(new ApprovedState());
    }

    @Override
    public void releaseToPublic(DocumentWorkflow document) {
        System.out.println("❌ Cannot release document in DRAFT state. Must be approved first.");
    }

    @Override
    public String getStateName() {
        return "DRAFT";
    }
}
