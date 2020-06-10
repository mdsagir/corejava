package com.greenjava.garbage;

import com.greenjava.designpattern.command.Main;

// compare with c++
// example nullifying assigning or anonymous class
// thread daemon
// memory works

public class MainTest {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Hello");
    }

    public static void main(String[] args) {

        A a=new A();
        a=null;
        System.gc();
    }
}
class A {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("A ");
    }
}
