package com.greenjava.preethi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class Test01 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " enter string ");
            String string = scanner.nextLine();
            list.add(string);
        }
        for (int i = 9; i > 0; i--) {
            System.out.println(" string " + list.get(i));
        }
    }
}
