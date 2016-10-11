package com.yourtion.Pattern05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yourtion on 11/10/2016.
 */

class Address {

    private Integer zipCode;

    // Other fields elided for the sake of brevity.

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
}

class Person {

    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static Person creatPerson(String name, Integer zipCode) {
        Address a = new Address();
        a.setZipCode(zipCode);

        Person p = new Person();
        p.name = name;
        p.address = a;

        return p;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.address.getZipCode());
    }
}


public class TheLambdaBarAndGrille {

    public Map<Integer, List<String>> peopleByZip(List<Person> people) {
        Map<Integer, List<String>> closePeople =
                new HashMap<Integer, List<String>>();

        for (Person person : people) {
            Integer zipCode = person.getAddress().getZipCode();
            if (isCloseZip(zipCode)){
                List<String> peopleForZip =
                        closePeople.get(zipCode);
                closePeople.put(zipCode,
                        addPerson(peopleForZip, person));
            }
        }

        return closePeople;
    }

    private List<String> addPerson(List<String> people, Person person) {
        if (null == people)
            people = new ArrayList<String>();
        people.add(person.getName());
        return people;
    }
    private Boolean isCloseZip(Integer zipCode) {
        return zipCode == 19123 || zipCode == 19103;
    }

    public void run() {
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add( Person.creatPerson("Yourtion1", 19123) );
        persons.add( Person.creatPerson("Yourtion2", 19103) );
        persons.add( Person.creatPerson("Yourtion3", 19129) );
        persons.add( Person.creatPerson("Yourtion4", 19103) );
        persons.add( Person.creatPerson("Yourtion5", 19111) );

        System.out.println("All person: " + persons);
        System.out.println("closePeople: " + peopleByZip(persons));
    }
}
