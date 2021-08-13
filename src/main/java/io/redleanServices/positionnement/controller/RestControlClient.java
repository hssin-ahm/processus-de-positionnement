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
import io.redleanServices.positionnement.entity.client;
import io.redleanServices.positionnement.service.ClientServicelmpl;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("Client")
public class RestControlClient {

	@Autowired 
	ClientRepository clientRepository;
	
	@Autowired 
	ClientServicelmpl clientServicelmpl;
	

/*
{
 "prenom": "nn",
    "remarques": "bbb",
    "secteuractivite": "bbb",
    "datedenvoi": null,
    "intituleposte": "nn",
    "lieuMission": "nnn",
    "tjm": 0.0,
    "dureMission": null,
    "descriptif": null,
    "nom": "nn"
}
*/
	
	
//http://localhost:8081/SpringMVC/servlet/Client/ajouterClient
	@PostMapping("/ajouterClient")
	@ResponseBody
	public client saveClient(@RequestBody client c)
	{
		return clientServicelmpl.saveclient(c);
		
	}
	
	
	//http://localhost:8081/SpringMVC/servlet/Client/get-all-Clients
	@GetMapping("/get-all-Clients") 
	@ResponseBody 
	
	 public List<client> getAllclients() { 
		
		 List<client> list = clientServicelmpl.getAllclients();
		 return list; 
	} 
	

	

	//http://localhost:8081/SpringMVC/servlet/Client/deleteC/2s
	@DeleteMapping("/deleteC/{idclient}") 
	@ResponseBody 
	void deleteclientById(@PathVariable("idclient") Long idclient){ 
		clientServicelmpl.deleteclientById(idclient);
		}  
/*

{   "idclient":1,
    "prenom": "nn",
    "remarques": "bbb",
    "secteuractivite": "bbb",
    "datedenvoi": null,
    "intituleposte": "nn",
    "lieuMission": "nnn",
    "tjm": 0.0,
    "dureMission": null,
    "descriptif": null,
    "nom": "nn"
}

*/

//http://localhost:8081/SpringMVC/servlet/Client/modifyidClient
	@PutMapping("/modifyidClient") 
	 @ResponseBody 
	 
		public client updateProduit(@RequestBody client c) 
		{ 	 
    	
   		 return clientServicelmpl.updateclient(c);
 	}
	
	//http://localhost:8081/SpringMVC/servlet/Client/Clients/1

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
