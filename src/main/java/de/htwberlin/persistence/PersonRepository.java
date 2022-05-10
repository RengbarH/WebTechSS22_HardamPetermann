package de.htwberlin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository {

    List<PersonEntity> findAllByFirstname(String firstname);

}
