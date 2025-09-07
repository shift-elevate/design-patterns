package com.designpatterns.behavioural.command.commands;

import com.designpatterns.behavioural.command.Command;
import com.designpatterns.behavioural.command.receivers.Light;

public class LightOnCommand implements Command {
    private Light light;
    private boolean wasOn;
    
    public LightOnCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        wasOn = light.isOn();
        light.turnOn();
    }
    
    @Override
    public void undo() {
        if (!wasOn) {
            light.turnOff();
        }
    }
    
    @Override
    public void redo() {
        light.turnOn();
    }
}
