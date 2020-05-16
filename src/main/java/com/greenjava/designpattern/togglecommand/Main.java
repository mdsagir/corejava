package com.greenjava.designpattern.togglecommand;

public class Main {

    public static void main(String[] args) {
        Light light = new Light();
        Switch aSwitch = new Switch();

        Command command = new ToggleCommand(light);
        aSwitch.storeAndExecute(command);
        aSwitch.storeAndExecute(command);
        aSwitch.storeAndExecute(command);
        aSwitch.storeAndExecute(command);
        aSwitch.storeAndExecute(command);
    }
}
