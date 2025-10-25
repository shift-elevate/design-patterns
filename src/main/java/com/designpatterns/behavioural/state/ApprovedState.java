package com.designpatterns.behavioural.state;

public class ApprovedState implements DocumentState {

    @Override
    public void edit(DocumentWorkflow document) {
        System.out.println("❌ Cannot edit approved document. Create new version instead.");
    }

    @Override
    public void submitForApproval(DocumentWorkflow document) {
        System.out.println("✅ Document '" + document.getTitle() + "' is already approved");
    }

    @Override
    public void releaseToPublic(DocumentWorkflow document) {
        System.out.println("🚀 Releasing document '" + document.getTitle() + "' to public");
        document.setState(new PublishedState());
    }

    @Override
    public String getStateName() {
        return "APPROVED";
    }
}
