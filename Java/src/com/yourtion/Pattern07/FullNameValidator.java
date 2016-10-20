package com.yourtion.Pattern07;

/**
 * Created by Yourtion on 20/10/2016.
 */
public class FullNameValidator implements PersonValidator {
    @Override
    public boolean validate(Person person) {
        return person.getFirstName() != null
                && person.getMiddleName() != null
                && person.getLastName() != null;
    }
}
