package com.greenjava.designpattern.chainofresponsiblity;

import static com.greenjava.designpattern.chainofresponsiblity.RequestType.CONFERENCE;
import static com.greenjava.designpattern.chainofresponsiblity.RequestType.PURCHASE;

public class Main {

    public static void main(String[] args) {

        Director bryan = new Director();
        VP crystal =new VP();
        CEO jeff=new CEO();

        bryan.setHandler(crystal);
        crystal.setHandler(jeff);

        Request request=new Request(CONFERENCE,500);
        bryan.handleRequest(request);

        request=new Request(PURCHASE,1000);
        bryan.handleRequest(request);

        request=new Request(PURCHASE,2000);
        bryan.handleRequest(request);
    }
}

