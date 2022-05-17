package de.htwberlin.web.api;

public class Person {

    private long id;
    private String firstName;
    private String lastName;

    private String identifier;


    public Person(long id, String firstName, String lastName, String identifier) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identifier = identifier;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}