package io.redleanServices.positionnement.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import io.redleanServices.positionnement.dao.EntretienRepository;
import io.redleanServices.positionnement.entity.Consultant;
import io.redleanServices.positionnement.entity.CvEnvoyee;
import io.redleanServices.positionnement.entity.EntretienPartenaire;
import io.redleanServices.positionnement.service.ConsultantServiceImpl;
import io.redleanServices.positionnement.service.CvEnvoyeeSercicelmpl;
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

	@Autowired 
	CvEnvoyeeSercicelmpl cvEnvoyeeSercicelmpl;

	@Autowired 
	CvEnvoyeeRepository cvEnvoyeeRepository;
 
	@PostMapping("/ajouterEntretien/{id}/{consultantId}")
	@ResponseBody
	public EntretienPartenaire saveEntretien(@RequestBody EntretienPartenaire e, @PathVariable("id") Long id, @PathVariable("consultantId") Long consultantId)
	{
		Consultant consultant = consultantService.findEmployeeById(consultantId);
		Optional<CvEnvoyee> cvEnvoyee = cvEnvoyeeRepository.findById(id);
		e.setConsultant(consultant);
		e.setCvEnvoyee(cvEnvoyee.get());
		//entretienServicelmpl.saveEntretien(e);
		return e;
	}
	@PostMapping("/ajouterEntretien/{consultantId}")
	@ResponseBody
	public EntretienPartenaire saveEntretienByConsId(@RequestBody EntretienPartenaire e, @PathVariable("consultantId") Long consultantId)
	{
		Consultant consultant = consultantService.findEmployeeById(consultantId);
		e.setConsultant(consultant);
		entretienServicelmpl.saveEntretien(e);
		return e;
	}
	
	
	@GetMapping("/get-all-Entretiens") 
	@ResponseBody 
	
	 public List<EntretienPartenaire> getAllEntretiens() { 
		
		 List<EntretienPartenaire> list = entretienServicelmpl.getAllEntretiens();
		 return list; 
	} 
	
	@GetMapping("/getEntretienByCvId/{id}") 
	@ResponseBody 
	
	 public EntretienPartenaire getAllEntretiensByCvId(@PathVariable("id") Long id) { 
		
		 EntretienPartenaire entretienPartenaire = entretienServicelmpl.getAllEntretiensByCvId(id);
		
		 return entretienPartenaire; 
	} 
	
	@GetMapping("/get-all-Entretiens/{id}") 
	@ResponseBody 
	
	 public List<EntretienPartenaire> getAllEntretiensByConsultantId(@PathVariable("id") Long id) { 
		
		 List<EntretienPartenaire> list = entretienServicelmpl.getAllEntretiensByConsultantId(id);
		 return list; 
	} 

	
	
	@DeleteMapping("/deleteE/{idEntretien}") 
	@ResponseBody 
	void deletePartenaireById(@PathVariable("idEntretien") Long idEntretien){ 
		entretienServicelmpl.deleteEntretienById(idEntretien);
		}  


	
	@PutMapping(value = "/modifyidEntretien/{id}/{consultantId}") 
	 @ResponseBody 
	 
		public EntretienPartenaire updateEntretien(@RequestBody EntretienPartenaire e, @PathVariable("id") Long id, @PathVariable("consultantId") Long consultantId) 
		{ 	 
		Consultant consultant = consultantService.findEmployeeById(consultantId);
		Optional<CvEnvoyee> cvEnvoyee = cvEnvoyeeRepository.findById(id);
		e.setConsultant(consultant);
		e.setCvEnvoyee(cvEnvoyee.get());
	 	entretienServicelmpl.updateEntretien(e);
	 	return e;
		}
	
	

	   @GetMapping(value = "/Contacts/{idEntretien}")
	    public Optional<EntretienPartenaire> afficherUnEntretien(@PathVariable Long idEntretien) {
	        return  entretienRepository.findById(idEntretien);
	    }
	   

	    
	    @GetMapping(value = "/contacts/{idEntretien}")
	    @ResponseBody
	 	
	 	public EntretienPartenaire findEntretien(@PathVariable("idEntretien") Long idEntretien)
	 	     {
	 			return entretienServicelmpl.getEntretien(idEntretien);
	 		 }
	    
	    

}
