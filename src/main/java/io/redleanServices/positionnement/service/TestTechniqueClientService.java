package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.TestTechniqueClient;



public interface TestTechniqueClientService {
	TestTechniqueClient saveTestTechniqueClient(TestTechniqueClient e);
	void deleteTestTechniqueClient(TestTechniqueClient e);
	void deleteTestTechniqueClientById(Long id);
	TestTechniqueClient getTestTechniqueClient(Long id);
	List<TestTechniqueClient> getAllTestTechniqueClients();
	TestTechniqueClient updateTestTechniqueClient(TestTechniqueClient adv, Long idAd) ;
	TestTechniqueClient updateEntretien(TestTechniqueClient p) ;
	List<TestTechniqueClient> getAllEntretiensByConsultantId(Long id);
}
