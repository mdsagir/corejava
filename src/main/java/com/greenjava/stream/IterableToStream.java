package com.greenjava.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IterableToStream {

    public static void main(String[] args) {

        //testStream();
        //reduceTest();
        //convertStringToStream();
        //stringHasAlreadyBeenOperatedUponOrClose();
        infiniteIterator();

    }

    private static void infiniteIterator() {
        Stream<Integer> iterate = Stream.iterate(0, i -> i + 2);
        iterate.limit(10).forEach(System.out::println);
        // stream run into 10 time because lazy loading

        int i = 0;
        while (i < 10) {
            System.out.println("# " + i);
            i++;
        }
        Stream.iterate(0,j-> j+1)
                .limit(10)
                .forEach(k-> System.out.println("Stream iteration "+k));

        int[] integers = new int[] {20, 98, 12, 7, 35};

        int asInt = Arrays.stream(integers).min().getAsInt();

    }

    private static void convertStringToStream() {
        String s = "hello";
        IntStream chars = s.chars();
        System.out.println(chars);

        Stream<Character> characterStream = s.chars()
                .mapToObj(c -> (char) c);

        System.out.println(characterStream.collect(Collectors.toList()));

        Stream<String> stringStream = s.codePoints().mapToObj(c -> String.valueOf(c));


    }

    private static void stringHasAlreadyBeenOperatedUponOrClose() {

        Stream<String> a = Stream.of("A", "B", "C", "D");
        Optional<String> any = a.findAny();
        System.out.println(any.get());
        //ßOptional<String> first = a.findFirst();
        //System.out.println(first.get());
        //List<String> collect = a.collect(Collectors.toList());

        Supplier<Stream<String>> supplier = () -> Stream.of("A", "B", "C");


        Optional<String> first = supplier.get().findFirst();
        Optional<String> any1 = supplier.get().findAny();


        supplier.get().findAny();
    }

    // get last element from stream
    private static void reduceTest() {

        List<String> valueList = new ArrayList<>();
        valueList.add("Joe");
        valueList.add("John");
        valueList.add("Sean");


        String s = valueList.stream().reduce((first, second) -> second)
                .orElse(null);


    }

    private static void testStream() {
        Iterable<String> strings = Arrays.asList("Testing", "Iterable", "Conversion");

        Stream<String> stream = StreamSupport.stream(strings.spliterator(), false);

        Stream<String> a = Stream.of("A", "B");
        Stream<String> x = Stream.of("X", "Z");

        Stream<String> concat = Stream.concat(a, x); // both generic should be same
        concat.forEach(System.out::println);
    }
}
