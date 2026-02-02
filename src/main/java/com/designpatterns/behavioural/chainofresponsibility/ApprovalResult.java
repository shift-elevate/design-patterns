package com.designpatterns.behavioural.chainofresponsibility;

public class ApprovalResult {

    private boolean approved;
    private String approverRole;
    private String message;

    public ApprovalResult(boolean approved, String approverRole, String message) {
        this.approved = approved;
        this.approverRole = approverRole;
        this.message = message;
    }

    public boolean isApproved() { return approved; }
    public String getApproverRole() { return approverRole; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        String status = approved ? "Approved" : "Rejected";
        return String.format("%s by %s - %s", status, approverRole, message);
    }
}
