package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.partenaire;



  public interface partenaireService {
	  partenaire savePartenaire(partenaire p);
		void deletePartenaire(partenaire p);
		void deletePartenaireById(Long id);
		partenaire getPartenaire(Long id);
		List<partenaire> getAllPartenaires();
		partenaire updatePartenaire(partenaire adv, Long idAd) ;
		 partenaire updatePartenaire(partenaire p) ;
}
