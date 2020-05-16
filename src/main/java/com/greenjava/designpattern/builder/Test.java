package com.greenjava.designpattern.builder;

/**
 * Builder design pattern -:
 * handle complex constructor
 * no required interface
 * can be separate class
 * large no of parameter
 * Immutability
 * StringBuilder
 * DocumentBuilder
 */
public class Test {

    public static void main(String[] args) {

        //stringBuilderTest();
        //lunchOrder();

        FoodOrder.Builder builder = new FoodOrder.Builder();
        builder.bread("wheat").dressing("Maya").meat("Turkey");

        FoodOrder build = builder.build();

        System.out.println(build.getCondiments());
    }

    private static void lunchOrder() {
        LunchOrder lunchOrder = new LunchOrder();
        lunchOrder.setBread("Wheat");
        lunchOrder.setCondiments("Lettuce");
        lunchOrder.setDressing("Mustard");
        lunchOrder.setMeat("Ham");

        System.out.println(lunchOrder.getBread());

        LunchOrderTele lunchOrderTele = new LunchOrderTele("Wheat", "Lettuce",
                "Mustard", "Ham");
        System.out.println(lunchOrderTele.getBread());
    }

    private static void stringBuilderTest() {

        StringBuilder builder = new StringBuilder();
        builder.append("This is example");
        builder.append("of the builder pattern.");
        builder.append("It has method to append");

        builder.append("almost anything we want to a String ");
        builder.append(23);
        System.out.println(builder);

    }
}
