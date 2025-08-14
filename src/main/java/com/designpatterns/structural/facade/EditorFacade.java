package com.designpatterns.structural.facade;

import java.util.List;

public class EditorFacade {
    private SyntaxHighlighter syntaxHighlighter;
    private GitService gitService;
    private CodeCompletionService codeCompletionService;
    private DebuggerService debuggerService;
    
    public EditorFacade() {
        this.syntaxHighlighter = new SyntaxHighlighter();
        this.gitService = new GitService();
        this.codeCompletionService = new CodeCompletionService();
        this.debuggerService = new DebuggerService();
    }
    
    public EditorResult openFile(String filePath) {
        try {
            if (filePath == null || filePath.trim().isEmpty()) {
                return new EditorResult(false, "Failed to open file: File path cannot be null or empty");
            }
            
            List<String> highlightedLines = syntaxHighlighter.highlightFile(filePath);
            
            if (gitService.isGitRepository(filePath)) {
                gitService.getFileStatus(filePath);
            }
            
            List<String> suggestions = codeCompletionService.getSuggestions(filePath, 1, 1);
            debuggerService.startDebugging(filePath);
            
            return new EditorResult(true, "File opened successfully", 
                new EditorState(highlightedLines, suggestions));
            
        } catch (Exception e) {
            return new EditorResult(false, "Failed to open file: " + e.getMessage());
        }
    }
    
    public void setBreakpoint(String filePath, int line) {
        debuggerService.setBreakpoint(filePath, line);
    }
    
    public void continueDebugging() {
        debuggerService.continueExecution();
    }
    
    public List<String> getCodeSuggestions(String filePath, int line, int column) {
        return codeCompletionService.getSuggestions(filePath, line, column);
    }
    
    public void stageFile(String filePath) {
        if (gitService.isGitRepository(filePath)) {
            gitService.stageFile(filePath);
        }
    }
}
