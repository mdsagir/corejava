package com.greenjava.stream;


import java.util.Arrays;
import java.util.List;

interface I {
    void say(String s, String s2);
}

public class MethodReferenceTest {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Hello", "Hi", "Bye");


        strings.stream()
                .map(ByCycle::new)
                .forEach(s -> System.out.println(s));
    }
}

class A {

    A() {
    }

    A(String param) {
        System.out.println("Constructor data: " + param);

    }

    public void process(String param, String n2) {
        System.out.println("param data. " + param + " " + n2);
        //return param;
    }
}

class ByCycle {
    private String name;

    public ByCycle(String name) {
        this.name = name;
    }

    public ByCycle() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ByCycle{" +
                "name='" + name + '\'' +
                '}';
    }
}
