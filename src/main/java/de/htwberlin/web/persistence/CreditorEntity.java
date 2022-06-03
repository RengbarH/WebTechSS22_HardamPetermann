package de.htwberlin.web.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "creditor")
public class CreditorEntity {
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

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "creditor", fetch = FetchType.EAGER)
    private List<DebtsEntity> debtor = new ArrayList<>();

    protected CreditorEntity() {}

    public CreditorEntity(String firstName, String lastName, String identifier, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identifier = identifier;
        this.gender = gender;
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

    public List<DebtsEntity> getDebtor() {
        return debtor;
    }

    public void setDebtor(List<DebtsEntity> debtor) {
        this.debtor = debtor;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

