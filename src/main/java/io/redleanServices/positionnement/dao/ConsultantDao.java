package io.redleanServices.positionnement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.redleanServices.positionnement.entity.Consultant;

import java.util.Optional;

public interface ConsultantDao extends JpaRepository<Consultant, Long> {
    void deleteEmployeeById(Long id);

    Optional<Consultant> findConsultantById(Long id);
}
