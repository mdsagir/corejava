package com.greenjava.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamHashMap {
    public static void main(String[] args) {

        //retriveMatch();
        //multiRetriveMatch();
        peekTest();
    }

    private static void retriveMatch() {

        Map<String, String> books = new HashMap<>();
        books.put(
                "978-0201633610", "Design patterns : elements of reusable object-oriented software");
        books.put(
                "978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
        books.put("978-0134685991", "Effective Java");

        Optional<String> first = books.entrySet().stream()
                .filter(e -> "Effective Java".equals(e.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        first.ifPresent(System.out::println);

    }

    private static void multiRetriveMatch() {

        Map<String, String> books = new HashMap<>();
        books.put(
                "978-0201633610", "Design patterns : elements of reusable object-oriented software");
        books.put(
                "978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
        books.put("978-0134685991", "Effective Java");
        books.put("978-0134685990", "Effective Java");

        List<String> list = books.entrySet().stream()
                .filter(e -> e.getValue().equals("Effective Java"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        List<String> collect = books.entrySet()
                .stream().filter(e -> e.getKey().startsWith("978-0"))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        System.out.println(collect);

    }

    private static void peekTest() {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

    }
}
