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
import io.redleanServices.positionnement.entity.Consultant;
import io.redleanServices.positionnement.entity.EntretienClient;
import io.redleanServices.positionnement.entity.EntretienPartenaire;
import io.redleanServices.positionnement.service.ConsultantServiceImpl;
import io.redleanServices.positionnement.service.EntretienClientServicelmpl;


@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/entretienClient")
public class RestEntretienClient {
	@Autowired 
	EntretienClientRepository entretienClientRepository;
	
	@Autowired 
	EntretienClientServicelmpl entretienClientServicelmpl;
	@Autowired 
	ConsultantServiceImpl consultantService;
 
	@PostMapping("/ajouterEntretienClient/{consultantId}")
	@ResponseBody
	public EntretienClient saveEntretienClient(@RequestBody EntretienClient ec, @PathVariable("consultantId") Long consultantId)
	{
		Consultant consultant = consultantService.findEmployeeById(consultantId);
		ec.setConsultant(consultant);
		entretienClientServicelmpl.saveEntretienClient(ec);
		return ec;
	}
	
	
	@GetMapping("/get-all-EntretienClients") 
	@ResponseBody 
	
	 public List<EntretienClient> getAllEntretienClients() { 
		
		 List<EntretienClient> list = entretienClientServicelmpl.getAllEntretienClients();
		 return list; 
	} 
	
	@GetMapping("/get-all-Entretiens/{id}") 
	@ResponseBody 
	
	 public List<EntretienClient> getAllEntretiensByConsultantId(@PathVariable("id") Long id) { 
		
		 List<EntretienClient> list = entretienClientServicelmpl.getAllEntretiensByConsultantId(id);
		 return list; 
	} 
	

	@DeleteMapping("/deleteEc/{idEntretienClient}") 
	@ResponseBody 
	void deleteEntretienClientById(@PathVariable("idEntretienClient") Long idEntretienClient){ 
		entretienClientServicelmpl.deleteEntretienClientById(idEntretienClient);
		}  


	

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
