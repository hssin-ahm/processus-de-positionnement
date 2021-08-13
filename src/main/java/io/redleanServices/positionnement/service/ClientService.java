package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.client;


public interface ClientService {
	client saveclient(client c);
	void deleteclient(client c);
	void deleteclientById(Long id);
	client getclient(Long id);
	List<client> getAllclients();
	client updateclient(client adv, Long idAd) ;
	client updateclient(client p) ;

}
