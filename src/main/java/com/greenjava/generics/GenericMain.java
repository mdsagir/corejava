package com.greenjava.generics;

import java.util.*;

public class GenericMain {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int index=2;

        Integer integer = list.get((list.size()) - index);
        System.out.println(integer);




//        genericType();
//        genericExtendType();
    }

    private static void genericExtendType() {

        MyCustomExtend<Integer> intList = new MyCustomExtend<>();
        intList.addElement(12);
        intList.addElement(13);

        // MyCustomExtend<String> strList=new MyCustomExtend<>();
        // String is not sub type Number
        MyCustomExtend<Double> doubleList = new MyCustomExtend<>();
        MyCustomExtend<Byte> byteList = new MyCustomExtend<>();
        MyCustomExtend<Short> shortList = new MyCustomExtend<>();
        MyCustomExtend<Long> longList = new MyCustomExtend<>();
        MyCustomExtend<Float> floatList = new MyCustomExtend<>();


    }

    private static void genericType() {
        MyCustomList<String> stringList = new MyCustomList();

        stringList.addElement("Amar");
        stringList.addElement("Akbar");
        stringList.addElement("Anthony");
        System.out.println(stringList.getElement(1));
        stringList.display();

        MyCustomList<Integer> intList = new MyCustomList();
        intList.addElement(23);
        intList.display();
    }


}
