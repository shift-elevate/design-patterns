package com.designpatterns.structural.facade;

import java.util.Arrays;
import java.util.List;

public class SyntaxHighlighter {
    
    public List<String> highlightFile(String filePath) {
        System.out.println("Applying syntax highlighting to: " + filePath);
        return Arrays.asList("public class Example {", "    // highlighted code", "}");
    }
}
