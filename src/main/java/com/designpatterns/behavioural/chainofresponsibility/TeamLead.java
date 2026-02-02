package com.designpatterns.behavioural.chainofresponsibility;

public class TeamLead extends ExpenseApprover {

    public TeamLead() {
        super("Team Lead", 1000.00);
    }

    @Override
    protected ApprovalResult processApproval(ExpenseRequest request) {
        return new ApprovalResult(true, role, "Routine team expense");
    }
}
