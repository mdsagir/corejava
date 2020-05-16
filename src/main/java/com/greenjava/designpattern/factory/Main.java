package com.greenjava.designpattern.factory;

import java.util.*;

import static com.greenjava.designpattern.factory.WebsiteType.*;

public class Main {

    public static void main(String[] args) {


        List<String> strings = Arrays.asList("A", "C", "B");
        //Collections.sort(strings,((o1, o2) -> o1.compareTo(o2)));
        Collections.sort(strings);
        System.out.println(strings);

        //factory();
        Website website = WebsiteFactory.getWebsite(BLOG);
        System.out.println(website.getPages());
        Website shop = WebsiteFactory.getWebsite(SHOP);
        System.out.println(shop.getPages());
    }

    private static void factory() {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
    }
}
