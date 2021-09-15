package io.redleanServices.positionnement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redleanServices.positionnement.dao.ClientRepository;
import io.redleanServices.positionnement.entity.EntretienClient;
import io.redleanServices.positionnement.entity.Positionnement;
import io.redleanServices.positionnement.entity.client;

@Service 
public class ClientServicelmpl implements ClientService {
	@Autowired
	ClientRepository clientRepository;
	
	
	@Override
	public client saveclient(client c) {
		return clientRepository.save(c);

	}

	@Override
	public void deleteclient(client c) {
		// TODO Auto-generated method stub
		clientRepository.delete(c);		

		
	}

	@Override
	public void deleteclientById(Long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);

		
	}

	@Override
	public client getclient(Long id) {
		return clientRepository.findById(id).get();

	}

	@Override
	public List<client> getAllclients() {
		List<client> Categorys =(List<client>) clientRepository.findAll();
		for(client Category:Categorys) {
			System.out.println(Category);
		}
		return Categorys;
	}

	@Override
	public client updateclient(client adv, Long idAd) {
		client a = adv;
		return clientRepository.save(a);
	}

	@Override
	public client updateclient(client p) {
		return clientRepository.save(p);

	}


}
