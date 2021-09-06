package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.Positionnement;




public interface PositionnementService {
	Positionnement savePositionnement(Positionnement b);
	void deletePositionnement(Positionnement b);
	void deletePositionnementById(Long id);
	Positionnement getPositionnement(Long id);
	List<Positionnement> getAllPositionnements();
	Positionnement updatePositionnement(Positionnement adv, Long idAd) ;
	Positionnement updateBriefing(Positionnement p) ;
	List<Positionnement> getAllEntretiensByConsultantId(Long consultantId);
}
