package io.redleanServices.positionnement.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redleanServices.positionnement.dao.PartenaireRepository;
import io.redleanServices.positionnement.entity.partenaire;


@Service 
public class PartenaireSerivelmpl  implements partenaireService{
	@Autowired
	PartenaireRepository partenaireRepository;
	
	@Override
	public partenaire savePartenaire(partenaire p) {
		return partenaireRepository.save(p);
	}

	@Override
	public void deletePartenaire(partenaire p) {
		partenaireRepository.delete(p);		
	}

	@Override
	public void deletePartenaireById(Long id) {
		partenaireRepository.deleteById(id);
		
	}

	@Override
	public partenaire getPartenaire(Long id) {
		return partenaireRepository.findById(id).get();
	}

	@Override
	public List<partenaire> getAllPartenaires() {
		List<partenaire> Categorys =(List<partenaire>) partenaireRepository.findAll();
		for(partenaire Category:Categorys) {
			System.out.println(Category);
		}
		return Categorys;
	}

	@Override
	public partenaire updatePartenaire(partenaire adv, Long idAd) {
		partenaire a = adv;
		return partenaireRepository.save(a);
	}
	
	@Override
	public partenaire updatePartenaire(partenaire p) {
		return partenaireRepository.save(p);
	}
}
