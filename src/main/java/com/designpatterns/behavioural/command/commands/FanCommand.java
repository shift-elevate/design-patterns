package com.designpatterns.behavioural.command.commands;

import com.designpatterns.behavioural.command.Command;
import com.designpatterns.behavioural.command.receivers.Fan;

public class FanCommand implements Command {
    private Fan fan;
    private int previousSpeed;
    private int newSpeed;
    
    public FanCommand(Fan fan, int newSpeed) {
        this.fan = fan;
        this.newSpeed = newSpeed;
    }
    
    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        fan.setSpeed(newSpeed);
    }
    
    @Override
    public void undo() {
        fan.setSpeed(previousSpeed);
    }
    
    @Override
    public void redo() {
        fan.setSpeed(newSpeed);
    }
}
