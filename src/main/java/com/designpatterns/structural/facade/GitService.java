package com.designpatterns.structural.facade;

public class GitService {
    
    public void getFileStatus(String filePath) {
        System.out.println("Checking git status for: " + filePath);
    }
    
    public boolean isGitRepository(String filePath) {
        return filePath.contains("src");
    }
    
    public void stageFile(String filePath) {
        System.out.println("Staging file: " + filePath);
    }
}
