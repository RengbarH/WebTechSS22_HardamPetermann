package de.htwberlin.persistence;

import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "debts")
    private BigDecimal debts;

    protected PersonEntity() {}

    public PersonEntity(String firstname, String lastname, BigDecimal debts) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.debts = debts;
    }

    public Long getId() {
        return id;
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

    public BigDecimal isDebts() {
        return debts;
    }

    public void setDebts(String debts) {
        this.debts = new BigDecimal(debts);
    }
}

