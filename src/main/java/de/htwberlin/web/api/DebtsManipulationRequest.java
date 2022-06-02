package de.htwberlin.web.api;

import java.math.BigDecimal;
import java.util.Date;

public class DebtsManipulationRequest {

    private String debtorFirstName;
    private BigDecimal debts;
    private Date dateOfDebt;
    private Long creditorId;
    private String gender;


    public DebtsManipulationRequest(String debtorFirstName, BigDecimal debts, Date dateOfDebt, Long creditorId, String gender) {
        this.debtorFirstName = debtorFirstName;
        this.debts = debts;
        this.dateOfDebt = dateOfDebt;
        this.creditorId = creditorId;
        this.gender = gender;
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
