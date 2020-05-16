package com.greenjava.designpattern.togglecommand;

public class Switch {
    public void storeAndExecute(Command command) {
        command.execute();

    }
}
