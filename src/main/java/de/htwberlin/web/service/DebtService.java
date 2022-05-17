package de.htwberlin.web.service;

import de.htwberlin.web.api.Debts;
import de.htwberlin.web.api.DebtsManipulationRequest;
import de.htwberlin.web.persistence.DebtsEntity;
import de.htwberlin.web.persistence.DebtsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DebtService {

    private final DebtsRepository debtsRepository;

    public DebtService(DebtsRepository debtsRepository) {
        this.debtsRepository = debtsRepository;
    }


    public List<Debts> findAll() {
        List<DebtsEntity> debts = debtsRepository.findAll();
        return debts.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Debts create(DebtsManipulationRequest request) {
        var debtsEntity = new DebtsEntity(
                request.getDebtorFirstName(),
                request.getDebts(),
                request.getDateOfDebt()
        );
        debtsEntity = debtsRepository.save(debtsEntity);
        return transformEntity(debtsEntity);
    }

    // deleteByName und Id und update fehlt

    private Debts transformEntity(DebtsEntity debtsEntity) {
        return new Debts(
                debtsEntity.getId(),
                debtsEntity.getDebtorFirstName(),
                debtsEntity.getDebts(),
                debtsEntity.getDateOfDebt()
        );
    }
}
