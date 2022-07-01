package de.htwberlin.web.service;

import de.htwberlin.web.api.Debts;
import de.htwberlin.web.api.DebtsManipulationRequest;
import de.htwberlin.web.persistence.CreditorRepository;
import de.htwberlin.web.persistence.DebtsEntity;
import de.htwberlin.web.persistence.DebtsRepository;
import de.htwberlin.web.persistence.Gender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DebtService {

    private final DebtsRepository debtsRepository;
    private final CreditorRepository creditorRepository;
    private final DebtTransformer debtTransformer;

    public DebtService(DebtsRepository debtsRepository, CreditorRepository creditorRepository, DebtTransformer debtTransformer) {
        this.debtsRepository = debtsRepository;
        this.creditorRepository = creditorRepository;
        this.debtTransformer = debtTransformer;
    }


    public List<Debts> findAll() {
        List<DebtsEntity> debts = debtsRepository.findAll();
        return debts.stream()
                .map(debtTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Debts findById(long id) {
        var debtsEntity = debtsRepository.findById(id);
        return debtsEntity.map(debtTransformer::transformEntity).orElse(null);
    }

    public List<Debts> findByCreditor(long creditorId) {
        List<DebtsEntity> creditorListEntity = new ArrayList<>();
        List<DebtsEntity> debts = debtsRepository.findAll();
        for (DebtsEntity debt : debts) {
            if (debt.getCreditor().getId() == creditorId) {
                creditorListEntity.add(debt);
            }
        }
        return creditorListEntity.stream()
                .map(debtTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Debts create(DebtsManipulationRequest request) {
        var gender = Gender.valueOf(request.getGender());
        var creditor = creditorRepository.findById(request.getCreditorId()).orElseThrow();
        var debtsEntity = new DebtsEntity(
                request.getDebtorFirstName(),
                request.getDebts(),
                request.getDateOfDebt(),
                creditor,
                gender
        );
        debtsEntity = debtsRepository.save(debtsEntity);
        return debtTransformer.transformEntity(debtsEntity);
    }

    public Debts update(Long id, DebtsManipulationRequest request) {
        var debtsEntityOptional = debtsRepository.findById(id);
        if (debtsEntityOptional.isEmpty()) {
            return null;
        }
        var debtsEntity = debtsEntityOptional.get();
        debtsEntity.setDebtorFirstName(request.getDebtorFirstName());
        debtsEntity.setDebts(request.getDebts());
        debtsEntity.setGender(Gender.valueOf(request.getGender()));
        //debtsEntity.getDateOfDebt(request.getDateOfDebt()); <- das braucht man nicht, da sich das Datum nicht veraendert
        debtsEntity = debtsRepository.save(debtsEntity);

        return debtTransformer.transformEntity(debtsEntity);
    }

    public boolean deleteById(Long id) {
        if (!debtsRepository.existsById(id)) {
            return false;
        }
        debtsRepository.deleteById(id);
        return true;
    }
    // update by name fehlt

}
