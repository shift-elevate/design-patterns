package com.designpatterns.behavioural.command;

import java.util.HashMap;
import java.util.Map;

public class RemoteControl {
    private Map<String, Command> commands;
    private Command lastCommand;
    
    public RemoteControl() {
        commands = new HashMap<>();
    }
    
    public void setCommand(String button, Command command) {
        commands.put(button, command);
    }
    
    public void pressButton(String button) {
        Command command = commands.get(button);
        if (command != null) {
            command.execute();
            lastCommand = command;
        } else {
            System.out.println("No command assigned to button: " + button);
        }
    }
    
    public void undoLastCommand() {
        if (lastCommand != null) {
            System.out.println("Undoing last command...");
            lastCommand.undo();
        } else {
            System.out.println("No commands to undo");
        }
    }
    
    public void redoLastCommand() {
        if (lastCommand != null) {
            System.out.println("Redoing last command...");
            lastCommand.redo();
        } else {
            System.out.println("No commands to redo");
        }
    }
    
    public int getButtonCount() {
        return commands.size();
    }
    
    public boolean hasCommand(String button) {
        return commands.containsKey(button);
    }
}
