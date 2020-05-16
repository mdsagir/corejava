package com.greenjava.designpattern.chainofresponsiblity;

public abstract class Handler {

    protected Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract void handleRequest(Request request);
}
