package com.designpatterns.structural.facade;

import java.util.List;

public class EditorState {
    private List<String> highlightedLines;
    private List<String> suggestions;
    
    public EditorState(List<String> highlightedLines) {
        this.highlightedLines = highlightedLines;
        this.suggestions = null;
    }
    
    public EditorState(List<String> highlightedLines, List<String> suggestions) {
        this.highlightedLines = highlightedLines;
        this.suggestions = suggestions;
    }
    
    public List<String> getHighlightedLines() {
        return highlightedLines;
    }
    
    public List<String> getSuggestions() {
        return suggestions;
    }
}
