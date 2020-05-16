package com.greenjava.lambda;

import java.util.function.Consumer;

public class _ConsumerTest {

    public static void main(String[] args) {

        _Consumer<String> s1=s -> System.out.println("s1 "+s);
        _Consumer<String> s2=s -> System.out.println("s1 "+s);

        _Consumer<String> s3=s -> {
            s1.accept(s);
            s2.accept(s);
        };
        //s3.accept("hello");


        _Consumer<String> s4=s1.andThen(s2);
        _Consumer<String> s5=s1.andThen(null);

        s4.accept("andThen test");
        //s5.accept("null");

    }
}
