package io.redleanServices.positionnement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.Entretien;


@Repository
public interface EntretienRepository extends JpaRepository<Entretien,Long> {

}
