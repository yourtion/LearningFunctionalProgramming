package com.yourtion.Pattern07;

/**
 * Created by Yourtion on 20/10/2016.
 */
public class PersonCollectorExample {

    public void run() {
        Person person1 = new Person("Yourtion", null, "Guo");
        Person person2 = new Person("John", "Quincy", "Adams");
        Person person3 = new Person(null, "John", "Adams");
        Person person4 = new Person(null, null, null);

        System.out.println("FirstNameValidator");

        PersonValidator firstNameValidator = new FirstNameValidator();
        PersonCollector personCollector1 = new PersonCollector(firstNameValidator);
        personCollector1.addPerson(person1);
        personCollector1.addPerson(person2);
        personCollector1.addPerson(person3);
        personCollector1.addPerson(person4);
        System.out.println("FirstNameValidator Collector list : " + personCollector1.getValidPeople());

        System.out.println("");

        System.out.println("FullNameValidator");

        PersonValidator fullNameValidator = new FullNameValidator();
        PersonCollector personCollector2 = new PersonCollector(fullNameValidator);
        personCollector2.addPerson(person1);
        personCollector2.addPerson(person2);
        personCollector2.addPerson(person3);
        personCollector2.addPerson(person4);
        System.out.println("FullNameValidator Collector list : " + personCollector2.getValidPeople());

    }
}
