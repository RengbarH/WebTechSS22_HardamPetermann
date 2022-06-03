package de.htwberlin.web.api;

public class CreditorManipulationRequest {
    private String firstName;
    private String lastName;
    private String identifier;
    private String gender;


    public CreditorManipulationRequest(String firstName, String lastName, String identifier, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identifier = identifier;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
