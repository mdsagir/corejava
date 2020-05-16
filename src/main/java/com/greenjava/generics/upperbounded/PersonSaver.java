package com.greenjava.generics.upperbounded;

import java.util.ArrayList;
import java.util.List;

public class PersonSaver {

    List<Person> people=new ArrayList<>();

    public void save(Person person) {

        people.add(person);
        System.out.println(person);
    }

    public void saveAll(final List<? extends Person> persons) {

        for (Person person : persons) {
            save(person);
        }
    }


    public void loadAll(List<? super Person> persons) {

        for (Person person:people) {
             persons.add(person);
        }
    }
}
