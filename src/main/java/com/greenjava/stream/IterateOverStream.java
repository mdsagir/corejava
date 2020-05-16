package com.greenjava.stream;

import com.greenjava.lambda.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IterateOverStream {

    public static void main(String[] args) {

        //arrayToStream();
        testObject();
    }

    private static void arrayToStream() {
        String[] names = {"John", "Sara", "Mathews"};

        List<String> collect = IntStream.range(0, names.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> names[i])
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void testObject() {

        List<Student> students = loadStudents();

        List<Student> collect = IntStream.range(0, students.size())
                .filter(value -> value % 2 == 0)
                .mapToObj(value -> students.get(value))
                .collect(Collectors.toList());
        List<Student> collect1 = IntStream.range(2, students.size())
                .mapToObj(value -> students.get(value))
                .collect(Collectors.toList());
        System.out.println(collect1);
    }

    private static List<Student> loadStudents() {
        List<Student> students = Arrays.asList(
                new Student(1, "John", 2019, 89),
                new Student(3, "Smith", 2018, 65),
                new Student(2, "Sara", 2019, 90),
                new Student(4, "Kristin", 2014, 78)
        );
        return students;
    }
}
