package de.htwberlin.web.persistence;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "debts")
public class DebtsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "debtor_first_name", nullable = false)
    private String debtorFirstName;

    @Column(name = "debts", nullable = false)
    private BigDecimal debts;

    @Column(name = "date_of_debt")
    private Date dateOfDebt;

    protected DebtsEntity() {
    }

    public DebtsEntity(String debtorFirstName, BigDecimal debts, Date dateOfDebt) {
        this.debtorFirstName = debtorFirstName;
        this.debts = debts;
        this.dateOfDebt = dateOfDebt;
    }


    public Long getId() {
        return id;
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
}