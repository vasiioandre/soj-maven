package com.endava.tmd.soj.maven.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {

    private String firstName;
    private String lastName;

    public Person() {
        // default constructor
    }

    public Person(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}

