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

    @Column(name = "debtor", nullable = false)
    private String debtor;

    @Column(name = "debts", nullable = false)
    private BigDecimal debts;

    @Column(name = "date_of_debt")
    private Date dateOfDebt;


}
