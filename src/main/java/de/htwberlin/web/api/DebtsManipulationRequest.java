package de.htwberlin.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;

public class DebtsManipulationRequest {
    @NotBlank(message = "Bitte dieses Feld nicht leer lassen.")

    private String debtorFirstName;
    @Positive(message = "Gib bitte eine Zahl größer 0 ein")
    private BigDecimal debts;

    private Date dateOfDebt;
    private Long creditorId;
    @Pattern(regexp = "MALE|FEMALE|DIVERSE|UNKNOWN",
            message = "Bitte ein Geschlecht auswählen.")
    private String gender;


    public DebtsManipulationRequest(String debtorFirstName, BigDecimal debts, Date dateOfDebt, Long creditorId, String gender) {
        this.debtorFirstName = debtorFirstName;
        this.debts = debts;
        this.dateOfDebt = dateOfDebt;
        this.creditorId = creditorId;
        this.gender = gender;
    }

    public DebtsManipulationRequest() {
    }

    public String getDebtorFirstName() {
        return debtorFirstName;
    }

    public void setDebtorFirstName(String debtorFirstName) {
        this.debtorFirstName = debtorFirstName;
    }

    public BigDecimal getDebts() {
        return debts;
    }

    public void setDebts(BigDecimal debts) {
        this.debts = debts;
    }

    public Date getDateOfDebt() {
        return dateOfDebt;
    }

    public void setDateOfDebt(Date dateOfDebt) {
        this.dateOfDebt = dateOfDebt;
    }

    public Long getCreditorId() {
        return creditorId;
    }

    public void setCreditorId(Long creditorId) {
        this.creditorId = creditorId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
