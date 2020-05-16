package com.greenjava.designpattern.command;

// invoker
public class Switch {

    public void storeAndExecute(Command command) {
        command.execute();
    }
}
