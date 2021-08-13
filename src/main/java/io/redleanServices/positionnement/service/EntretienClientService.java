package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.EntretienClient;


public interface EntretienClientService {
	EntretienClient saveEntretienClient(EntretienClient ec);
	void deleteEntretienClient(EntretienClient ec);
	void deleteEntretienClientById(Long id);
	EntretienClient getEntretienClient(Long id);
	List<EntretienClient> getAllEntretienClients();
	EntretienClient updateEntretienClient(EntretienClient adv, Long idAd) ;
	EntretienClient updateEntretienClient(EntretienClient p) ;
}
