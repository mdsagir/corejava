package com.greenjava.datetime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        //arrays2();

        String s=null;

        boolean b= true && s!=null;
        System.out.println(b);

        //array();
    }

    private static void arrays2() {
        String[] data = {"hello", "world"};
        if (2==2){
            List<String> list= new ArrayList<>(Arrays.asList(data));
            list.add("apple");
            String[] array = list.stream().toArray(String[]::new);
            data=array;
            //System.out.println(Arrays.toString(array));

        }
        System.out.println(Arrays.toString(data));
    }

    public int getInt(){
        int j=20;
        System.out.println("number 20");
        return j;
    }

    private static void array() {
        int num = 3;
        String[] columnNames = null;
        if (num == 2) {

            columnNames = new String[]{"Campus/School", "Department", "Section",
                    "Course Title", "Instructor", "OER", "OER+", "Digital Available", "Not Using Materials"}; //First Day
            System.out.println(Arrays.toString(columnNames));
        } else {
            columnNames = new String[]{"Campus/School", "Department", "Section"}; //First Day
            System.out.println(Arrays.toString(columnNames));
        }
    }
}
