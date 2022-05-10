package de.htwberlin.web.api;

import java.math.BigDecimal;

public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private BigDecimal debts;

    public Person(long id, String firstname, String lastname, BigDecimal debts) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.debts = debts;
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

    public BigDecimal getDebts() {
        return debts;
    }

    public void setDebts(BigDecimal debts) {
        this.debts = debts;
    }
}