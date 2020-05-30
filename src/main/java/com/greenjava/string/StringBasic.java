package com.greenjava.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * String implements Comparable, Serializable, CharSequence
 * String is immutable not change, when change its create new immutable instance
 * String is a object its represent the sequence of character
 * Two way to create by literal and new Keyword
 * Two way to create by literal and new Keyword
 * 1) String literal
 * String s="Welcome"
 * When we create its checks inside JVM first its available the create refer to same reference
 * it not available then only created
 * String s1="Welcome" // not created another object
 * =>Advantages get more memory efficiency
 */
public class StringBasic {
    public static void main(String[] args) {

        //literals();
        //findMinMaxValueInArrays();
        //reverseString();
        //iterate();
        //stringBuffer();
        removeDuplicateString();
    }

    private static void removeDuplicateString() {
        String string = "Hello How are youu";

        boolean status=false;
        StringBuilder update = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        String[] split = string.split(" ");
        for (String s : split) {
            status=false;
            char[] chars = s.toCharArray();
            Stream<Character> stream = IntStream.range(0, chars.length).mapToObj(i -> chars[i]);
            stream.forEach(character -> map.put(character, map.containsKey(character) ? map.get(character) + 1 : 1));

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 2) {
                    status=true;
                    break;
                }
            }
            if (status==false) {
                Set<Character> characters = map.keySet();
                update.append(characters.toString());
            }
            System.out.println(update);
        }

    }

    private static void stringBuffer() {

        StringBuffer stringBuffer = new StringBuffer("Hello");
        stringBuffer.append("world");

        StringBuilder stringBuilder = new StringBuilder("String");
        stringBuilder.append("Builder");
        System.out.println(stringBuilder);
    }

    private static void iterate() {
        String s = "india is a great country";

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();


//        for (char c : chars) {
//            if (map.containsKey(c)) {
//                map.put(c, map.get(c) + 1);
//            } else {
//                map.put(c,1);
//            }
//        }
        Stream<Character> stream = IntStream.range(0, chars.length).mapToObj(value -> chars[value]);
        stream.forEach(c -> map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1));

        System.out.println(map);
    }

    private static void reverseString() {
        String s = "India is a great country";
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            System.out.print(aChar);
        }
        System.out.println();
        StringBuilder builder = new StringBuilder(s);
        StringBuilder reverse = builder.reverse();
        System.out.println(reverse);


    }

    private static void findMinMaxValueInArrays() {

        int array[] = {1, 4, 12, 0, 5};
        int big = 0;
        int small = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > big) {
                big = array[i];
            }
            if (array[i] < small) {
                small = array[i];
            }
        }
        System.out.println("Big no is " + big);
        System.out.println("Small no is " + small);


    }

    private static void literals() {
        String s = "Hello";
        String s1 = "Hello";
        s1.concat("World");
        System.out.println(s.hashCode());   //69609650
        System.out.println(s1.hashCode());  //69609650
    }

}
