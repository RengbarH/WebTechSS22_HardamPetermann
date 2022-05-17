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

    public Debts update(Long id, DebtsManipulationRequest request) {
        var debtsEntityOptional = debtsRepository.findById(id);
        if (debtsEntityOptional.isEmpty()) {
            return null;
        }
        var debtsEntity = debtsEntityOptional.get();
        debtsEntity.setDebtorFirstName(request.getDebtorFirstName());
        debtsEntity.setDebts(request.getDebts());
        //debtsEntity.getDateOfDebt(request.getDateOfDebt()); <- das braucht man nicht, da sich das Datum nicht veraendert
        debtsEntity = debtsRepository.save(debtsEntity);

        return transformEntity(debtsEntity);
    }

    public boolean deleteById(Long id) {
        if (!debtsRepository.existsById(id)) {
            return false;
        }
        debtsRepository.deleteById(id);
        return true;
    }

    // update by name fehlt

    private Debts transformEntity(DebtsEntity debtsEntity) {
        return new Debts(
                debtsEntity.getId(),
                debtsEntity.getDebtorFirstName(),
                debtsEntity.getDebts(),
                debtsEntity.getDateOfDebt()
        );
    }
}