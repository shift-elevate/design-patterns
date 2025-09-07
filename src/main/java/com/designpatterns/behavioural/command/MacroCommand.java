package com.designpatterns.behavioural.command;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {
    private List<Command> commands;
    
    public MacroCommand(List<Command> commands) {
        this.commands = new ArrayList<>(commands);
    }
    
    @Override
    public void execute() {
        System.out.println("Executing macro command...");
        for (Command command : commands) {
            command.execute();
        }
    }
    
    @Override
    public void undo() {
        System.out.println("Undoing macro command...");
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
    
    @Override
    public void redo() {
        System.out.println("Redoing macro command...");
        for (Command command : commands) {
            command.redo();
        }
    }
    
    public int getCommandCount() {
        return commands.size();
    }
}
