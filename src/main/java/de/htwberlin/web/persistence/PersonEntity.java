package de.htwberlin.web.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "identifier", nullable = false)
    private String identifier;

    @OneToMany(mappedBy = "glaeubiger", fetch = FetchType.EAGER)
    private List<DebtsEntity> debts = new ArrayList<>();

    protected PersonEntity() {}

    public PersonEntity(String firstName, String lastName, String identifier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identifier = identifier;
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<DebtsEntity> getDebts() {
        return debts;
    }

    public void setDebts(List<DebtsEntity> debts) {
        this.debts = debts;
    }
}

