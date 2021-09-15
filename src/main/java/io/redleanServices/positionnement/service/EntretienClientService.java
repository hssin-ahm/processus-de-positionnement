package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.EntretienClient;
import io.redleanServices.positionnement.entity.EntretienPartenaire;


public interface EntretienClientService {
	EntretienClient saveEntretienClient(EntretienClient ec);
	void deleteEntretienClient(EntretienClient ec);
	void deleteEntretienClientById(Long id);
	EntretienClient getEntretienClient(Long id);
	List<EntretienClient> getAllEntretienClients();
	EntretienClient updateEntretienClient(EntretienClient adv, Long idAd) ;
	EntretienClient updateEntretienClient(EntretienClient p) ;
	List<EntretienClient> getAllEntretiensByConsultantId(Long id);
	EntretienClient getEntretienClientByCvId(Long id);
}
