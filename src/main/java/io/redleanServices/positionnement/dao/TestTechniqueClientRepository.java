package io.redleanServices.positionnement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.TestTechniqueClient;

@Repository
public interface TestTechniqueClientRepository extends JpaRepository<TestTechniqueClient, Long>{

	List<TestTechniqueClient> findAllByConsultantId(Long id);

	TestTechniqueClient findByCvEnvoyeeIdcv(Long id);

}
