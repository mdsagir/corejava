package com.greenjava.stream;

import com.greenjava.lambda.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalProgramming {

    public static void main(String[] args) throws IOException {

        reduce();

        List<Integer> integers = Arrays.asList(1, 3, 5, 7, 6, 1, 9, 3, 4, 6);
        List<Integer> squareInteger = integers.stream().map(x -> x * x).collect(Collectors.toList());

    }

    private static void sorted() {

        List<String> list = Arrays.asList("Azure", "Spring Boot", "Hibernate", "JPA");
        list.stream().sorted().forEach(System.out::print);
        System.out.println();
        list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::print);
        System.out.println();
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println();
        // comparing the string
        list.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);

    }

    private static void reduce() throws IOException {

        List<Integer> integers = Arrays.asList(1, 3, 5, 7, 6, 1, 9, 3, 4, 6);
        // custom method reference
        integers.stream().reduce(0, FunctionalProgramming::sum);
        // lambada expression
        integers.stream().reduce(0, (x, y) -> x + y);
        // Integer class
        integers.stream().reduce(0, Integer::sum);
        // square the no and sum
        integers.stream().map(x -> x * x).reduce(0, (x, y) -> x + y);
        // reduce by method reference
        integers.stream().reduce(0, Integer::sum);
        // reduce by the filter
        integers.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum);
        // reduce with distinct
        integers.stream().distinct().reduce(0, Integer::sum);

        List<String> strings = new ArrayList<>();
        strings.add("Java");
        strings.add("oracle");
        strings.add("mysql");

        strings.stream().reduce("", (s1, s2) -> s1 + s2);
        String reduce = strings.stream().reduce("", (s1, s2) -> s1.toUpperCase() + s2.toUpperCase());
        strings.stream().reduce("", String::concat);


        List<Student> list = new ArrayList<>(
                Arrays.asList(
                        new Student(1, "sagir", "mumbai", 22, 3),
                        new Student(1, "ankit", "hyderabad", 23, 1),
                        new Student(1, "kunal", "mumbai", 21, 2),
                        new Student(1, "ravi", "banglore", 22, 4)
                )
        );
        // sum of score
        Integer sum = list.stream()
                .reduce(0, (partialStudentScore, student) ->
                        partialStudentScore + student.getScore(), Integer::sum);
//allMatch
        System.out.println(list.stream().allMatch(student -> student.getGradeYear() > 20));
        // match either on of them
        System.out.println(list.stream().anyMatch(student -> student.getGradeYear() > 11));
        // non match on of them
        System.out.println(list.stream().anyMatch(student -> student.getGradeYear() > 24));

// sorted
        System.out.println(list.stream()
                .sorted(Comparator.comparingInt(Student::getScore))
                .collect(Collectors.toList()));
        // reverse
        System.out.println(list.stream()
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .collect(Collectors.toList()));
        // then sorted comparingInt in not required to cast
        System.out.println(list.stream()
                .sorted(Comparator.comparingInt(Student::getScore)
                        .thenComparing(Student::getGradeYear))
                .collect(Collectors.toList()));

// skip : skip the element of recode if skip > size then empty -1 Illegal argument exception
        System.out.println(list.stream().skip(2).collect(Collectors.toList()));

// limit : top value have receive if limit > size the all value return -1 Illegal argument exception
        System.out.println(list.stream().limit(10).collect(Collectors.toList()));

// MAX Score
        System.out.println(list.stream().max(Comparator.comparing(Student::getScore)));
// MIN Score
        System.out.println(list.stream().min(Comparator.comparing(Student::getScore)));
// No Value with MIN
        System.out.println(list.stream()
                .filter(student -> student.getScore() > 4)
                .min(Comparator.comparing(Student::getScore))
        );
// oeElse
        System.out.println(list.stream()
                .filter(student -> student.getScore() > 4)
                .min(Comparator.comparing(Student::getScore))
                .orElse(new Student(0, "dummy", 0, 0))
        );
        System.out.println(list.stream()
                .filter(student -> student.getScore() > 4)
                .min(Comparator.comparing(Student::getScore))
                .orElseGet(() -> new Student(0, "dummy", 0, 0))
        );
//        System.out.println(list.stream()
//                .filter(student -> student.getScore() > 4)
//                .min(Comparator.comparing(Student::getScore))
//                .orElseThrow(() -> new IllegalArgumentException("Not found"))
//        );

// find first
        System.out.println(list.stream().filter(student -> student.getScore() > 2).findFirst());

// find sum of score of student those grade year > 20
// sum return 0 if value is not there no optional will return
        System.out.println(list.stream()
                .filter(student -> student.getGradeYear() > 22)
                .mapToInt(Student::getScore)
                .sum());
// average return optional
        System.out.println(list.stream()
                .filter(student -> student.getGradeYear() > 21)
                .mapToInt(Student::getScore)
                .average());
// count
        System.out.println(list.stream()
                .filter(student -> student.getGradeYear() > 21)
                .mapToInt(Student::getScore)
                .average());
// min
        System.out.println(list.stream()
                .filter(student -> student.getGradeYear() > 21)
                .mapToInt(Student::getScore)
                .min());
//max
        System.out.println(list.stream()
                .filter(student -> student.getGradeYear() > 21)
                .mapToInt(Student::getScore)
                .max());
// count
        System.out.println(list.stream()
                .filter(student -> student.getGradeYear() > 21)
                .mapToInt(Student::getScore)
                .count());
// all grouping
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(Student::getAddress))
        );
// grouping by address and counting
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(Student::getAddress, Collectors.counting()))
        );
// grouping the maximum grade year student
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(Student::getAddress,
                        Collectors.maxBy(Comparator.comparing(Student::getGradeYear))))
        );
// grouping and find out particular value
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(Student::getAddress,
                        Collectors.mapping(Student::getName, Collectors.toList())))
        );
// replace all
        strings.replaceAll(str->str.toUpperCase());
        System.out.println(strings);
        strings.removeIf(str->str.length()==4);
        System.out.println(strings);
// stream files handling

//        Files.lines(Paths.get(""))
//                .map(s -> s.split(" "))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .sorted()
//                .forEach(System.out::println);

    }

    private static int sum(int a, int b) {
        return a + b;
    }
}
