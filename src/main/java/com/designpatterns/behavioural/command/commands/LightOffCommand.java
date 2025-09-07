package com.designpatterns.behavioural.command.commands;

import com.designpatterns.behavioural.command.Command;
import com.designpatterns.behavioural.command.receivers.Light;

public class LightOffCommand implements Command {
    private Light light;
    private boolean wasOn;
    
    public LightOffCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        wasOn = light.isOn();
        light.turnOff();
    }
    
    @Override
    public void undo() {
        if (wasOn) {
            light.turnOn();
        }
    }
    
    @Override
    public void redo() {
        light.turnOff();
    }
}
