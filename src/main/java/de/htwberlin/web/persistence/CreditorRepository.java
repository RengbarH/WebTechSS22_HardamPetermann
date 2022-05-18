package de.htwberlin.web.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditorRepository extends JpaRepository<CreditorEntity, Long> {

    List<CreditorEntity> findAllByFirstName(String firstName);

}
