package com.greenjava.generics;

import java.util.ArrayList;
import java.util.List;

public class MyCustomExtend<T extends Number> {

    List<T> list = new ArrayList<>();

    public void addElement(T e) {

        list.add(e);
    }

    public T getElement(int i) {
        return list.get(i);
    }
    public void show(){
        System.out.println(list);
    }
}
