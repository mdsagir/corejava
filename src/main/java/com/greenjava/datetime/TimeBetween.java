package com.greenjava.datetime;


import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class TimeBetween {

    public static void main(String[] args) throws InterruptedException {

        dateAndDate();
        //instant();
    }

    private static void dateAndDate(){

        Date date = new Date();
        java.sql.Date date1=new java.sql.Date(2020,9,12);
        System.out.println(date);
        System.out.println(date1);

        Calendar instance = Calendar.getInstance();

        System.out.println(instance);
    }

    private static void instant() throws InterruptedException {

        Instant start = Instant.now();

        Thread.sleep(2003);


        logTime(start);
    }

    private static void logTime(Instant start) {
        System.out.println("Elapsed time: " + Duration.between(start, Instant.now()).toMillis() + " ms");

    }
}
