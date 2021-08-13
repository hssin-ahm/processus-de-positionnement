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

import io.redleanServices.positionnement.service.ValidationServiceImpl;
import io.redleanServices.positionnement.dao.ValidationRepository;
import io.redleanServices.positionnement.entity.Validation;

@RestController
@RequestMapping("Validation")
public class RestControlValidation {
	@Autowired 
	ValidationRepository ValidationRepository;
	
	@Autowired 
	ValidationServiceImpl validationServiceImpl;
	/*
	{ "feedback": "ey",
    "mesuresTeletravail": "lo",
    "demarrageMission": "u"}
    */

//http://localhost:8081/SpringMVC/servlet/Validation/ajouterValidation
	@PostMapping("/ajouterValidation")
	@ResponseBody
	public Validation saveValidation(@RequestBody Validation ec)
	{
		validationServiceImpl.saveValidation(ec);
		return ec;
	}
	
	//http://localhost:8081/SpringMVC/servlet/Validation/get-all-validations
	@GetMapping("/get-all-validations") 
	@ResponseBody 
	
	 public List<Validation> getAllValidations() { 
		
		 List<Validation> list = validationServiceImpl.getAllValidations();
		 return list; 
	} 
	

	
//http://localhost:8081/SpringMVC/servlet/Validation//deleteV/2s
	@DeleteMapping("/deleteV/{idValidation}") 
	@ResponseBody 
	void deleteValidationById(@PathVariable("idValidation") Long idValidation){ 
		validationServiceImpl.deleteValidationById(idValidation);
		}  


	
//http://localhost:8081/SpringMVC/servlet/Validation/modifyididValidation
	@PutMapping("/modifyididValidation") 
	 @ResponseBody 
	 
		public Validation updateValidation(@RequestBody Validation ec) 
		{ 	 
    	
   		 return validationServiceImpl.updateValidation(ec);
 	}
	

//http://localhost:8081/SpringMVC/servlet/Validation/idValidations/1
	   @GetMapping(value = "/idValidations/{idValidation}")
	    public Optional<Validation> afficherUnValidation(@PathVariable Long idValidation) {
	        return ValidationRepository.findById(idValidation);
	    }
	   

	    
/*

	    @GetMapping(value = "/EntretienClients/{idEntretienClient}")
	    @ResponseBody
	 	
	 	public EntretienClient findproduct (@PathVariable("idEntretienClient") Long idEntretienClient)
	 	     {
	 			return entretienClientServicelmpl.getEntretienClient(idEntretienClient);
	 		 }
	    
	    

	    
	   
*/


}
