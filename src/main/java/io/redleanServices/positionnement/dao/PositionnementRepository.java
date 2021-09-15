package io.redleanServices.positionnement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.Positionnement;


@Repository
public interface PositionnementRepository extends JpaRepository<Positionnement, Long> {

	List<Positionnement> findAllByConsultantId(Long consultantId);

	Positionnement findByCvEnvoyeeIdcv(Long id);

}
