package com.yourtion.Pattern02;

import com.yourtion.Pattern01.PersonExpanded;

import java.util.Comparator;

/**
 * Created by Yourtion on 9/8/16.
 */
public class PersonExampleCC {
    public void run() {
        Comparator<PersonExpanded> firstAndLastNameComparator =
                new ComposedComparator<PersonExpanded>(
                        new FirstNameComparator(),
                        new LastNameComparator());

        PersonExpanded personOne = new PersonExpanded("John", "", "Adams");
        PersonExpanded personTwo = new PersonExpanded("John", "Quincy", "Adams");

        System.out
                .println(firstAndLastNameComparator.compare(personOne, personTwo));
    }
}

class FirstNameComparator implements Comparator<PersonExpanded> {
    @Override
    public int compare(PersonExpanded personOne, PersonExpanded personTwo) {
        return personOne.getFirstName().compareTo(personTwo.getFirstName());
    }
}

class LastNameComparator implements Comparator<PersonExpanded> {
    @Override
    public int compare(PersonExpanded personOne, PersonExpanded personTwo) {
        return personOne.getLastName().compareTo(personTwo.getLastName());
    }
}