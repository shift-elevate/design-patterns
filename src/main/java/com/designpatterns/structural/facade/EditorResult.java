package com.designpatterns.structural.facade;

public class EditorResult {
    private boolean success;
    private String message;
    private EditorState state;
    
    public EditorResult(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.state = null;
    }
    
    public EditorResult(boolean success, String message, EditorState state) {
        this.success = success;
        this.message = message;
        this.state = state;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public String getMessage() {
        return message;
    }
    
    public EditorState getState() {
        return state;
    }
}
