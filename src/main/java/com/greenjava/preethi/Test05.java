package com.greenjava.preethi;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test05 {
    static int count = 0;
    static List<Float> floats = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            try {
                input(scanner);
            } catch (InputMismatchException e) {
                if (count == 0) {
                    System.out.println("You entered non floating value please enter only floating value ");
                    input(new Scanner(System.in));
                } else {
                    sumOfFloats(floats);
                }
                count = 1;
            }
        }
        sumOfFloats(floats);
    }

    public static void sumOfFloats(List<Float> floats) {
        Double sumOfFloat = floats.stream()
                .collect(Collectors.summingDouble(Float::floatValue));
        System.out.println(sumOfFloat);

    }

    public static void input(Scanner scanner) throws InputMismatchException {

        System.out.println("Enter the floating value");
        float nextFloat = scanner.nextFloat();
        floats.add(nextFloat);

    }
}
