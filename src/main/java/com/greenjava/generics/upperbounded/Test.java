package com.greenjava.generics.upperbounded;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {

        Person person = new Person("Bob", 20);
        Partner donDraper = new Partner("Don Draper", 89);
        Partner bertCooper = new Partner("Bert Cooper", 89);
        Employee morgen = new Employee("Morgan", 76);


        //upperbound(donDraper, bertCooper);
        lowerBound(donDraper,bertCooper);

    }

    private static void lowerBound(Partner donDraper, Partner bertCooper) {
        List<Object> persons = new ArrayList<>();
        persons.add(bertCooper);
        persons.add(donDraper);

        PersonSaver personSaver = new PersonSaver();
        personSaver.loadAll(persons);
    }

    private static void upperbound(Partner donDraper, Partner bertCooper) {
        List<Person> persons = new ArrayList<>();
        persons.add(bertCooper);
        persons.add(donDraper);

        PersonSaver personSaver = new PersonSaver();
        personSaver.saveAll(persons);
        personSaver.loadAll(persons);
    }
}
