package com.greenjava.lambda;

public class SumTest {

    public static void main(String[] args) {

        Sum<Integer, Integer> sum = (n1, n2) -> System.out.println("Sum " + (n1 + n2));
        Sum<Integer, Integer> sum2 = (n1, n2) -> System.out.println("Sum " + (n1 * n2));
//
//        sum.add(10, 20);
//        sum2.add(2,4);

        Sum<Integer, Integer> sum3 = (n1, n2) -> {
            sum.add(n1, n2);
            sum2.add(n1, n2);
        };

        Sum<Integer, Integer> sum4 = sum.addThen(null);
        sum3.add(2, 4);
    }
}
