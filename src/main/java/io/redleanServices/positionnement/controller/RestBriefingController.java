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

import io.redleanServices.positionnement.dao.BriefingRepository;
import io.redleanServices.positionnement.dao.CvEnvoyeeRepository;
import io.redleanServices.positionnement.entity.Briefing;
import io.redleanServices.positionnement.entity.Consultant;
import io.redleanServices.positionnement.entity.CvEnvoyeContact;
import io.redleanServices.positionnement.entity.CvEnvoyee;
import io.redleanServices.positionnement.entity.Positionnement;
import io.redleanServices.positionnement.service.BriefingServicelmpl;
import io.redleanServices.positionnement.service.ConsultantServiceImpl;
import io.redleanServices.positionnement.service.CvEnvoyeeSercicelmpl;


@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/Briefing")
public class RestBriefingController {
	@Autowired 
	BriefingRepository briefingRepository;
	
	@Autowired 
	BriefingServicelmpl briefingServicelmpl;
	 
	@Autowired 
	ConsultantServiceImpl consultantService;
	
	@Autowired 
	CvEnvoyeeRepository cvEnvoyeeRepository;
	
	@GetMapping("/getBirefingByCvId/{id}") 
	@ResponseBody 
	
	 public Briefing getBirefingByCvId(@PathVariable("id") Long id) { 
		 Briefing briefing = briefingServicelmpl.getBriefingByCvId(id);
		 return briefing; 
	} 
	
	@PostMapping("/ajouterBriefing/{id}/{consultantId}")
	@ResponseBody
	public Briefing saveEntretien(@RequestBody Briefing e, @PathVariable("id") Long id, @PathVariable("consultantId") Long consultantId)
	{
		Consultant consultant = consultantService.findEmployeeById(consultantId);
		Optional<CvEnvoyee> cvEnvoyee = cvEnvoyeeRepository.findById(id);
		e.setConsultant(consultant);
		e.setCvEnvoyee(cvEnvoyee.get());
		briefingServicelmpl.saveBriefing(e);
		return e;
	}
	
	@PostMapping("/ajouterBriefing/{idConsultant}")
	@ResponseBody
	public Briefing saveBriefing(@RequestBody Briefing c, @PathVariable("idConsultant") Long idConsultant)
	{	
		Briefing b = new Briefing();
		b.setDateBriefing(c.getDateBriefing());
		b.setRemarque(c.getRemarque());
		b.setType(c.getType());
		b.setDure(c.getDure());
		
		Consultant consultant = consultantService.findEmployeeById(idConsultant);
		b.setConsultant(consultant);
		briefingServicelmpl.saveBriefing(b);

		b.setManyContact(c.getContact());
		briefingServicelmpl.saveBriefing(b);
		return b;
	}
	
	@PutMapping(value = "/modifyidBriefing/{id}/{consultantId}") 
	 @ResponseBody 
	 
		public Briefing updateEntretien(@RequestBody Briefing e, @PathVariable("id") Long id, @PathVariable("consultantId") Long consultantId) 
		{ 	 
		Consultant consultant = consultantService.findEmployeeById(consultantId);
		Optional<CvEnvoyee> cvEnvoyee = cvEnvoyeeRepository.findById(id);
		e.setConsultant(consultant);
		e.setCvEnvoyee(cvEnvoyee.get());
		briefingServicelmpl.updateBriefing(e);
	 	return e;
		}
	
	@PutMapping("/modifyidBriefing") 
	@ResponseBody 
	 
	public Briefing updateCvEnvoyee(@RequestBody Briefing c) 
	{ 	
		Briefing b = new Briefing();
		b.setIdBriefing(c.getIdBriefing());
		b.setDateBriefing(c.getDateBriefing());
		b.setRemarque(c.getRemarque());
		b.setType(c.getType());
		b.setDure(c.getDure());
		
		b.setManyContact(c.getContact());
		//Consultant consultant = consultantService.findEmployeeById(idConsultant);
		b.setConsultant(c.getConsultant());
		briefingServicelmpl.updateBriefing(b);

		
  		return b;
}
	
	@GetMapping("/get-all-Briefings") 
	@ResponseBody 
	
	 public List<Briefing> getAllBriefings() { 
		
		 List<Briefing> list = briefingServicelmpl.getAllBriefings();
		 return list; 
	} 
	

	

	@DeleteMapping("/deleteC/{idBriefing}") 
	@ResponseBody 
	void deleteidBriefingById(@PathVariable("idBriefing") Long idBriefing){ 
		briefingServicelmpl.deleteBriefingById(idBriefing);
		}  

 
	@GetMapping("/getBriefingsByConsId/{id}") 
	@ResponseBody 
	
	 public List<Briefing> getBriefingsByConsId(@PathVariable("id") Long id) { 
		
		 List<Briefing> list = briefingServicelmpl.getBriefingsByConsId(id);
		 return list; 
	} 
	
	
	   @GetMapping(value = "/Briefings/{idBriefing}")
	    public Optional<Briefing> afficherUnBriefing(@PathVariable Long idBriefing) {
	        return  briefingRepository.findById(idBriefing);
	    }
	   

	    

	    @GetMapping(value = "/idBriefinggs/{idBriefing}")
	    @ResponseBody
	 	
	 	public Briefing findBriefing(@PathVariable("idBriefing") Long idBriefing)
	 	     {
	 			return briefingServicelmpl.getBriefing(idBriefing);
	 		 }
	    
	    

	    

}
