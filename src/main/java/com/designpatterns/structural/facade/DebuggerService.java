package com.designpatterns.structural.facade;

public class DebuggerService {
    
    public void startDebugging(String filePath) {
        System.out.println("Starting debugger for: " + filePath);
    }
    
    public void setBreakpoint(String filePath, int line) {
        System.out.println("Setting breakpoint at line " + line + " in " + filePath);
    }
    
    public void continueExecution() {
        System.out.println("Continuing debugger execution...");
    }
}
