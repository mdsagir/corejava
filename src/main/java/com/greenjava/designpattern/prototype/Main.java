package com.greenjava.designpattern.prototype;

public class Main {

    public static void main(String[] args) {
        Registry registry = new Registry();
        Movie movie=(Movie) registry.createItem("Movie");
        movie.setTitle("Creation Pattern in java");

        System.out.println(movie);
        System.out.println(movie.getPrice());
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());

        System.out.println("Another movie just..");
        Movie anotherMovie= (Movie) registry.createItem("Movie");
        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getPrice());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getUrl());

    }
}
