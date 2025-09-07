package com.designpatterns.behavioural.command;

import com.designpatterns.behavioural.command.commands.LightOnCommand;
import com.designpatterns.behavioural.command.commands.LightOffCommand;
import com.designpatterns.behavioural.command.commands.FanCommand;
import com.designpatterns.behavioural.command.receivers.Light;
import com.designpatterns.behavioural.command.receivers.Fan;

import java.util.Arrays;
import java.util.List;

public class SmartHomeLauncher {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("🏠 SMART HOME AUTOMATION - COMMAND PATTERN DEMO");
        System.out.println("=".repeat(60));
        
        Light livingRoomLight = new Light("Living Room");
        Fan ceilingFan = new Fan("Living Room");
        
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command fanHigh = new FanCommand(ceilingFan, 3);
        Command fanOff = new FanCommand(ceilingFan, 0);
        
        List<Command> movieTimeCommands = Arrays.asList(lightOff, fanHigh);
        Command movieTimeMacro = new MacroCommand(movieTimeCommands);
        
        RemoteControl remote = new RemoteControl();
        remote.setCommand("1", lightOn);
        remote.setCommand("2", lightOff);
        remote.setCommand("3", fanHigh);
        remote.setCommand("4", fanOff);
        remote.setCommand("5", movieTimeMacro);
        
        demonstrateBasicCommands(remote);
        demonstrateUndoRedo(remote);
        demonstrateMacroCommand(remote);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ COMMAND PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }
    
    private static void demonstrateBasicCommands(RemoteControl remote) {
        System.out.println("\n📱 BASIC COMMANDS DEMONSTRATION");
        System.out.println("-".repeat(40));
        
        System.out.println("\n1. Turn on light:");
        remote.pressButton("1");
        
        System.out.println("\n2. Turn on fan:");
        remote.pressButton("3");
        
        System.out.println("\n3. Turn off light:");
        remote.pressButton("2");
    }
    
    private static void demonstrateUndoRedo(RemoteControl remote) {
        System.out.println("\n🔄 UNDO/REDO DEMONSTRATION");
        System.out.println("-".repeat(40));
        
        System.out.println("\n4. Undo last command (should turn light back on):");
        remote.undoLastCommand();
        
        System.out.println("\n5. Redo last command (should turn light back off):");
        remote.redoLastCommand();
    }
    
    private static void demonstrateMacroCommand(RemoteControl remote) {
        System.out.println("\n🎬 MACRO COMMAND DEMONSTRATION");
        System.out.println("-".repeat(40));
        
        System.out.println("\n6. Execute 'Movie Time' macro (turn off light + turn on fan):");
        remote.pressButton("5");
        
        System.out.println("\n7. Undo macro command (should reverse both operations):");
        remote.undoLastCommand();
        
        System.out.println("\n8. Redo macro command (should execute both operations again):");
        remote.redoLastCommand();
    }
}
