package de.htwberlin.web.api;

import java.math.BigDecimal;

public class PersonManipulationRequest {
    private String firstName;
    private String lastName;
    private BigDecimal debts;

    public PersonManipulationRequest(String firstName, String lastName, BigDecimal debts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.debts = debts;
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
