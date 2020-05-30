package com.greenjava.lambda;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Lambda expression is an anonymous function
 * Its not associate with class
 * This is single type of class
 * Java 8 introduces default methods
 *
 */

public class LambadaIteration {


    private Logger logger = Logger.getLogger(LambadaIteration.class.getName());

    /**
     * Find out highest score student which belongs to 2109 grade year
     */
    double highScore = 0.0;

    public double iteration() {

        List<Student> students = loadStudents();

        /**
         * code is controls iteration
         * iteration from beginning to end
         * not thread safe
         * business logic is stateful
         * mutable accumulator variable
         */

        for (Student student : students) {
            if (student.getGradeYear() == 2019) {
                if (student.getScore() > highScore) {
                    highScore = student.getScore();
                }
            }
        }
        logger.info("High score " + highScore + " in 2019 grade.");
        return highScore;

    }

    public double   moreFunctional() {

        /**
         * iteration handle by the lib
         * Not done inheritaly travel may be parrallel
         * Client logic is state stateless
         * thread safe
         * Down side :
         * Syntactically ugly
         */

        List<Student> students = loadStudents();


        return students.parallelStream()
                .filter(new Predicate<Student>() {
                    @Override
                    public boolean test(Student student) {
                        return student.getGradeYear() == 2019;
                    }
                })
                .map(new Function<Student, Integer>() {
                    @Override
                    public Integer apply(Student student) {
                        return student.getScore();
                    }
                })
                .max(Double::compare).get();
    }

    public double lambdaExpression(){

        List<Student> students = loadStudents();

        return  students.stream()
                .filter(student -> student.getGradeYear() == 2019)
                .map(student -> student.getScore())
                .max(Double::compare).get();
    }

    private List<Student> loadStudents() {
        List<Student> students = Arrays.asList(
                new Student(1, "John", 2019, 89),
                new Student(3, "Smith", 2018, 65),
                new Student(2, "Sara", 2019, 90),
                new Student(4, "Kristin", 2014, 78)
        );
        return students;
    }
}
