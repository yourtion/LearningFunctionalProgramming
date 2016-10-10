package com.yourtion.Pattern04;

/**
 * Created by Yourtion on 10/10/2016.
 */
public class PersonHarness {

    public void run() {
        ImmutablePerson.Builder b = ImmutablePerson.newBuilder();
        ImmutablePerson p = b.firstName("Yourtion").lastName("Guo").build();
        System.out.println("Person is: " + p.toString());
    }

}
