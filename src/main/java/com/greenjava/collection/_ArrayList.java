package com.greenjava.collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Random Access takes 0(1) times
 * Adding element takes amortized constant time 0(1)
 * Inserting Deleting takes 0(n)
 * Searching takes 0(n)
 */
public class _ArrayList {

    public static void main(String[] args) {

        //createArrayList();
        //unmodifiable();
        //removeNULL();
        //removeDuplicate();
        //checkEquals();
        //findElementInList();
        copyListToAnother();

    }

    private static void copyListToAnother() {

        List<String> list1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        ArrayList<String> strings = new ArrayList<>(list1);
        // both element have independent
        // one collection not reflect to another
        list1.addAll(strings);
        Collections.copy(list1,strings);
        // java 8 or can skip or filter
        List<String> collect = list1.stream().collect(Collectors.toList());

        // probably null safe
        List<String> collect1 = Optional.ofNullable(list1)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .collect(Collectors.toList());


    }

    private static void findElementInList() {

        List<String> list1 = Arrays.asList("1", "2", "3", "4");
        boolean contains = list1.contains("3");
        System.out.println(contains);
        int index = list1.indexOf("4");
        String s = list1.get(index);
        System.out.println(s);
    }

    private static void checkEquals() {

        List<String> list1 = Arrays.asList("1", "2", "3", "4");
        List<String> list2 = Arrays.asList("1", "2", "3", "4", "0");
        System.out.println(list1.equals(list2));

    }

    private static void removeDuplicate() {

        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 3, 3, 5, 9, 0));
        System.out.println(integers);

        List<Integer> distinctList = new ArrayList<>(new HashSet<Integer>(integers));
        System.out.println(distinctList);

        List<Integer> collect = integers.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void removeNULL() {

        ArrayList<Integer> byWhile =
                new ArrayList<>(Arrays.asList(1, null, 2, null, 5));

        System.out.println("Before by byWhile " + byWhile);
        while (byWhile.remove(null)) ;
        System.out.println("After by byWhile " + byWhile);

        List<Integer> byRemoveAll =
                new ArrayList<>(Arrays.asList(1, null, 2, null, 5));
        System.out.println("Before by byRemoveAll " + byRemoveAll);
        byRemoveAll.removeAll(Collections.singleton(null));
        System.out.println("After by byRemoveAll " + byRemoveAll);

        List<Integer> byStream =
                new ArrayList<>(Arrays.asList(1, null, 2, null, 5));
        System.out.println("Before by byStream " + byStream);

        List<Integer> updateByStream = byStream.stream()
                .filter(i -> i != null)
                .collect(Collectors.toList());

        System.out.println("After by ByStream " + updateByStream);

        List<Integer> byStreamObject =
                new ArrayList<>(Arrays.asList(1, null, 2, null, 5));
        List<Integer> byUpdateStreamObject = byStreamObject.stream().filter(Objects::nonNull)
                .collect(Collectors.toList());


        byStreamObject.removeIf(Objects::nonNull);

    }

    private static void unmodifiable() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 3, 5, 2));
//        List<Integer> integers1 = Collections.unmodifiableList(integers);

    }

    public static void createArrayList() {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>(10);

        List<Integer> collect = IntStream.range(0, 10).boxed()
                .collect(Collectors.toList());


        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 3, 0, 7));


        boolean remove = integers.remove(new Integer(0));
        System.out.println(integers);

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {

            if (iterator.next() == 7) {
                iterator.remove();
            }
        }
        System.out.println(integers);

        for (int i : integers) {
            if (i == 1)
                integers.remove(new Integer(1));
        }
        System.out.println(integers);

    }

}
