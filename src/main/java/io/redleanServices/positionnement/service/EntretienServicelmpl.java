package io.redleanServices.positionnement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redleanServices.positionnement.dao.EntretienRepository;
import io.redleanServices.positionnement.entity.CvEnvoyee;
import io.redleanServices.positionnement.entity.EntretienPartenaire;

@Service 
public class EntretienServicelmpl  implements EntretienService{

	@Autowired
	EntretienRepository entretienRepository;
	
	@Override
	public EntretienPartenaire saveEntretien(EntretienPartenaire e) {
		return entretienRepository.save(e);
	}

	@Override
	public void deleteEntretien(EntretienPartenaire e) {
		 entretienRepository.delete(e);
		
	}

	@Override
	public void deleteEntretienById(Long id) {
		entretienRepository.deleteById(id);

		
	}

	@Override
	public EntretienPartenaire getEntretien(Long id) {
		return entretienRepository.findById(id).get();

	}

	@Override
	public List<EntretienPartenaire> getAllEntretiens() {
		List<EntretienPartenaire> Categorys =(List<EntretienPartenaire>) entretienRepository.findAll();
		for(EntretienPartenaire Category:Categorys) {
			System.out.println(Category);
		}
		return Categorys;
	}

	@Override
	public EntretienPartenaire updateEntretien(EntretienPartenaire adv, Long idAd) {
		EntretienPartenaire a = adv;
		return entretienRepository.save(a);
	}

	@Override
	public EntretienPartenaire updateEntretien(EntretienPartenaire p) {
		return entretienRepository.save(p);
	}
	
	@Override
	public List<EntretienPartenaire> getAllEntretiensByConsultantId(Long id) {
		return entretienRepository.findAllByConsultantId(id);
	}
	@Override
	public EntretienPartenaire getAllEntretiensByCvId(Long id) {
		return entretienRepository.findByCvEnvoyeeIdcv(id);
	}

}
