package com.yourtion.Pattern01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Yourtion on 9/7/16.
 */
public class PersonExample {
    public void run() {
        Person p1 = new Person("Mike", "Bevilacqua");
        Person p2 = new Person("Pedro", "Vasquez");
        Person p3 = new Person("Robert", "Aarons");

        List<Person> people = new ArrayList<Person>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        Collections.sort(people, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.getFirstName().compareTo(p2.getFirstName());
            }
        });

        for (Person person : people) {
            System.out.println(person);
        }
    }
}