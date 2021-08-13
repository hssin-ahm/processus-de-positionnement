package io.redleanServices.positionnement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redleanServices.positionnement.dao.EntretienRepository;
import io.redleanServices.positionnement.entity.Entretien;

@Service 
public class EntretienServicelmpl  implements EntretienService{

	@Autowired
	EntretienRepository entretienRepository;
	
	@Override
	public Entretien saveEntretien(Entretien e) {
		return entretienRepository.save(e);
	}

	@Override
	public void deleteEntretien(Entretien e) {
		 entretienRepository.delete(e);
		
	}

	@Override
	public void deleteEntretienById(Long id) {
		entretienRepository.deleteById(id);

		
	}

	@Override
	public Entretien getEntretien(Long id) {
		return entretienRepository.findById(id).get();

	}

	@Override
	public List<Entretien> getAllEntretiens() {
		List<Entretien> Categorys =(List<Entretien>) entretienRepository.findAll();
		for(Entretien Category:Categorys) {
			System.out.println(Category);
		}
		return Categorys;
	}

	@Override
	public Entretien updateEntretien(Entretien adv, Long idAd) {
		Entretien a = adv;
		return entretienRepository.save(a);
	}

	@Override
	public Entretien updateEntretien(Entretien p) {
		return entretienRepository.save(p);
	}

}
