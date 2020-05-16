package com.greenjava.generics;

import java.util.ArrayList;

public class MyCustomList<T> {

    ArrayList<T> list = new ArrayList<>();

    public void addElement(T e) {
        list.add(e);
    }

    public T getElement(int i){
        return list.get(i);
    }

    public void removeElement(T e) {
        list.remove(e);
    }
    public void display() {
        System.out.println(list);
    }
}
