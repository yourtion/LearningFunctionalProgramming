package com.yourtion.Pattern07;

/**
 * Created by Yourtion on 20/10/2016.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String middleName;

    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName;
    }


}
