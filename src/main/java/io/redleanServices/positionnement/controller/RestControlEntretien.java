package io.redleanServices.positionnement.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import io.redleanServices.positionnement.entity.Entretien;
import io.redleanServices.positionnement.service.EntretienServicelmpl;

@RestController
@RequestMapping("Entretien")
public class RestControlEntretien {
	@Autowired 
	EntretienRepository entretienRepository;
	
	@Autowired 
	EntretienServicelmpl entretienServicelmpl;
	


	
	/*
	 * {
    
    "typeEntretien": "nesr",
    "remarque": "ee",
    "dateEntretien":null,
    "tjm": 22
}*/
	//http://localhost:8081/SpringMVC/servlet/Entretien/ajouterEntretien

	@PostMapping("/ajouterEntretien")
	@ResponseBody
	public Entretien saveEntretien(@RequestBody Entretien e)
	{
		entretienServicelmpl.saveEntretien(e);
		return e;
	}
	
	
	
	//http://localhost:8081/SpringMVC/servlet/Entretien/get-all-Entretiens
	@GetMapping("/get-all-Entretiens") 
	@ResponseBody 
	
	 public List<Entretien> getAllEntretiens() { 
		
		 List<Entretien> list = entretienServicelmpl.getAllEntretiens();
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
	 
		public Entretien updateEntretien(@RequestBody Entretien e) 
		{ 	 
    	
   		 return entretienServicelmpl.updateEntretien(e);
 	}
	
	

	//http://localhost:8081/SpringMVC/servlet/Entretien/Contacts/1
	   @GetMapping(value = "/Contacts/{idEntretien}")
	    public Optional<Entretien> afficherUnEntretien(@PathVariable Long idEntretien) {
	        return  entretienRepository.findById(idEntretien);
	    }
	   

	    
//http://localhost:8081/SpringMVC/servlet/Entretien/contacts/1
	    @GetMapping(value = "/contacts/{idEntretien}")
	    @ResponseBody
	 	
	 	public Entretien findEntretien(@PathVariable("idEntretien") Long idEntretien)
	 	     {
	 			return entretienServicelmpl.getEntretien(idEntretien);
	 		 }
	    
	    

}
