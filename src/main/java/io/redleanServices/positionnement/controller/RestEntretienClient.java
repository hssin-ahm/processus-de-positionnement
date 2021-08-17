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

import io.redleanServices.positionnement.dao.EntretienClientRepository;
import io.redleanServices.positionnement.entity.EntretienClient;
import io.redleanServices.positionnement.service.EntretienClientServicelmpl;


@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/entretienClient")
public class RestEntretienClient {
	@Autowired 
	EntretienClientRepository entretienClientRepository;
	
	@Autowired 
	EntretienClientServicelmpl entretienClientServicelmpl;
	

/*
{

    "dateEntretienClient": null,
    "remarque": "zerth",
    "duree": null,
    "typeEntretienClient": "nn",
    "tjm": 1.0

}
*/
//http://localhost:8081/SpringMVC/servlet/EntretienClient/ajouterEntretienClient
	@PostMapping("/ajouterEntretienClient")
	@ResponseBody
	public EntretienClient saveEntretienClient(@RequestBody EntretienClient ec)
	{
		entretienClientServicelmpl.saveEntretienClient(ec);
		return ec;
	}
	
	
//http://localhost:8081/SpringMVC/servlet/EntretienClient/get-all-EntretienClients
	@GetMapping("/get-all-EntretienClients") 
	@ResponseBody 
	
	 public List<EntretienClient> getAllEntretienClients() { 
		
		 List<EntretienClient> list = entretienClientServicelmpl.getAllEntretienClients();
		 return list; 
	} 
	

	

	//http://localhost:8081/SpringMVC/servlet/EntretienClient/deleteEc/2
	@DeleteMapping("/deleteEc/{idEntretienClient}") 
	@ResponseBody 
	void deleteEntretienClientById(@PathVariable("idEntretienClient") Long idEntretienClient){ 
		entretienClientServicelmpl.deleteEntretienClientById(idEntretienClient);
		}  


	

//http://localhost:8081/SpringMVC/servlet/EntretienClient/modifyididEntretienClient
	@PutMapping("/modifyididEntretienClient") 
	 @ResponseBody 
	 
		public EntretienClient updateEntretienClient(@RequestBody EntretienClient ec) 
		{ 	 
    	
   		 return entretienClientServicelmpl.updateEntretienClient(ec);
 	}
	
	/*

	   @GetMapping(value = "/EntretienClients/{idEntretienClient}")
	    public Optional<EntretienClient> afficherUnEntretienClient(@PathVariable Long idEntretienClient) {
	        return entretienClientRepository.findById(idEntretienClient);
	    }
	   

	    


	    @GetMapping(value = "/EntretienClients/{idEntretienClient}")
	    @ResponseBody
	 	
	 	public EntretienClient findproduct (@PathVariable("idEntretienClient") Long idEntretienClient)
	 	     {
	 			return entretienClientServicelmpl.getEntretienClient(idEntretienClient);
	 		 }
	    
	    

	    
	   
*/

}
