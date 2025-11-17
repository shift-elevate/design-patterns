package com.designpatterns.structural.facade;

import java.util.List;

public class CodeEditorClient {
    
    public static void main(String[] args) {
        System.out.println("=== Facade Pattern Demo: IDE Code Editor ===\n");
        
        EditorFacade editorFacade = new EditorFacade();
        
        System.out.println("1. Opening File with Facade:");
        System.out.println("-".repeat(60));
        
        EditorResult result = editorFacade.openFile("src/main/java/Example.java");
        
        System.out.println("File Result: " + result.getMessage());
        
        if (result.isSuccess()) {
            EditorState state = result.getState();
            System.out.println("Highlighted lines: " + state.getHighlightedLines().size());
            for (String line : state.getHighlightedLines()) {
                System.out.println("  " + line);
            }
            System.out.println("Code suggestions: " + state.getSuggestions().size());
        }
        System.out.println();
        
        System.out.println("\n2. Getting Code Suggestions:");
        System.out.println("-".repeat(60));
        
        List<String> suggestions = editorFacade.getCodeSuggestions("Example.java", 5, 10);
        System.out.println("Suggestions at line 5: " + suggestions.size());
        for (String suggestion : suggestions) {
            System.out.println("  - " + suggestion);
        }
        System.out.println();
        
        System.out.println("\n3. Setting Breakpoint:");
        System.out.println("-".repeat(60));
        
        editorFacade.setBreakpoint("Example.java", 15);
        System.out.println();
        
        System.out.println("\n4. Git Operations:");
        System.out.println("-".repeat(60));
        
        editorFacade.stageFile("Example.java");
        System.out.println();
        
        System.out.println("\n5. Continuing Debugging:");
        System.out.println("-".repeat(60));
        
        editorFacade.continueDebugging();
        System.out.println();
        
        System.out.println("\n6. Error Handling:");
        System.out.println("-".repeat(60));
        
        EditorResult errorResult = editorFacade.openFile("nonexistent/file.java");
        System.out.println("Error Result: " + errorResult.getMessage());
        System.out.println("Success: " + errorResult.isSuccess());
        System.out.println();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("FACADE PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }
}
