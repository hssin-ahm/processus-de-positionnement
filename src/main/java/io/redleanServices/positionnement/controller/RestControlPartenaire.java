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

import io.redleanServices.positionnement.dao.PartenaireRepository;
import io.redleanServices.positionnement.entity.partenaire;
import io.redleanServices.positionnement.service.PartenaireSerivelmpl;





@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("Partenaire")
public class RestControlPartenaire   {

	@Autowired 
	PartenaireRepository partenaireRepository;
	
	@Autowired 
	PartenaireSerivelmpl partenaireSerivelmpl;
	


	
	
	/*
	 * {   "idPartenaire":4,
    "nomsociete": "eee",
    "post": "ee",
    "telephone": 14,
    "mail": "nnn",
    "contact": "Hello",
    "remarque": "nnn",
    "tjm": 25
}*/
	//http://localhost:8081/SpringMVC/servlet/Partenaire/ajouterPartenaire
	@PostMapping("/ajouterPartenaire")
	@ResponseBody
	public partenaire saveCategory(@RequestBody partenaire p)
	{
		partenaireSerivelmpl.savePartenaire(p);
		return p;
	}
	
	
	
	//http://localhost:8081/SpringMVC/servlet/Partenaire/get-all-Partenaires
	@GetMapping("/get-all-Partenaires") 
	@ResponseBody 
	
	 public List<partenaire> getAllPartenaires() { 
		
		 List<partenaire> list = partenaireSerivelmpl.getAllPartenaires(); 
		 return list; 
	} 
	

	

	
	//http://localhost:8081/SpringMVC/servlet/Partenaire/deletePa/4
	@DeleteMapping("/deletePa/{idPartenaire}") 
	@ResponseBody 
	void deletePartenaireById(@PathVariable("idPartenaire") Long idPartenaire){ 
		partenaireSerivelmpl.deletePartenaireById(idPartenaire);
		}  


	

	//http://localhost:8081/SpringMVC/servlet/Partenaire/modifyidPartenaire
	/*
	 * {   "idPartenaire":2,
    "nomsociete": "eee",
    "post": "ee",
    "telephone": 14,
    "mail": "nnn",
    "contact": "Hello",
    "remarque": "nnn",
    "tjm": 25
}
	}*/
	@PutMapping("/modifyidPartenaire") 
	 @ResponseBody 
	 
		public partenaire updateProduit(@RequestBody partenaire e) 
		{ 	 
    	
   		 return partenaireSerivelmpl.updatePartenaire(e);
 	}
	
	

	 //http://localhost:8081/SpringMVC/servlet/Partenaire/Partenaires/1
	   @GetMapping(value = "/Partenaires/{idPartenaire}")
	    public Optional<partenaire> afficherUnPartenaire(@PathVariable Long idPartenaire) {
	        return partenaireRepository.findById(idPartenaire);
	    }
	   

	    

         //afficher par id
	    //http://localhost:8081/SpringMVC/servlet/Partenaire/produitss/1
	    @GetMapping(value = "/produitss/{idPartenaire}")
	    @ResponseBody
	 	
	 	public partenaire findproduct (@PathVariable("idPartenaire") Long idPartenaire)
	 	     {
	 			return partenaireSerivelmpl.getPartenaire(idPartenaire);
	 		 }
	    
	    

	    
	   

	 
		}
