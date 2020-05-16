package com.greenjava.designpattern.singleton;

public class Cache {

    private static volatile Cache instance = null;

    private Cache() {
        if (instance != null) {
            throw new IllegalArgumentException("use getInstance method to create instance");
        }
    }

    public static Cache getInstance() {

        if (instance == null) {
            synchronized (Cache.class) {
                if (instance == null) {
                    instance = new Cache();
                }
            }
        }
        return instance;
    }


}
