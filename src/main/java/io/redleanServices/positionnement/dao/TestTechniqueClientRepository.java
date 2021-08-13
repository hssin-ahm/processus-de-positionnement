package io.redleanServices.positionnement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.TestTechniqueClient;

@Repository
public interface TestTechniqueClientRepository extends JpaRepository<TestTechniqueClient, Long>{

}
