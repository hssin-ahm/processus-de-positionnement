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

import io.redleanServices.positionnement.dao.CvEnvoyeeRepository;
import io.redleanServices.positionnement.dao.PositionnementRepository;
import io.redleanServices.positionnement.entity.Consultant;
import io.redleanServices.positionnement.entity.CvEnvoyee;
import io.redleanServices.positionnement.entity.EntretienPartenaire;
import io.redleanServices.positionnement.entity.Positionnement;
import io.redleanServices.positionnement.service.ConsultantServiceImpl;
import io.redleanServices.positionnement.service.PositionnementServicelmpl;


@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/positionnement")
public class RestControlPositionnement {
	@Autowired
	PositionnementRepository positionnementRepository;
	@Autowired
	PositionnementServicelmpl positionnementServicelmpl;
	
	@Autowired 
	ConsultantServiceImpl consultantService;

	@Autowired 
	CvEnvoyeeRepository cvEnvoyeeRepository;
	
	@GetMapping("/getPositionnementByCvId/{id}") 
	@ResponseBody 
	
	 public Positionnement getPositionnementByCvId(@PathVariable("id") Long id) { 
		
		 Positionnement positionnement = positionnementServicelmpl.getAllPositionnementByCvId(id);
		
		 return positionnement; 
	} 
	
	@PostMapping("/ajouterPositionnement/{id}/{consultantId}")
	@ResponseBody
	public Positionnement saveEntretien(@RequestBody Positionnement e, @PathVariable("id") Long id, @PathVariable("consultantId") Long consultantId)
	{
		Consultant consultant = consultantService.findEmployeeById(consultantId);
		Optional<CvEnvoyee> cvEnvoyee = cvEnvoyeeRepository.findById(id);
		e.setConsultant(consultant);
		e.setCvEnvoyee(cvEnvoyee.get());
		positionnementServicelmpl.savePositionnement(e);
		return e;
	}
	
	@PutMapping(value = "/modifyidPositionnement/{id}/{consultantId}") 
	 @ResponseBody 
	 
		public Positionnement updateEntretien(@RequestBody Positionnement e, @PathVariable("id") Long id, @PathVariable("consultantId") Long consultantId) 
		{ 	 
		Consultant consultant = consultantService.findEmployeeById(consultantId);
		Optional<CvEnvoyee> cvEnvoyee = cvEnvoyeeRepository.findById(id);
		e.setConsultant(consultant);
		e.setCvEnvoyee(cvEnvoyee.get());
		positionnementServicelmpl.updatePositionnement(e);
	 	return e;
		}
	
		@PostMapping("/ajouterPositionnement/{consultantId}")
		@ResponseBody
		public Positionnement savePositionnement(@RequestBody Positionnement e, @PathVariable("consultantId") Long consultantId)
		{
			Consultant consultant = consultantService.findEmployeeById(consultantId);
			e.setConsultant(consultant);
			positionnementServicelmpl.savePositionnement(e);
			return e;
		}
		
		@GetMapping("/get-all-Positionnements") 
		@ResponseBody 
		
		 public List<Positionnement> getAllPositionnement() { 
			
			 List<Positionnement> list = positionnementServicelmpl.getAllPositionnements();
			 return list; 
		} 
		

		@DeleteMapping("/deletep/{idPositionnement}") 
		@ResponseBody 
		void deleteidPositionnementtById(@PathVariable("idPositionnement") Long idPositionnement){ 
			positionnementServicelmpl.deletePositionnementById(idPositionnement);
			}  
		@PutMapping("/modifyidPositionnement") 
		 @ResponseBody 
		 
			public Positionnement updatePositionnement(@RequestBody Positionnement e) 
			{ 	 
	    	
	   		 return positionnementServicelmpl.updateBriefing(e);
	 	}
		
		   @GetMapping(value = "/Positionnements/{idPositionnement}")
		    public Optional<Positionnement> afficherUnPositionnement(@PathVariable Long idPositionnement) {
		        return  positionnementRepository.findById(idPositionnement);
		    }
		   

		    
		    @GetMapping(value = "/Positionnementss/{idPositionnement}")
		    @ResponseBody
		 	
		 	public Positionnement findPositionnement(@PathVariable("idPositionnement") Long idPositionnement)
		 	     {
		 			return positionnementServicelmpl.getPositionnement(idPositionnement);
		 		 }
		  
		    @GetMapping("/get-all-Positionnements/{consultantId}") 
			@ResponseBody 
			
			 public List<Positionnement> getAllPositionnementByConsId(@PathVariable("consultantId") Long consultantId) { 
				
				 List<Positionnement> list = positionnementServicelmpl.getAllEntretiensByConsultantId(consultantId);
				 return list; 
			} 
}
