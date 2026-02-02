package com.designpatterns.behavioural.chainofresponsibility;

public class Manager extends ExpenseApprover {

    public Manager() {
        super("Manager", 5000.00);
    }

    @Override
    protected ApprovalResult processApproval(ExpenseRequest request) {
        return new ApprovalResult(true, role, "Departmental budget");
    }
}
