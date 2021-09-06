package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.CvEnvoyee;
import io.redleanServices.positionnement.entity.EntretienPartenaire;


public interface EntretienService {
	EntretienPartenaire saveEntretien(EntretienPartenaire e);
		void deleteEntretien(EntretienPartenaire e);
		void deleteEntretienById(Long id);
		EntretienPartenaire getEntretien(Long id);
		List<EntretienPartenaire> getAllEntretiens();
		EntretienPartenaire updateEntretien(EntretienPartenaire adv, Long idAd) ;
		EntretienPartenaire updateEntretien(EntretienPartenaire p) ;
		List<EntretienPartenaire> getAllEntretiensByConsultantId(Long id);
}
