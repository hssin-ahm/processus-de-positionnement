package io.redleanServices.positionnement.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redleanServices.positionnement.dao.TestTechniqueClientRepository;
import io.redleanServices.positionnement.entity.EntretienPartenaire;
import io.redleanServices.positionnement.entity.TestTechniqueClient;


@Service 
public class TestTechniqueClientServicelmpl  implements TestTechniqueClientService{

	
	@Autowired
	TestTechniqueClientRepository testTechniqueClientRepository;
	@Override
	public TestTechniqueClient saveTestTechniqueClient(TestTechniqueClient e) {
		return testTechniqueClientRepository.save(e);

	}

	@Override
	public void deleteTestTechniqueClient(TestTechniqueClient e) {
		// TODO Auto-generated method stub
		testTechniqueClientRepository.delete(e);

		
	}

	@Override
	public void deleteTestTechniqueClientById(Long id) {
		// TODO Auto-generated method stub
		testTechniqueClientRepository.deleteById(id);

		
	}

	@Override
	public TestTechniqueClient getTestTechniqueClient(Long id) {
		return testTechniqueClientRepository.findById(id).get();

	}

	@Override
	public List<TestTechniqueClient> getAllTestTechniqueClients() {
		List<TestTechniqueClient> Categorys =(List<TestTechniqueClient>) testTechniqueClientRepository.findAll();
		for(TestTechniqueClient Category:Categorys) {
			System.out.println(Category);
		}
		return Categorys;
	}

	@Override
	public TestTechniqueClient updateTestTechniqueClient(TestTechniqueClient adv, Long idAd) {
		TestTechniqueClient a = adv;
		return testTechniqueClientRepository.save(adv);
	}

	@Override
	public TestTechniqueClient updateEntretien(TestTechniqueClient p) {
		return testTechniqueClientRepository.save(p);

	}
	@Override
	public List<TestTechniqueClient> getAllEntretiensByConsultantId(Long id) {
		return testTechniqueClientRepository.findAllByConsultantId(id);
	}

	public TestTechniqueClient getTestTechniqueByCvId(Long id) {
		return testTechniqueClientRepository.findByCvEnvoyeeIdcv(id);
	}

}
