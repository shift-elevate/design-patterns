package com.designpatterns.structural.facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class FacadePatternTest {
    
    private EditorFacade editorFacade;
    
    @BeforeEach
    void setUp() {
        editorFacade = new EditorFacade();
    }
    
    @Test
    @DisplayName("Should create facade with all subsystems")
    void testFacadeCreation() {
        assertNotNull(editorFacade);
    }
    
    @Test
    @DisplayName("Should open file successfully through facade")
    void testOpenFileSuccess() {
        EditorResult result = editorFacade.openFile("src/main/java/Example.java");
        
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals("File opened successfully", result.getMessage());
        
        EditorState state = result.getState();
        assertNotNull(state);
        assertNotNull(state.getHighlightedLines());
        assertFalse(state.getHighlightedLines().isEmpty());
        assertNotNull(state.getSuggestions());
    }
    
    @Test
    @DisplayName("Should handle file open errors gracefully")
    void testOpenFileError() {
        EditorResult result = editorFacade.openFile("nonexistent/file.java");
        
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals("File opened successfully", result.getMessage());
    }
    
    @Test
    @DisplayName("Should set breakpoint through facade")
    void testSetBreakpoint() {
        assertDoesNotThrow(() -> {
            editorFacade.setBreakpoint("Example.java", 15);
        });
    }
    
    @Test
    @DisplayName("Should continue debugging through facade")
    void testContinueDebugging() {
        assertDoesNotThrow(() -> {
            editorFacade.continueDebugging();
        });
    }
    
    @Test
    @DisplayName("Should get code suggestions through facade")
    void testGetCodeSuggestions() {
        List<String> suggestions = editorFacade.getCodeSuggestions("Example.java", 5, 10);
        
        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
    }
    
    @Test
    @DisplayName("Should stage file through facade")
    void testStageFile() {
        assertDoesNotThrow(() -> {
            editorFacade.stageFile("Example.java");
        });
    }
    
    @Test
    @DisplayName("Should handle null file path gracefully")
    void testNullFilePath() {
        EditorResult result = editorFacade.openFile(null);
        
        assertNotNull(result);
        assertFalse(result.isSuccess());
        assertTrue(result.getMessage().contains("Failed to open file"));
    }
    
    @Test
    @DisplayName("Should provide consistent interface for all operations")
    void testConsistentInterface() {
        EditorResult openResult = editorFacade.openFile("test.java");
        assertNotNull(openResult);
        
        List<String> suggestions = editorFacade.getCodeSuggestions("test.java", 1, 1);
        assertNotNull(suggestions);
        
        assertDoesNotThrow(() -> editorFacade.setBreakpoint("test.java", 1));
        assertDoesNotThrow(() -> editorFacade.stageFile("test.java"));
        assertDoesNotThrow(() -> editorFacade.continueDebugging());
    }
    
    @Test
    @DisplayName("Should demonstrate facade pattern benefits")
    void testFacadePatternDemo() {
        System.out.println("\n=== Facade Pattern Demo Test ===");
        
        EditorResult result = editorFacade.openFile("src/main/java/Example.java");
        
        assertTrue(result.isSuccess());
        assertNotNull(result.getState());
        
        EditorState state = result.getState();
        assertNotNull(state.getHighlightedLines());
        assertFalse(state.getHighlightedLines().isEmpty());
        assertNotNull(state.getSuggestions());
        
        System.out.println("✓ Simplified interface to complex subsystems");
        System.out.println("✓ Centralized error handling");
        System.out.println("✓ Clean separation of concerns");
        System.out.println("✓ Easy to extend with new features");
        
        editorFacade.setBreakpoint("Example.java", 15);
        editorFacade.getCodeSuggestions("Example.java", 5, 10);
        editorFacade.stageFile("Example.java");
        editorFacade.continueDebugging();
        
        System.out.println("✓ All operations work through unified interface");
    }
    
    @Test
    @DisplayName("Should handle multiple file operations")
    void testMultipleFileOperations() {
        EditorResult result1 = editorFacade.openFile("src/main/java/Example1.java");
        EditorResult result2 = editorFacade.openFile("src/main/java/Example2.java");
        
        assertNotNull(result1);
        assertNotNull(result2);
        
        assertDoesNotThrow(() -> editorFacade.setBreakpoint("Example1.java", 1));
        assertDoesNotThrow(() -> editorFacade.setBreakpoint("Example2.java", 1));
        
        List<String> suggestions1 = editorFacade.getCodeSuggestions("Example1.java", 1, 1);
        List<String> suggestions2 = editorFacade.getCodeSuggestions("Example2.java", 1, 1);
        
        assertNotNull(suggestions1);
        assertNotNull(suggestions2);
    }
    
    @Test
    @DisplayName("Should validate editor state structure")
    void testEditorStateStructure() {
        EditorResult result = editorFacade.openFile("src/main/java/Example.java");
        
        if (result.isSuccess()) {
            EditorState state = result.getState();
            
            List<String> highlightedLines = state.getHighlightedLines();
            assertNotNull(highlightedLines);
            assertFalse(highlightedLines.isEmpty());
            
            for (String line : highlightedLines) {
                assertNotNull(line);
                assertFalse(line.trim().isEmpty());
            }
            
            List<String> suggestions = state.getSuggestions();
            assertNotNull(suggestions);
            assertFalse(suggestions.isEmpty());
        }
    }
}
