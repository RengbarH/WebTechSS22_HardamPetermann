package de.htwberlin.web.api;

import java.math.BigDecimal;

public class Person {

    private long id;
    private String firstname;
    private String lastname;
    private BigDecimal debts;

    public Person(long id, String firstname, String lastname, BigDecimal debts) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.debts = debts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public BigDecimal getDebts() {
        return debts;
    }

    public void setDebts(BigDecimal debts) {
        this.debts = debts;
    }
}