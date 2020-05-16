package com.greenjava.lambda;

public class _PredicateTest {

    public static void main(String[] args) {

        _Predicate<Integer> predicate1=integer -> integer%2==0;
        _Predicate<Integer> predicate2=integer -> integer%2==0;


        _Predicate<Integer> and = predicate1.and(predicate2);
        System.out.println(and.test(12));

        System.out.println(predicate1.negate().test(10));

    }
}
