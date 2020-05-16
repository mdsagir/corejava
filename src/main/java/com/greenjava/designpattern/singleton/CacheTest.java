package com.greenjava.designpattern.singleton;

import java.util.Calendar;
import java.util.Objects;

public class CacheTest {

    public static void main(String[] args) {

        Cache cacheInstance = Cache.getInstance();
        Cache anotherInstance = Cache.getInstance();

        System.out.println(cacheInstance.hashCode());
        System.out.println(anotherInstance.hashCode());

        // Calender have no singleton class
        Calendar instance = Calendar.getInstance();


    }
}
