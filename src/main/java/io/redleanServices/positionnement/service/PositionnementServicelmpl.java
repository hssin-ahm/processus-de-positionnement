package io.redleanServices.positionnement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redleanServices.positionnement.dao.PositionnementRepository;
import io.redleanServices.positionnement.entity.Positionnement;


@Service 
public class PositionnementServicelmpl  implements PositionnementService{
	@Autowired
	PositionnementRepository positionnementRepository ;
	@Override
	public Positionnement savePositionnement(Positionnement b) {
		return positionnementRepository.save(b);

	}

	@Override
	public void deletePositionnement(Positionnement b) {
		// TODO Auto-generated method stub
		positionnementRepository.delete(b);		

		
	}

	@Override
	public void deletePositionnementById(Long id) {
		// TODO Auto-generated method stub
		positionnementRepository.deleteById(id);

		
	}

	@Override
	public Positionnement getPositionnement(Long id) {
		return positionnementRepository.findById(id).get();

	}

	@Override
	public List<Positionnement> getAllPositionnements() {
		List<Positionnement> Categorys =(List<Positionnement>) positionnementRepository.findAll();
		for(Positionnement Category:Categorys) {
			System.out.println(Category);
		}
		return Categorys;
	}

	@Override
	public Positionnement updatePositionnement(Positionnement adv, Long idAd) {
		Positionnement a = adv;
		return positionnementRepository.save(a);
	}

	@Override
	public Positionnement updateBriefing(Positionnement p) {
		return positionnementRepository.save(p);

	}
	@Override
	public List<Positionnement> getAllEntretiensByConsultantId(Long consultantId) {
		return positionnementRepository.findAllByConsultantId(consultantId);
	}

}
