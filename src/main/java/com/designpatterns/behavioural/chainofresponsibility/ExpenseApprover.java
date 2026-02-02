package com.designpatterns.behavioural.chainofresponsibility;

public abstract class ExpenseApprover {

    protected ExpenseApprover nextApprover;
    protected double approvalLimit;
    protected String role;

    public ExpenseApprover(String role, double approvalLimit) {
        this.role = role;
        this.approvalLimit = approvalLimit;
    }

    public void setNextApprover(ExpenseApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    public String getApproverRole() {
        return role;
    }

    public ApprovalResult approve(ExpenseRequest request) {
        if (canApprove(request)) {
            return processApproval(request);
        } else if (nextApprover != null) {
            System.out.println(role + " escalating to " + nextApprover.getApproverRole());
            return nextApprover.approve(request);
        } else {
            return new ApprovalResult(false, role, "Exceeds maximum approval authority");
        }
    }

    protected boolean canApprove(ExpenseRequest request) {
        return request.getAmount() <= approvalLimit;
    }

    protected abstract ApprovalResult processApproval(ExpenseRequest request);
}
