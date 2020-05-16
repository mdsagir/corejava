package com.greenjava.designpattern.singleton;

public class RuntimeSingleton {

    public static void main(String[] args) {

        //javaSingleton();
        DBSingleton instance = DBSingleton.getInstance();
        DBSingleton dbInstance = DBSingleton.getInstance();
        System.out.println(instance);
        System.out.println(dbInstance);


    }

    private static void javaSingleton() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        System.out.println(runtime);
        Runtime anotherRuntime = Runtime.getRuntime();
        System.out.println(anotherRuntime);
    }
}
