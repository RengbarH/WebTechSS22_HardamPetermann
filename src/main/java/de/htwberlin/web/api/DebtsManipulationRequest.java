package de.htwberlin.web.api;

import java.math.BigDecimal;
import java.util.Date;

public class DebtsManipulationRequest {

    private String debtorFirstName;
    private BigDecimal debts;
    private Date dateOfDebt;
    private Long glaeubigerId;


    public DebtsManipulationRequest(String debtorFirstName, BigDecimal debts, Date dateOfDebt, Long glaeubigerId) {
        this.debtorFirstName = debtorFirstName;
        this.debts = debts;
        this.dateOfDebt = dateOfDebt;
        this.glaeubigerId = glaeubigerId;
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

    public Long getGlaeubigerId() {
        return glaeubigerId;
    }

    public void setGlaeubigerId(Long glaeubigerId) {
        this.glaeubigerId = glaeubigerId;
    }
}
