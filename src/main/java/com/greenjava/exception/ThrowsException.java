package com.greenjava.exception;

import com.greenjava.lambda.Student;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class ThrowsException {
    public static void main(String[] args) {

        test();

//         System.out.println(" ".isEmpty());

    }

    public static void test() {
        // Student student=new Student(1,"sagit","Mumbai",201,30);
        Student student = new Student();
        student.setName("sagir");
        student.setAddress("  l");

        Optional<Integer> integer = Optional.ofNullable(student)
                .filter(s -> Objects.nonNull(s.getName()))
                .filter(s -> Objects.nonNull(s.getAddress()))
                .filter(s -> s.getName().trim().length() != 0)
                .filter(s -> s.getAddress().trim().length() != 0)
                .map(s -> hack(s.getName(), s.getAddress()));
        integer.ifPresent(System.out::println);
        //.ifPresent(s -> hack(10, s.getName(), s.getAddress()));

    }

    static int hack( String name, String address) {
        System.out.println(" name " + name.trim().length()
                + " address " + address.trim().length());

        return name.trim().length() + address.trim().length();

    }

    static boolean isBlankString(String string) {
        return !string.trim().isEmpty();
    }

    public static void doSomething(String s) {
        System.out.println(s + " tt");
    }

}
