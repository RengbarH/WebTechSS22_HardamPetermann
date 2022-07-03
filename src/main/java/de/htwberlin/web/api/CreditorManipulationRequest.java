package de.htwberlin.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CreditorManipulationRequest {
    @NotBlank(message = "Bitte dieses Feld nicht leer lassen.")
    private String firstName;

    @NotBlank(message = "Bitte dieses Feld nicht leer lassen.")
    private String lastName;
    private String identifier;

    @Pattern(regexp = "MALE|FEMALE|DIVERSE|UNKNOWN",
    message = "Bitte ein Geschlecht auswählen.")
    private String gender;


    public CreditorManipulationRequest(String firstName, String lastName, String identifier, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identifier = identifier;
        this.gender = gender;
    }

    public CreditorManipulationRequest() {
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
