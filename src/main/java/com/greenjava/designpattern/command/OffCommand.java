package com.greenjava.designpattern.command;

public class OffCommand implements Command{

    private Light light;

    public OffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
