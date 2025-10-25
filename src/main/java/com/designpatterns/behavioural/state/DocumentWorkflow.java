package com.designpatterns.behavioural.state;

public class DocumentWorkflow {
    private DocumentState currentState;
    private String title;
    private String content;
    private String author;

    public DocumentWorkflow(String title, String author) {
        this.title = title;
        this.author = author;
        this.content = "";
        this.currentState = new DraftState();

        System.out.println("Document '" + title + "' created in DRAFT state");
    }

    public void edit() {
        currentState.edit(this);
    }

    public void submitForApproval() {
        currentState.submitForApproval(this);
    }

    public void releaseToPublic() {
        currentState.releaseToPublic(this);
    }

    public void setState(DocumentState state) {
        System.out.println("Document '" + title + "' transitioning from " +
            currentState.getStateName() + " to " + state.getStateName());
        this.currentState = state;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getCurrentState() {
        return currentState.getStateName();
    }

    public DocumentState getCurrentStateObject() {
        return currentState;
    }
}
