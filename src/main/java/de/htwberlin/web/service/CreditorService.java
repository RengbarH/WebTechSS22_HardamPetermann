package de.htwberlin.web.service;


import de.htwberlin.web.api.Creditor;
import de.htwberlin.web.api.CreditorManipulationRequest;
import de.htwberlin.web.persistence.CreditorEntity;
import de.htwberlin.web.persistence.CreditorRepository;
import de.htwberlin.web.persistence.DebtsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CreditorService {

    private final CreditorRepository creditorRepository;

    public CreditorService(CreditorRepository creditorRepository) {
        this.creditorRepository = creditorRepository;
    }

    public List<Creditor> findAll() {
        List<CreditorEntity> creditor = creditorRepository.findAll();
        return creditor.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Creditor findById(long id) {
        var creditorEntity = creditorRepository.findById(id);
        return creditorEntity.map(this::transformEntity).orElse(null);
    }

    public Creditor create(CreditorManipulationRequest request) {
        String uuiIdentifier = UUID.randomUUID().toString();
        var creditorEntity = new CreditorEntity(request.getFirstName(), request.getLastName(), uuiIdentifier);
        creditorEntity = creditorRepository.save(creditorEntity);
        return transformEntity(creditorEntity);
    }

    public Creditor update(Long id, CreditorManipulationRequest request) {
        var creditorEntityOptional = creditorRepository.findById(id);
        if (creditorEntityOptional.isEmpty()) {
            return null;
        }

        var creditorEntity = creditorEntityOptional.get();
        creditorEntity.setFirstName(request.getFirstName());
        creditorEntity.setLastName(request.getLastName());
        creditorEntity = creditorRepository.save(creditorEntity);
        return transformEntity(creditorEntity);
    }

    public boolean deleteById(Long id) {
        if (!creditorRepository.existsById(id)) {
            return false;
        }

        creditorRepository.deleteById(id);
        return true;
    }

    private Creditor transformEntity(CreditorEntity creditorEntity) {
        return new Creditor(
                creditorEntity.getId(),
                creditorEntity.getFirstName(),
                creditorEntity.getLastName(),
                creditorEntity.getIdentifier(),
                creditorEntity.getDebtor().stream().map(DebtsEntity::getId).collect(Collectors.toList())
        );
    }
}
