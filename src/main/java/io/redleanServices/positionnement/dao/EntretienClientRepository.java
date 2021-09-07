package io.redleanServices.positionnement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.EntretienClient;
import io.redleanServices.positionnement.entity.EntretienPartenaire;


@Repository
public interface EntretienClientRepository extends JpaRepository<EntretienClient,Long>{

	List<EntretienClient> findAllByConsultantId(Long id);

}
