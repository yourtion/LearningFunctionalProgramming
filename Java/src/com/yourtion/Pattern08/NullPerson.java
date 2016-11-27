package com.yourtion.Pattern08;

/**
 * Created by Yourtion on 23/11/2016.
 */
public class NullPerson implements Person {

    public String getFirstName() {
        return "John";
    }

    public void setFirstName(String firstName) {
    }

    public String getLastName() {
        return "Doe";
    }

    public void setLastName(String lastName) {
    }

    @Override
    public String toString() {
        return getFirstName()  + " " + getLastName();
    }
}
