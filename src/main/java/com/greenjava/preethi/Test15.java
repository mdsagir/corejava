package com.greenjava.preethi;

import java.util.Scanner;

public class Test15 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        printMessage();
        while (scanner.hasNextLine()) {

            switch (i) {
                case 1:
                    addStudent();
                    printMessage();
                case 2:
                    modifying();
                    printMessage();
                case 3:
                    System.exit(0);
            }

            System.out.println("Enter the text");
            String s = scanner.nextLine();
            System.out.println(s);

        }

    }

    public static void addStudent() {
        System.out.println("Adding ");
    }

    public static void modifying() {
        System.out.println("Modifying");
    }

    public static void printMessage() {
        System.out.println("1 Add student");
        System.out.println("2 Modify grade");
        System.out.println("3 Display");
        System.out.println("4 Exit");

    }
}
