package com.designpatterns.behavioural.command;

public interface Command {
    void execute();
    void undo();
    void redo();
}
