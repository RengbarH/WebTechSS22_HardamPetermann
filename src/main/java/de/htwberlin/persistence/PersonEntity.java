package de.htwberlin.persistence;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Persons")
public class PersonEntity {
    //2.te erstellen: erste Entity(ID,Vorname,Nachname), zweite (ID, Betrag, eingetragen am
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "debts")
    private BigDecimal debts;

    protected PersonEntity() {}

    public PersonEntity(String firstName, String lastName, BigDecimal debts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.debts = debts;
    }

    public Long getId() {
        return id;
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

