package com.yourtion.Pattern04;

/**
 * Created by Yourtion on 10/10/2016.
 */
public class ImmutablePerson {
    private final String firstName;
    private final String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    private ImmutablePerson(Builder builder){
        firstName = builder.firstName;
        lastName = builder.lastName;
    }

    public static class Builder {
        private String firstName;
        private String lastName;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ImmutablePerson build() {
            return new ImmutablePerson(this);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
