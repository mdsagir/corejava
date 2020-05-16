package com.greenjava.lambda;

import java.util.function.Function;

public class _FunctionTest {
    public static void main(String[] args) {
        _Function<Integer, String> function1 = integer -> String.valueOf(integer);
        _Function<String, Integer> function2 = string -> Integer.parseInt(string);

        _Function<Integer, Integer> integerInteger_function = function1.andThen(function2);

        Integer apply = integerInteger_function.apply(10);
        System.out.println(apply);

    }
}
