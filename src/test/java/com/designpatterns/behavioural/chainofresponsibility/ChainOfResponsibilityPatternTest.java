package com.designpatterns.behavioural.chainofresponsibility;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ChainOfResponsibilityPatternTest {

    private TeamLead teamLead;
    private Manager manager;
    private Director director;

    @BeforeEach
    void setUp() {
        teamLead = new TeamLead();
        manager = new Manager();
        director = new Director();
    }

    @Test
    @DisplayName("ExpenseRequest - basic functionality and toString")
    void testExpenseRequestBasicFunctionality() {
        ExpenseRequest request = new ExpenseRequest("Alice", "Office supplies", 500.00, "SUPPLIES");

        assertEquals("Alice", request.getEmployeeName());
        assertEquals("Office supplies", request.getDescription());
        assertEquals(500.00, request.getAmount());
        assertEquals("SUPPLIES", request.getCategory());
        assertTrue(request.toString().contains("Alice"));
        assertTrue(request.toString().contains("500.00"));
        assertTrue(request.toString().contains("Office supplies"));
        assertTrue(request.toString().contains("SUPPLIES"));
    }

    @Test
    @DisplayName("ApprovalResult - approved result functionality and toString")
    void testApprovalResultApproved() {
        ApprovalResult result = new ApprovalResult(true, "Manager", "Departmental budget");

        assertTrue(result.isApproved());
        assertEquals("Manager", result.getApproverRole());
        assertEquals("Departmental budget", result.getMessage());
        assertTrue(result.toString().contains("Approved"));
        assertTrue(result.toString().contains("Manager"));
    }

    @Test
    @DisplayName("ApprovalResult - rejected result toString")
    void testApprovalResultRejected() {
        ApprovalResult result = new ApprovalResult(false, "Team Lead", "Exceeds maximum approval authority");

        assertFalse(result.isApproved());
        assertEquals("Team Lead", result.getApproverRole());
        assertTrue(result.toString().contains("Rejected"));
        assertTrue(result.toString().contains("Team Lead"));
    }

    @Test
    @DisplayName("TeamLead - approves expense within $1,000 limit")
    void testTeamLeadApprovesWithinLimit() {
        teamLead.setNextApprover(manager);
        ExpenseRequest request = new ExpenseRequest("Alice", "Office supplies", 500.00, "SUPPLIES");

        ApprovalResult result = teamLead.approve(request);

        assertTrue(result.isApproved());
        assertEquals("Team Lead", result.getApproverRole());
        assertEquals("Routine team expense", result.getMessage());
    }

    @Test
    @DisplayName("TeamLead - escalates expense beyond $1,000 limit")
    void testTeamLeadEscalatesBeyondLimit() {
        teamLead.setNextApprover(manager);
        manager.setNextApprover(director);
        ExpenseRequest request = new ExpenseRequest("Bob", "Conference", 1500.00, "TRAINING");

        ApprovalResult result = teamLead.approve(request);

        assertTrue(result.isApproved());
        assertEquals("Manager", result.getApproverRole());
    }

    @Test
    @DisplayName("Manager - approves expense within $5,000 limit")
    void testManagerApprovesWithinLimit() {
        manager.setNextApprover(director);
        ExpenseRequest request = new ExpenseRequest("Carol", "Team dinner", 3000.00, "ENTERTAINMENT");

        ApprovalResult result = manager.approve(request);

        assertTrue(result.isApproved());
        assertEquals("Manager", result.getApproverRole());
        assertEquals("Departmental budget", result.getMessage());
    }

    @Test
    @DisplayName("Manager - escalates expense beyond $5,000 limit")
    void testManagerEscalatesBeyondLimit() {
        manager.setNextApprover(director);
        ExpenseRequest request = new ExpenseRequest("Dave", "Server upgrade", 8000.00, "EQUIPMENT");

        ApprovalResult result = manager.approve(request);

        assertTrue(result.isApproved());
        assertEquals("Director", result.getApproverRole());
        assertEquals("Strategic initiative", result.getMessage());
    }

    @Test
    @DisplayName("Director - approves any amount")
    void testDirectorApprovesAnyAmount() {
        ExpenseRequest request = new ExpenseRequest("Eve", "Enterprise license", 50000.00, "SOFTWARE");

        ApprovalResult result = director.approve(request);

        assertTrue(result.isApproved());
        assertEquals("Director", result.getApproverRole());
        assertEquals("Strategic initiative", result.getMessage());
    }

    @Test
    @DisplayName("Chain traversal - request flows through full chain")
    void testFullChainTraversal() {
        teamLead.setNextApprover(manager);
        manager.setNextApprover(director);
        ExpenseRequest request = new ExpenseRequest("Frank", "Data center", 15000.00, "EQUIPMENT");

        ApprovalResult result = teamLead.approve(request);

        assertTrue(result.isApproved());
        assertEquals("Director", result.getApproverRole());
    }

    @Test
    @DisplayName("End of chain - rejection when no next approver and amount exceeds limit")
    void testEndOfChainRejection() {
        ExpenseRequest request = new ExpenseRequest("Grace", "Equipment", 1500.00, "HARDWARE");

        ApprovalResult result = teamLead.approve(request);

        assertFalse(result.isApproved());
        assertEquals("Team Lead", result.getApproverRole());
        assertEquals("Exceeds maximum approval authority", result.getMessage());
    }

    @Test
    @DisplayName("Partial chain - start from Manager directly")
    void testPartialChainFromManager() {
        manager.setNextApprover(director);
        ExpenseRequest request = new ExpenseRequest("Hank", "Software license", 2500.00, "SOFTWARE");

        ApprovalResult result = manager.approve(request);

        assertTrue(result.isApproved());
        assertEquals("Manager", result.getApproverRole());
    }

    @Test
    @DisplayName("Edge cases - exact boundary amounts ($1,000 and $5,000)")
    void testExactBoundaryAmounts() {
        teamLead.setNextApprover(manager);
        manager.setNextApprover(director);

        ExpenseRequest exactTeamLeadLimit = new ExpenseRequest("Ivy", "Supplies", 1000.00, "SUPPLIES");
        ApprovalResult result1 = teamLead.approve(exactTeamLeadLimit);
        assertTrue(result1.isApproved());
        assertEquals("Team Lead", result1.getApproverRole());

        ExpenseRequest exactManagerLimit = new ExpenseRequest("Jack", "Training", 5000.00, "TRAINING");
        ApprovalResult result2 = teamLead.approve(exactManagerLimit);
        assertTrue(result2.isApproved());
        assertEquals("Manager", result2.getApproverRole());
    }

    @Test
    @DisplayName("Demo: ExpenseApprovalLauncher runs without error")
    void testExpenseApprovalLauncher() {
        assertDoesNotThrow(() -> ExpenseApprovalLauncher.main(new String[]{}));
    }
}
