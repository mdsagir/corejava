package com.greenjava.stream;

import com.greenjava.lambda.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.function.IntFunction;

public class _Function {

    public static void main(String[] args) {


        List<String> names = Arrays.asList("bob", "josh", "megan");
        names.replaceAll(String::toUpperCase);

        List<Student> students = loadStudents();


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
