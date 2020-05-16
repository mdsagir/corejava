package com.greenjava.trywithresource;

import org.junit.Test;

import java.util.Random;
import java.util.logging.Logger;

public class RandomNumberGenerator {

    Logger logger = Logger.getLogger(RandomNumberGenerator.class.getName());

    @Test
    public void generateUnboundedLong() {

        long generatedUnboundedLong = new Random().nextLong();
        long generatedAbsoluteValue = new Random().nextLong() & Long.MAX_VALUE;

        logger.info("Generated Unbounded Long :" + generatedUnboundedLong);
        System.out.println(generatedAbsoluteValue);
    }

    @Test
    public void generateRandomLong() {

        long leftLimit = 1;
        long rightLimit = 10;
        long random = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        System.out.println(random);

    }

    @Test
    public void generateRandomInteger() {

        int leftInteger = 1;
        int rightInteger = 10;
        int randomInteger = new Random().nextInt();
        int absoluteInteger = new Random().nextInt() & Integer.MAX_VALUE;
        int absoluteAnotherInteger = new Random().nextInt(Integer.MAX_VALUE);
        int absoluteRangeInteger = leftInteger + new Random().nextInt() * (rightInteger - leftInteger);
        System.out.println(randomInteger);
        System.out.println(absoluteInteger);
        System.out.println(absoluteAnotherInteger);
        System.out.println("Absolute range integer: " + absoluteRangeInteger);


    }
}
