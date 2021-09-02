package io.redleanServices.positionnement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.CvEnvoyee;


@Repository
public interface CvEnvoyeeRepository extends JpaRepository<CvEnvoyee, Long> {

	List<CvEnvoyee> findAllByConsultantId(Long id);

}
