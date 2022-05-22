package de.htwberlin.web.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditorRepository extends JpaRepository<CreditorEntity, Long> {

    // Darf ich das -> Statt CreditorEntity den Creditor nehmen, da er im Service relevant ist als Datentyp?
    // List<CreditorEntity> findAllByFirstName(String firstName);


}
