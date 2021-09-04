package io.redleanServices.positionnement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.EntretienPartenaire;


@Repository
public interface EntretienRepository extends JpaRepository<EntretienPartenaire,Long> {

}
