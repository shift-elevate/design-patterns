package com.designpatterns.structural.facade;

import java.util.Arrays;
import java.util.List;

public class CodeCompletionService {
    
    public List<String> getSuggestions(String filePath, int line, int column) {
        System.out.println("Getting code completion suggestions...");
        return Arrays.asList("public", "class", "method");
    }
}
