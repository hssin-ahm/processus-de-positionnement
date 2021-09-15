package io.redleanServices.positionnement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.redleanServices.positionnement.dao.ClientRepository;
import io.redleanServices.positionnement.dao.CvEnvoyeeRepository;
import io.redleanServices.positionnement.entity.Consultant;
import io.redleanServices.positionnement.entity.CvEnvoyee;
import io.redleanServices.positionnement.entity.EntretienClient;
import io.redleanServices.positionnement.entity.Positionnement;
import io.redleanServices.positionnement.entity.client;
import io.redleanServices.positionnement.service.ClientServicelmpl;
import io.redleanServices.positionnement.service.ConsultantServiceImpl;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/client")
public class RestControlClient {

	@Autowired 
	ClientRepository clientRepository;
	
	@Autowired 
	ClientServicelmpl clientServicelmpl;
	
	
	
	@PostMapping("/ajouterClient")
	@ResponseBody
	public client saveClient(@RequestBody client c)
	{
		return clientServicelmpl.saveclient(c);
		
	}
	
	
	@GetMapping("/get-all-clients") 
	@ResponseBody 
	
	 public List<client> getAllclients() { 
		
		 List<client> list = clientServicelmpl.getAllclients();
		 return list; 
	} 
	

	

		@DeleteMapping("/deleteC/{idclient}") 
		@ResponseBody 
		void deleteclientById(@PathVariable("idclient") Long idclient){ 
			clientServicelmpl.deleteclientById(idclient);
			}  
	
		 @PutMapping("/modifyidClient") 
		 @ResponseBody 
		 
			public client updateProduit(@RequestBody client c) 
			{ 	 
			
			 return clientServicelmpl.updateclient(c);
		 }
		

	   @GetMapping(value = "/Clients/{idclient}")
	    public Optional<client> afficherUnclient(@PathVariable Long idclient) {
	        return  clientRepository.findById(idclient);
	    }
	   

	    

	    @GetMapping(value = "/clientts/{idclient}")
	    @ResponseBody
	 	
	 	public client findClient(@PathVariable("idclient") Long idclient)
	 	     {
	 			return clientServicelmpl.getclient(idclient);
	 		 }
	    
	  

}
