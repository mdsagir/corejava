package com.greenjava.stream.reduce;

import com.greenjava.stream.Item;
import com.sun.jdi.ObjectCollectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceTest {

    static List<Item> items = new ArrayList<>(Arrays.asList(
            new Item(1, 110),
            new Item(1, 150),
            new Item(1, 120),
            new Item(1, 130)

    ));

    public static void main(String[] args) {



        long sum = items.stream().mapToInt(Item::getPrice).sum();
        System.out.println(sum);
    }
}
