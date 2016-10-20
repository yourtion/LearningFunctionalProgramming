package com.yourtion.Pattern07;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yourtion on 20/10/2016.
 */
public class PersonCollector {
    private PersonValidator personValidator;
    private List<Person> validPeople;

    public PersonCollector(PersonValidator personValidator) {
        this.personValidator = personValidator;
        this.validPeople = new ArrayList<Person>();
    }

    public void addPerson(Person person) {
        if (personValidator.validate(person))
            validPeople.add(person);
    }

    public List<Person> getValidPeople() {
        return validPeople;
    }

}
