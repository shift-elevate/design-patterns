package com.designpatterns.behavioural.command;

import com.designpatterns.behavioural.command.commands.LightOnCommand;
import com.designpatterns.behavioural.command.commands.LightOffCommand;
import com.designpatterns.behavioural.command.commands.FanCommand;
import com.designpatterns.behavioural.command.receivers.Light;
import com.designpatterns.behavioural.command.receivers.Fan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class CommandPatternTest {
    
    private Light livingRoomLight;
    private Fan ceilingFan;
    private RemoteControl remote;
    
    @BeforeEach
    void setUp() {
        livingRoomLight = new Light("Living Room");
        ceilingFan = new Fan("Living Room");
        remote = new RemoteControl();
    }
    
    @Test
    @DisplayName("Light receiver - basic on/off functionality")
    void testLightBasicFunctionality() {
        System.out.println("\n=== Testing Light Basic Functionality ===");
        
        assertFalse(livingRoomLight.isOn());
        
        livingRoomLight.turnOn();
        assertTrue(livingRoomLight.isOn());
        
        livingRoomLight.turnOff();
        assertFalse(livingRoomLight.isOn());
        
        System.out.println("✓ Light basic functionality working correctly");
    }
    
    @Test
    @DisplayName("Fan receiver - speed control functionality")
    void testFanBasicFunctionality() {
        System.out.println("\n=== Testing Fan Basic Functionality ===");
        
        assertEquals(0, ceilingFan.getSpeed());
        
        ceilingFan.setSpeed(1);
        assertEquals(1, ceilingFan.getSpeed());
        
        ceilingFan.setSpeed(3);
        assertEquals(3, ceilingFan.getSpeed());
        
        ceilingFan.setSpeed(0);
        assertEquals(0, ceilingFan.getSpeed());
        
        ceilingFan.setSpeed(5); // Should be clamped to 3
        assertEquals(3, ceilingFan.getSpeed());
        
        ceilingFan.setSpeed(-1); // Should be clamped to 0
        assertEquals(0, ceilingFan.getSpeed());
        
        System.out.println("✓ Fan speed control working correctly");
    }
    
    @Test
    @DisplayName("LightOnCommand - execute and undo functionality")
    void testLightOnCommand() {
        System.out.println("\n=== Testing LightOnCommand ===");
        
        Command lightOnCommand = new LightOnCommand(livingRoomLight);
        
        assertFalse(livingRoomLight.isOn());
        
        lightOnCommand.execute();
        assertTrue(livingRoomLight.isOn());
        
        lightOnCommand.undo();
        assertFalse(livingRoomLight.isOn());
        
        lightOnCommand.redo();
        assertTrue(livingRoomLight.isOn());
        
        System.out.println("✓ LightOnCommand execute/undo/redo working correctly");
    }
    
    @Test
    @DisplayName("LightOffCommand - execute and undo functionality")
    void testLightOffCommand() {
        System.out.println("\n=== Testing LightOffCommand ===");
        
        Command lightOffCommand = new LightOffCommand(livingRoomLight);
        
        livingRoomLight.turnOn();
        assertTrue(livingRoomLight.isOn());
        
        lightOffCommand.execute();
        assertFalse(livingRoomLight.isOn());
        
        lightOffCommand.undo();
        assertTrue(livingRoomLight.isOn());
        
        lightOffCommand.redo();
        assertFalse(livingRoomLight.isOn());
        
        System.out.println("✓ LightOffCommand execute/undo/redo working correctly");
    }
    
    @Test
    @DisplayName("FanCommand - execute and undo functionality")
    void testFanCommand() {
        System.out.println("\n=== Testing FanCommand ===");
        
        Command fanHighCommand = new FanCommand(ceilingFan, 3);
        
        assertEquals(0, ceilingFan.getSpeed());
        
        fanHighCommand.execute();
        assertEquals(3, ceilingFan.getSpeed());
        
        fanHighCommand.undo();
        assertEquals(0, ceilingFan.getSpeed());
        
        fanHighCommand.redo();
        assertEquals(3, ceilingFan.getSpeed());
        
        System.out.println("✓ FanCommand execute/undo/redo working correctly");
    }
    
    @Test
    @DisplayName("RemoteControl - command assignment and execution")
    void testRemoteControlBasicFunctionality() {
        System.out.println("\n=== Testing RemoteControl Basic Functionality ===");
        
        Command lightOnCommand = new LightOnCommand(livingRoomLight);
        Command fanCommand = new FanCommand(ceilingFan, 2);
        
        remote.setCommand("1", lightOnCommand);
        remote.setCommand("2", fanCommand);
        
        assertEquals(2, remote.getButtonCount());
        assertTrue(remote.hasCommand("1"));
        assertTrue(remote.hasCommand("2"));
        assertFalse(remote.hasCommand("3"));
        
        remote.pressButton("1");
        assertTrue(livingRoomLight.isOn());
        
        remote.pressButton("2");
        assertEquals(2, ceilingFan.getSpeed());
        
        System.out.println("✓ RemoteControl basic functionality working correctly");
    }
    
    @Test
    @DisplayName("RemoteControl - undo and redo functionality")
    void testRemoteControlUndoRedo() {
        System.out.println("\n=== Testing RemoteControl Undo/Redo ===");
        
        Command lightOnCommand = new LightOnCommand(livingRoomLight);
        remote.setCommand("1", lightOnCommand);
        
        remote.pressButton("1");
        assertTrue(livingRoomLight.isOn());
        
        remote.undoLastCommand();
        assertFalse(livingRoomLight.isOn());
        
        remote.redoLastCommand();
        assertTrue(livingRoomLight.isOn());
        
        System.out.println("✓ RemoteControl undo/redo working correctly");
    }
    
    @Test
    @DisplayName("MacroCommand - execute multiple commands")
    void testMacroCommand() {
        System.out.println("\n=== Testing MacroCommand ===");
        
        Command lightOffCommand = new LightOffCommand(livingRoomLight);
        Command fanHighCommand = new FanCommand(ceilingFan, 3);
        
        livingRoomLight.turnOn();
        ceilingFan.setSpeed(0);
        
        List<Command> movieTimeCommands = Arrays.asList(lightOffCommand, fanHighCommand);
        MacroCommand movieTimeMacro = new MacroCommand(movieTimeCommands);
        
        assertEquals(2, movieTimeMacro.getCommandCount());
        
        movieTimeMacro.execute();
        assertFalse(livingRoomLight.isOn());
        assertEquals(3, ceilingFan.getSpeed());
        
        movieTimeMacro.undo();
        assertTrue(livingRoomLight.isOn());
        assertEquals(0, ceilingFan.getSpeed());
        
        movieTimeMacro.redo();
        assertFalse(livingRoomLight.isOn());
        assertEquals(3, ceilingFan.getSpeed());
        
        System.out.println("✓ MacroCommand working correctly");
    }
    
    @Test
    @DisplayName("Command Pattern Integration - full system test")
    void testCommandPatternIntegration() {
        System.out.println("\n=== Testing Command Pattern Integration ===");
        
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command fanHigh = new FanCommand(ceilingFan, 3);
        Command fanOff = new FanCommand(ceilingFan, 0);
        
        List<Command> movieTimeCommands = Arrays.asList(lightOff, fanHigh);
        Command movieTimeMacro = new MacroCommand(movieTimeCommands);
        
        remote.setCommand("1", lightOn);
        remote.setCommand("2", lightOff);
        remote.setCommand("3", fanHigh);
        remote.setCommand("4", fanOff);
        remote.setCommand("5", movieTimeMacro);
        
        remote.pressButton("1"); // Light on
        assertTrue(livingRoomLight.isOn());
        
        remote.pressButton("3"); // Fan high
        assertEquals(3, ceilingFan.getSpeed());
        
        remote.undoLastCommand(); // Undo fan
        assertEquals(0, ceilingFan.getSpeed());
        
        remote.pressButton("5"); // Movie time macro
        assertFalse(livingRoomLight.isOn());
        assertEquals(3, ceilingFan.getSpeed());
        
        remote.undoLastCommand(); // Undo macro
        assertTrue(livingRoomLight.isOn());
        assertEquals(0, ceilingFan.getSpeed());
        
        System.out.println("✓ Full Command Pattern integration working correctly");
    }
    
    @Test
    @DisplayName("Edge Cases - undo without commands, invalid buttons")
    void testEdgeCases() {
        System.out.println("\n=== Testing Edge Cases ===");
        
        assertDoesNotThrow(() -> remote.undoLastCommand());
        assertDoesNotThrow(() -> remote.redoLastCommand());
        
        assertDoesNotThrow(() -> remote.pressButton("999"));
        
        MacroCommand emptyMacro = new MacroCommand(Arrays.asList());
        assertEquals(0, emptyMacro.getCommandCount());
        assertDoesNotThrow(() -> emptyMacro.execute());
        assertDoesNotThrow(() -> emptyMacro.undo());
        assertDoesNotThrow(() -> emptyMacro.redo());
        
        System.out.println("✓ Edge cases handled correctly");
    }
    
    @Test
    @DisplayName("Demo: Command Pattern in Action")
    void testCommandPatternDemo() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🏠 COMMAND PATTERN DEMONSTRATION");
        System.out.println("=".repeat(60));
        System.out.println("This test demonstrates the Command pattern by showing how");
        System.out.println("it enables flexible control systems with undo/redo support.");
        System.out.println("=".repeat(60));
        
        SmartHomeLauncher.main(new String[]{});
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ COMMAND PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
        
        assertTrue(true, "Command Pattern demonstration completed successfully");
    }
}
