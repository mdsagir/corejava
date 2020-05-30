package com.greenjava.preethi;

import com.sun.prism.paint.Color;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test13 {
    public static void main(String[] args) {

        Set<Color> colors = new HashSet<>();
        colors.add(Color.BLUE);
        colors.add(Color.WHITE);
        colors.add(Color.BLACK);
        colors.add(Color.GREEN);
        colors.add(Color.RED);
        colors.add(Color.TRANSPARENT);

        System.out.println("Enter the number ");
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();



        System.out.println(Color.BLUE.getAlpha());
        System.out.println(Color.RED.getBluePremult());
        for (Color c:colors){
           System.out.println(c);
       }

    }
}
