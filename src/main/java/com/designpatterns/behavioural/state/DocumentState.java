package com.designpatterns.behavioural.state;

public interface DocumentState {
    void edit(DocumentWorkflow document);
    void submitForApproval(DocumentWorkflow document);
    void releaseToPublic(DocumentWorkflow document);
    String getStateName();
}
