package io.redleanServices.positionnement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.partenaire;



@Repository
public interface PartenaireRepository extends JpaRepository<partenaire, Long>  {

}
