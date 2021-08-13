package io.redleanServices.positionnement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.Validation;

@Repository
public interface ValidationRepository extends JpaRepository<Validation, Long> {

}
