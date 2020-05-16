package com.greenjava.designpattern.togglecommand;

public class Light {

    private boolean isOn = false;

    public void toggle() {

        if (isOn) {
            off();
            isOn = false;
        } else {
            on();
            isOn = true;
        }
    }

    public void on() {
        System.out.println("Light switch on");
    }

    public void off() {
        System.out.println("Light switch off");
    }
}
