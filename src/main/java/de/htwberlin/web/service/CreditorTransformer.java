package de.htwberlin.web.service;

import de.htwberlin.web.api.Creditor;
import de.htwberlin.web.persistence.CreditorEntity;
import de.htwberlin.web.persistence.DebtsEntity;
import de.htwberlin.web.persistence.Gender;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CreditorTransformer {
    public Creditor transformEntity(CreditorEntity creditorEntity) {
        var gender = creditorEntity.getGender() != null ? creditorEntity.getGender().name() : Gender.UNKNOWN.name();
        return new Creditor(
                creditorEntity.getId(),
                creditorEntity.getFirstName(),
                creditorEntity.getLastName(),
                creditorEntity.getIdentifier(),
                gender,
                creditorEntity.getDebtor().stream().map(DebtsEntity::getId).collect(Collectors.toList())
        );
    }
}
