package de.htwberlin.web.api;

import java.util.List;

public class Creditor {

    private long id;
    private String firstName;
    private String lastName;
    private String identifier;
    private String gender;
    private List<Long> debtors;


    public Creditor(long id, String firstName, String lastName, String identifier, String gender, List<Long> debtors) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identifier = identifier;
        this.gender = gender;
        this.debtors = debtors;
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

    public List<Long> getDebtors() {
        return debtors;
    }

    public void setDebtors(List<Long> debtors) {
        this.debtors = debtors;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
