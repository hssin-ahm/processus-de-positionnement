package io.redleanServices.positionnement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redleanServices.positionnement.dao.EntretienClientRepository;
import io.redleanServices.positionnement.entity.EntretienClient;
import io.redleanServices.positionnement.entity.EntretienPartenaire;



@Service 
public class EntretienClientServicelmpl  implements EntretienClientService{

	@Autowired
	EntretienClientRepository entretienClientRepository;
	
	@Override
	public EntretienClient saveEntretienClient(EntretienClient ec) {
		return entretienClientRepository.save(ec);

	}

	@Override
	public void deleteEntretienClient(EntretienClient ec) {
		// TODO Auto-generated method stub
		entretienClientRepository.delete(ec);

		
	}

	@Override
	public void deleteEntretienClientById(Long id) {
		entretienClientRepository.deleteById(id);
		
	}

	@Override
	public EntretienClient getEntretienClient(Long id) {
		// TODO Auto-generated method stub
		return entretienClientRepository.findById(id).get();

	}

	@Override
	public List<EntretienClient> getAllEntretienClients() {
		List<EntretienClient> Categorys =(List<EntretienClient>) entretienClientRepository.findAll();
		for(EntretienClient Category:Categorys) {
			System.out.println(Category);
		}
		return Categorys;
	}

	@Override
	public EntretienClient updateEntretienClient(EntretienClient adv, Long idAd) {
		EntretienClient a = adv;
		return entretienClientRepository.save(adv);
	}

	@Override
	public EntretienClient updateEntretienClient(EntretienClient p) {
		return entretienClientRepository.save(p);

	}

	@Override
	public List<EntretienClient> getAllEntretiensByConsultantId(Long id) {
		return entretienClientRepository.findAllByConsultantId(id);
	}

}
