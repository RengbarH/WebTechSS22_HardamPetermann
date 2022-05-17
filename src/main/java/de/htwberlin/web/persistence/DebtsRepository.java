package de.htwberlin.web.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtsRepository extends JpaRepository<DebtsEntity, Long> {

    //List<DebtsEntity> findAllByGlaeubiger(Long id);
    //List<DebtsEntity> findAllByGlaeubiger(PersonEntity person);
}
