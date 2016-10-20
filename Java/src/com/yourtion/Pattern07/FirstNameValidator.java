package com.yourtion.Pattern07;

/**
 * Created by Yourtion on 20/10/2016.
 */
public class FirstNameValidator implements PersonValidator {
    @Override
    public boolean validate(Person person) {
        return person.getFirstName() != null;
    }
}
