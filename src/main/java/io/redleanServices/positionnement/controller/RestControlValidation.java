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

import io.redleanServices.positionnement.service.ConsultantServiceImpl;
import io.redleanServices.positionnement.service.ValidationServiceImpl;
import io.redleanServices.positionnement.dao.ValidationRepository;
import io.redleanServices.positionnement.entity.Consultant;
import io.redleanServices.positionnement.entity.Positionnement;
import io.redleanServices.positionnement.entity.Validation;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/validation")
public class RestControlValidation {
	@Autowired 
	ValidationRepository ValidationRepository;
	
	@Autowired 
	ValidationServiceImpl validationServiceImpl;
	
	@Autowired 
	ConsultantServiceImpl consultantService;
	
	@PostMapping("/ajouterPositionnement/{consultantId}")
	@ResponseBody
	public Validation savePositionnement(@RequestBody Validation e, @PathVariable("consultantId") Long consultantId)
	{
		Consultant consultant = consultantService.findEmployeeById(consultantId);
		e.setConsultant(consultant);
		validationServiceImpl.saveValidation(e);
		return e;
	}
	
	@PostMapping("/ajouterValidation")
	@ResponseBody
	public Validation saveValidation(@RequestBody Validation ec)
	{
		validationServiceImpl.saveValidation(ec);
		return ec;
	}
	
	@GetMapping("/get-all-validations") 
	@ResponseBody 
	
	 public List<Validation> getAllValidations() { 
		
		 List<Validation> list = validationServiceImpl.getAllValidations();
		 return list; 
	} 
	@GetMapping("/get-all-validations/{consultantId}") 
	@ResponseBody 
	
	 public List<Validation> getAllPositionnementByConsId(@PathVariable("consultantId") Long consultantId) { 
		
		 List<Validation> list = validationServiceImpl.getAllEntretiensByConsultantId(consultantId);
		 return list; 
	} 

	
	@DeleteMapping("/deleteV/{idValidation}") 
	@ResponseBody 
	void deleteValidationById(@PathVariable("idValidation") Long idValidation){ 
		validationServiceImpl.deleteValidationById(idValidation);
		}  


	
	@PutMapping("/modifyididValidation") 
	 @ResponseBody 
	 
		public Validation updateValidation(@RequestBody Validation ec) 
		{ 	 
    	
   		 return validationServiceImpl.updateValidation(ec);
 	}
	

	   @GetMapping(value = "/idValidations/{idValidation}")
	    public Optional<Validation> afficherUnValidation(@PathVariable Long idValidation) {
	        return ValidationRepository.findById(idValidation);
	    }
	   



}
