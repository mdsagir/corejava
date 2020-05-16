package com.greenjava.lambda;

public class Student {

    private int id;
    private String name;
    private int gradeYear;
    private double score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeYear() {
        return gradeYear;
    }

    public void setGradeYear(int gradeYear) {
        this.gradeYear = gradeYear;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student(int id, String name, int gradeYear, double score) {
        this.id = id;
        this.name = name;
        this.gradeYear = gradeYear;
        this.score = score;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gradeYear=" + gradeYear +
                ", score=" + score +
                '}';
    }
}
