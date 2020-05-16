package com.greenjava.designpattern.prototype;

public class Movie extends Item {

    private String runTime;

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "runTime='" + runTime + '\'' +
                '}';
    }
}
