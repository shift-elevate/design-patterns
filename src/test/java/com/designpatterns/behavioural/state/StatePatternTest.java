package com.designpatterns.behavioural.state;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class StatePatternTest {

    private DocumentWorkflow document;

    @BeforeEach
    void setUp() {
        document = new DocumentWorkflow("Test Document", "Test Author");
    }

    @Test
    @DisplayName("DocumentWorkflow - basic functionality")
    void testDocumentWorkflowBasicFunctionality() {
        assertEquals("Test Document", document.getTitle());
        assertEquals("Test Author", document.getAuthor());
        assertEquals("DRAFT", document.getCurrentState());
        assertEquals("", document.getContent());
    }

    @Test
    @DisplayName("Draft State - edit functionality")
    void testDraftStateEdit() {
        assertEquals("DRAFT", document.getCurrentState());
        document.edit();
        assertEquals("Updated content in draft...", document.getContent());
    }

    @Test
    @DisplayName("State Transition - Draft to Approved")
    void testDraftToApprovedTransition() {
        assertEquals("DRAFT", document.getCurrentState());
        document.submitForApproval();
        assertEquals("APPROVED", document.getCurrentState());
    }

    @Test
    @DisplayName("State Transition - Approved to Published")
    void testApprovedToPublishedTransition() {
        document.submitForApproval();
        assertEquals("APPROVED", document.getCurrentState());

        document.releaseToPublic();
        assertEquals("PUBLISHED", document.getCurrentState());
    }

    @Test
    @DisplayName("Full State Lifecycle - Draft to Published")
    void testFullStateLifecycle() {
        assertEquals("DRAFT", document.getCurrentState());

        document.edit();
        assertEquals("Updated content in draft...", document.getContent());

        document.submitForApproval();
        assertEquals("APPROVED", document.getCurrentState());

        document.releaseToPublic();
        assertEquals("PUBLISHED", document.getCurrentState());
    }

    @Test
    @DisplayName("Invalid Transition - Draft to Published")
    void testInvalidDraftToPublishedTransition() {
        assertEquals("DRAFT", document.getCurrentState());
        document.releaseToPublic(); // Should not change state
        assertEquals("DRAFT", document.getCurrentState());
    }

    @Test
    @DisplayName("Invalid Operation - Edit Approved Document")
    void testEditApprovedDocument() {
        document.submitForApproval();
        assertEquals("APPROVED", document.getCurrentState());

        String contentBeforeEdit = document.getContent();
        document.edit(); // Should not allow editing
        assertEquals(contentBeforeEdit, document.getContent());
    }

    @Test
    @DisplayName("Invalid Operation - Edit Published Document")
    void testEditPublishedDocument() {
        document.submitForApproval();
        document.releaseToPublic();
        assertEquals("PUBLISHED", document.getCurrentState());

        String contentBeforeEdit = document.getContent();
        document.edit(); // Should not allow editing
        assertEquals(contentBeforeEdit, document.getContent());
    }

    @Test
    @DisplayName("Approved State - Already Approved")
    void testApprovedStateResubmit() {
        document.submitForApproval();
        assertEquals("APPROVED", document.getCurrentState());

        document.submitForApproval(); // Should remain approved
        assertEquals("APPROVED", document.getCurrentState());
    }

    @Test
    @DisplayName("Published State - Already Published")
    void testPublishedStateRerelease() {
        document.submitForApproval();
        document.releaseToPublic();
        assertEquals("PUBLISHED", document.getCurrentState());

        document.releaseToPublic(); // Should remain published
        assertEquals("PUBLISHED", document.getCurrentState());
    }

    @Test
    @DisplayName("Multiple Documents - Independent States")
    void testMultipleDocumentsIndependentStates() {
        DocumentWorkflow doc1 = new DocumentWorkflow("Document 1", "Author 1");
        DocumentWorkflow doc2 = new DocumentWorkflow("Document 2", "Author 2");
        DocumentWorkflow doc3 = new DocumentWorkflow("Document 3", "Author 3");

        doc1.submitForApproval();
        doc2.submitForApproval();
        doc2.releaseToPublic();

        assertEquals("APPROVED", doc1.getCurrentState());
        assertEquals("PUBLISHED", doc2.getCurrentState());
        assertEquals("DRAFT", doc3.getCurrentState());
    }

    @Test
    @DisplayName("State Names - Verify Correct Names")
    void testStateNames() {
        DraftState draftState = new DraftState();
        ApprovedState approvedState = new ApprovedState();
        PublishedState publishedState = new PublishedState();

        assertEquals("DRAFT", draftState.getStateName());
        assertEquals("APPROVED", approvedState.getStateName());
        assertEquals("PUBLISHED", publishedState.getStateName());
    }

    @Test
    @DisplayName("Demo: State Pattern in Action")
    void testStatePatternDemo() {
        DocumentWorkflowLauncher.main(new String[]{});
        assertTrue(true, "State Pattern demonstration completed successfully");
    }
}
