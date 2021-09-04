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

import io.redleanServices.positionnement.dao.EntretienRepository;
import io.redleanServices.positionnement.entity.Consultant;
import io.redleanServices.positionnement.entity.EntretienPartenaire;
import io.redleanServices.positionnement.service.ConsultantServiceImpl;
import io.redleanServices.positionnement.service.EntretienServicelmpl;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/entretien")
public class RestControlEntretienPartenaire {
	@Autowired 
	EntretienRepository entretienRepository;
	
	@Autowired 
	EntretienServicelmpl entretienServicelmpl;
	
	@Autowired 
	ConsultantServiceImpl consultantService;


	
	/*
	 * {
    
    "typeEntretien": "nesr",
    "remarque": "ee",
    "dateEntretien":null,
    "tjm": 22
}*/
	//http://localhost:8081/SpringMVC/servlet/Entretien/ajouterEntretien

	@PostMapping("/ajouterEntretien/{idConsultant}")
	@ResponseBody
	public EntretienPartenaire saveEntretien(@RequestBody EntretienPartenaire e, @PathVariable("idConsultant") Long idConsultant)
	{
		//Consultant consultant = consultantService.findEmployeeById(idConsultant);
		//e.set
		entretienServicelmpl.saveEntretien(e);
		return e;
	}
	
	
	
	//http://localhost:8081/SpringMVC/servlet/Entretien/get-all-Entretiens
	@GetMapping("/get-all-Entretiens") 
	@ResponseBody 
	
	 public List<EntretienPartenaire> getAllEntretiens() { 
		
		 List<EntretienPartenaire> list = entretienServicelmpl.getAllEntretiens();
		 return list; 
	} 
	

	
//http://localhost:8081/SpringMVC/servlet/Entretien/deleteE/2
	
	@DeleteMapping("/deleteE/{idEntretien}") 
	@ResponseBody 
	void deletePartenaireById(@PathVariable("idEntretien") Long idEntretien){ 
		entretienServicelmpl.deleteEntretienById(idEntretien);
		}  


	
//http://localhost:8081/SpringMVC/servlet/Entretien/modifyidEntretien
	@PutMapping("/modifyidEntretien") 
	 @ResponseBody 
	 
		public EntretienPartenaire updateEntretien(@RequestBody EntretienPartenaire e) 
		{ 	 
    	
   		 return entretienServicelmpl.updateEntretien(e);
 	}
	
	

	//http://localhost:8081/SpringMVC/servlet/Entretien/Contacts/1
	   @GetMapping(value = "/Contacts/{idEntretien}")
	    public Optional<EntretienPartenaire> afficherUnEntretien(@PathVariable Long idEntretien) {
	        return  entretienRepository.findById(idEntretien);
	    }
	   

	    
//http://localhost:8081/SpringMVC/servlet/Entretien/contacts/1
	    @GetMapping(value = "/contacts/{idEntretien}")
	    @ResponseBody
	 	
	 	public EntretienPartenaire findEntretien(@PathVariable("idEntretien") Long idEntretien)
	 	     {
	 			return entretienServicelmpl.getEntretien(idEntretien);
	 		 }
	    
	    

}
