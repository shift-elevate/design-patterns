package com.designpatterns.behavioural.chainofresponsibility;

public class Director extends ExpenseApprover {

    public Director() {
        super("Director", Double.MAX_VALUE);
    }

    @Override
    protected ApprovalResult processApproval(ExpenseRequest request) {
        return new ApprovalResult(true, role, "Strategic initiative");
    }
}
