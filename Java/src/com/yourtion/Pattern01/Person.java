package com.yourtion.Pattern01;

/**
 * Created by Yourtion on 9/7/16.
 */

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    // Implements the Comparable interface.
    public int compareTo(Person otherPerson) {
        return this.lastName.compareTo(otherPerson.lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
