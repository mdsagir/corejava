package com.greenjava.designpattern.command;

public class Main {

    public static void main(String[] args) {

        Light light = new Light();
        Command onCommand = new OnCommand(light);
        Command offCommand = new OffCommand(light);


        Switch lightSwitch = new Switch();
        lightSwitch.storeAndExecute(offCommand);

    }
}
