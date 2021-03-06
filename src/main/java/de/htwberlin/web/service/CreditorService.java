package de.htwberlin.web.service;


import de.htwberlin.web.api.Creditor;
import de.htwberlin.web.api.CreditorManipulationRequest;
import de.htwberlin.web.persistence.CreditorEntity;
import de.htwberlin.web.persistence.CreditorRepository;
import de.htwberlin.web.persistence.Gender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CreditorService {

    private final CreditorRepository creditorRepository;
    private final CreditorTransformer creditorTransformer;

    public CreditorService(CreditorRepository creditorRepository, CreditorTransformer creditorTransformer) {
        this.creditorRepository = creditorRepository;
        this.creditorTransformer = creditorTransformer;
    }

    public List<Creditor> findAll() {
        List<CreditorEntity> creditor = creditorRepository.findAll();
        return creditor.stream()
                .map(creditorTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Creditor findById(long id) {
        var creditorEntity = creditorRepository.findById(id);
        return creditorEntity.map(creditorTransformer::transformEntity).orElse(null);
    }

    public Creditor create(CreditorManipulationRequest request) {
        var gender = Gender.valueOf(request.getGender());
        String uuiIdentifier = UUID.randomUUID().toString();
        var creditorEntity = new CreditorEntity(request.getFirstName(), request.getLastName(), uuiIdentifier, gender);
        creditorEntity = creditorRepository.save(creditorEntity);
        return creditorTransformer.transformEntity(creditorEntity);
    }

    public Creditor update(Long id, CreditorManipulationRequest request) {
        var creditorEntityOptional = creditorRepository.findById(id);
        if (creditorEntityOptional.isEmpty()) {
            return null;
        }

        var creditorEntity = creditorEntityOptional.get();
        creditorEntity.setFirstName(request.getFirstName());
        creditorEntity.setLastName(request.getLastName());
//        creditorEntity.setIdentifier(request.getIdentifier());
        creditorEntity.setGender(Gender.valueOf(request.getGender()));
        creditorEntity = creditorRepository.save(creditorEntity);
        return creditorTransformer.transformEntity(creditorEntity);
    }

    public boolean deleteById(Long id) {
        if (!creditorRepository.existsById(id)) {
            return false;
        }

        creditorRepository.deleteById(id);
        return true;
    }
}
