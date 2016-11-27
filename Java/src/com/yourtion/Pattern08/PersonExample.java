package com.yourtion.Pattern08;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yourtion on 23/11/2016.
 */
public class PersonExample {

    private Map<Integer, Person> people;

    public PersonExample() {
        people = new HashMap<Integer, Person>();
    }

    public Person fetchPerson(Integer id) {
        Person person = people.get(id);
        if (null != person)
            return person;
        else
            return new NullPerson();
    }
    // Code to add/remove people

    public Person buildPerson(String firstName, String lastName) {
        if (null != firstName && null != lastName)
            return new RealPerson(firstName, lastName);
        else
            return new NullPerson();
    }

    public void run() {
        System.out.println("BuildPerson :");

        PersonExample example = new PersonExample();

        System.out.println("Not null: " + example.buildPerson("Yourtion", "Guo"));
        System.out.println("Null first name: " + example.buildPerson(null, "Guo"));
        System.out.println("Null last name: " + example.buildPerson("Yourtion", null));

        System.out.println("");
        System.out.println("FetchPerson :");

        example.people.put(0, example.buildPerson("Yourtion", "Guo"));

        System.out.println("Not null: " + example.fetchPerson(0));
        System.out.println("Null: " + example.fetchPerson(1));

    }
}
