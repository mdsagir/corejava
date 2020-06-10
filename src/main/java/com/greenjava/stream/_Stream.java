package com.greenjava.stream;

import com.greenjava.lambda.Student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.*;
/**
 * Once stream is created instance will not modify its source.
 * Empty stream is used to create empty stream to avoid the null
 * with no element
 */

/**
 * Create stream
 * 1) Stream.empty() - Avoid to null create empty Stream.empty()
 * 2) Stream.of() - Array can be source of stream
 * 3) Arrays.stream() - Returns stream through array
 * 4) Stream.builder() - Create instance of the Stream<Object>
 * 5) Stream.generate() - Accept supplier for limit to create
 */
public class _Stream {

    public static void main(String[] args) {

        //streamOf();
        // arraysStream();
        //streamGenerated();
        //streamIterator();
        //streamPrimitive();
        //streamString();
        //streamFile();
        //streamPipeline();
        //lazyInitialization();
        //findFirstAndFindAny();
        //collectors();
        //collectorsExtra();
        methodReference();


    }

    private static void collectorsExtra() {

        List<String> strings = Arrays.asList("John", "Sara", "Smith", "John");

        List<Student> students = getStudents();

        // its joining only string works only for the string

        strings.stream().collect(Collectors.joining()); // JohnSaraSmithJohn
        strings.stream().collect(Collectors.joining(" "));//John Sara Smith John
        strings.stream().collect(Collectors.joining(" ", "PRE-", "-PRO")); //PRE-John Sara Smith John-PRO

        // collectors counting works for the ? type

        students.size();

        // find min max value

        DoubleSummaryStatistics doubleSummaryStatistics = students.stream()
                .collect(Collectors.summarizingDouble(Student::getScore));
        System.out.println("MAX " + doubleSummaryStatistics.getMax() + " MIN " + doubleSummaryStatistics.getMin()
                + " COUNT " + doubleSummaryStatistics.getCount() + " AVERAGE " + doubleSummaryStatistics.getAverage());

        strings.stream().
                collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(s -> System.out.println(s));


    }

    private static void collectors() {
        List<String> strings = Arrays.asList("John", "Sara", "Smith", "John");

        List<String> list = strings.stream().collect(Collectors.toList());

        LinkedList<String> linkedList = strings.stream()
                .collect(Collectors.toCollection(LinkedList::new));

        // Function.identity(); return the same value
        // string holds duplicate value throw the IllegalStateException

//        Map<String, Integer> collectMap = strings.stream().
//                collect(Collectors.toMap(Function.identity(), String::length));

        // to duplicate collision use
        Map<String, Integer> collect = strings.stream()
                .collect(Collectors.toMap
                        (Function.identity(),
                                String::length, (item, identicalItem) -> item));

        for (Map.Entry<String, Integer> entry : collect.entrySet()) {
            System.out.println("Key " + entry.getKey() + " Value " + entry.getValue());
        }

    }


    private static void streamFile() {

        Path path = Paths.get("hello.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);

        } catch (IOException e) {

        }
    }

    private static void streamString() {

        String hello = "hello";
        String commaSeprator = "hello,i,am,here";

        IntStream chars = hello.chars();
        Stream<String> stringStream = Pattern.compile(",")
                .splitAsStream(commaSeprator);
        stringStream.forEach(System.out::println);


    }

    private static void streamOf() {

        Stream<Integer> integerStream = Stream.of(1, 2, 4);
        integerStream.forEach(System.out::println);

        Stream<Student> s = Stream.of(
                new Student(1, "John", 2, 23),
                new Student(2, "Sara", 3, 24)
        );
        s.forEach(System.out::println);
    }

    private static void arraysStream() {

        int[] i = {1, 2, 3, 4, 5};

        IntStream stream = Arrays.stream(i, 2, 4);
        IntStream stream1 = Arrays.stream(i);
        stream.forEach(System.out::println);
        stream1.forEach(System.out::println);

        List<Student> students = getStudents();

        Student[] students1 = students.toArray(new Student[0]);

        Arrays.stream(students1, 1, 2).forEach(System.out::println);
    }

    private static List<Student> getStudents() {
        return Arrays.asList(
                new Student(1, "John", 2, 23),
                new Student(2, "Sara", 3, 24),
                new Student(2, "Sara", 3, 25),
                new Student(2, "Sara", 3, 27)
        );
    }

    private static void streamBuilder() {
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> add = builder.add("add").build();

        Stream<String> build = Stream.<String>builder().add("a").add("b").build();


        Stream.Builder<Student> studentBuilder = Stream.builder();
    }

    private static void streamGenerated() {
        Stream<String> limit = Stream.generate(() -> "element").limit(10);
        limit.collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void streamIterator() {

        Stream<Integer> limit = Stream.iterate(40, n -> n + 2).limit(4);
        List<Integer> collect = limit.collect(Collectors.toList());
        collect.forEach(System.out::println);


    }

    private static void streamPrimitive() {
        IntStream range = IntStream.range(2, 5);
        IntStream intStream = IntStream.rangeClosed(1, 5);
        range.forEach(value -> System.out.println("range close " + value));
        intStream.forEach(value -> System.out.println("stream close " + value));
        // similar can be make for long and double
        Random random = new Random();

        IntStream ints = random.ints(2);
        ints.forEach(value -> System.out.println("Random ints " + value));

        LongStream longs = random.longs(3);
        longs.forEach(value -> System.out.println("Random longs " + value));

        DoubleStream doubles = random.doubles(4);
        doubles.forEach(value -> System.out.println("Random doubles " + value));


    }

    private static void streamPipeline() {
        Stream<String> hello = Stream.of("hello", "world", "welcome").skip(1);

    }

    private static long counter;

    private static void lazyInitialization() {
        /**
         * Intermediate operation is lazy means they will invoked
         * when necessary for terminal operation operation execution
         */

        List<String> list = Arrays.asList("abc1", "vbc2", "abc3");
        counter = 0;
        Stream<String> a = list.stream().filter(element -> {
            wasCalled();
            return element.startsWith("a");
        });
        /**
         * By executing this we was method can't be call
         * because stream not end with terminator operation
         */

        Optional<String> first = list.stream().filter(s -> {
            System.out.println("filter was called");
            return s.startsWith("v"); // changing v called twice v match with second place
        }).map(s -> {
            System.out.println("map was called");
            return s.toUpperCase();
        }).findFirst();
        /**
         * skip filter distinct keep in top of stream
         */
    }

    private static void findFirstAndFindAny() {

        /**
         * Stream may or may not have define encounter order
         * findFirst() findAny() both have work as same while parallel
         * findAny() can return any of element
         */

        List<String> list = Arrays.asList("A", "B", "C", "D");
        Optional<String> any = list.stream()
                //.findAny();
                .findFirst();
        any.ifPresent(System.out::println);

    }

    private static void wasCalled() {
        System.out.println("Hello " + counter);
        counter++;
    }

    public static <T> Stream<T> streamOf(Collection<T> c) {
        return c == null || c.isEmpty() ? Stream.empty() : c.stream();
    }

    public static void methodReference() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        list.stream().map(Java::new);
    }
}

class Java {

    Java(int i){

    }
    public  String get(int i) {
        return String.valueOf(i);
    }
}