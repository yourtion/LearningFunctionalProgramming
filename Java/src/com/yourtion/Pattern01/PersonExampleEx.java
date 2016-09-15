package com.yourtion.Pattern01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Yourtion on 9/7/16.
 */
public class PersonExampleEx {
        public void run() {
            List<PersonExpanded> people = new ArrayList<PersonExpanded>();
            people.add(new PersonExpanded("Aaron", "Jeffrey", "Smith"));
            people.add(new PersonExpanded("Aaron", "Bailey", "Zanthar"));
            people.add(new PersonExpanded("Brian", "Adams", "Smith"));

            Collections.sort(people, new ComplicatedNameComparator());

            for (PersonExpanded person : people) {
                System.out.println(person);
            }
        }
}

class ComplicatedNameComparator implements Comparator<PersonExpanded> {
    public int compare(PersonExpanded p1, PersonExpanded p2) {

        int firstNameCompare =
                p1.getFirstName().compareTo(p2.getFirstName());
        int lastNameCompare = p1.getLastName().compareTo(p2.getLastName());
        int middleNameCompare = p1.getMidName().compareTo(p2.getMidName());

        if (0 != firstNameCompare)
            return firstNameCompare;
        else if (0 != lastNameCompare)
            return lastNameCompare;
        else
            return middleNameCompare;
    }
}