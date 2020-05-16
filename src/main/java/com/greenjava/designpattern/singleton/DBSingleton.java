package com.greenjava.designpattern.singleton;

public class DBSingleton {


    private static volatile DBSingleton dbSingleton=new DBSingleton();
    private DBSingleton() {}

    public static DBSingleton getInstance(){
        return dbSingleton;
    }
}
