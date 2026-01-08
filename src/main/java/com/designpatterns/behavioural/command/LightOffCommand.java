package com.designpatterns.behavioural.command;

import com.designpatterns.behavioural.command.Command;

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
