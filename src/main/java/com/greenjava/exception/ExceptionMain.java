package com.greenjava.exception;

import com.greenjava.lambda.Student;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ExceptionMain {
    public static void main(String[] args) throws MyException {

//        System.out.println("Main 1");
//            method();
//
//        System.out.println("Main 2");

        Student student=new Student();
        student.setId(1);
        student.setGradeYear(202);
        student.setName("john");
        student.setScore(20);


        Field[] declaredFields = student.getClass().getDeclaredFields();



        for (Field field:declaredFields){
            System.out.println(field.getName());
        }

        System.out.println(student);

    }

    public static void method()throws RuntimeException  {

        Path path = Paths.get("hello.txt");


        System.out.println("Hello 1");

        try {
            String s=null;
            System.out.println(s.length());
            int i = Integer.parseInt("10");
            System.out.println("converted i value: "+i);
            Stream<String> lines = Files.lines(path);
        } catch (IOException | RuntimeException  e) {
            if (e instanceof RuntimeException){
                System.out.println("runtime");
                String message = ((RuntimeException) e).getMessage();
                throw new MyException("Runtime exception "+message);
            }
            if (e instanceof IOException){
                throw new MyException("file not found "+e.getMessage());
            }

        }


        System.out.println("Hello 2");

    }
}
