package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.Entretien;


public interface EntretienService {
	Entretien saveEntretien(Entretien e);
		void deleteEntretien(Entretien e);
		void deleteEntretienById(Long id);
		Entretien getEntretien(Long id);
		List<Entretien> getAllEntretiens();
		Entretien updateEntretien(Entretien adv, Long idAd) ;
		Entretien updateEntretien(Entretien p) ;
}
