package de.htwberlin.web.service;

import de.htwberlin.web.api.Debts;
import de.htwberlin.web.persistence.DebtsEntity;
import de.htwberlin.web.persistence.Gender;
import org.springframework.stereotype.Service;

@Service
public class DebtTransformer {
    public Debts transformEntity(DebtsEntity debtsEntity) {
        var gender = debtsEntity.getGender() != null ? debtsEntity.getGender().name() : Gender.UNKNOWN.name();
        return new Debts(
                debtsEntity.getId(),
                debtsEntity.getDebtorFirstName(),
                debtsEntity.getDebts(),
                debtsEntity.getDateOfDebt(),
                debtsEntity.getCreditor().getId(),
                gender
        );
    }
}
