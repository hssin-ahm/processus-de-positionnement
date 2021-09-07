package io.redleanServices.positionnement.controller;

import java.util.Date;
import java.util.List
;
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
import io.redleanServices.positionnement.entity.Consultant;
import io.redleanServices.positionnement.entity.CvEnvoyeContact;
import io.redleanServices.positionnement.entity.CvEnvoyee;
import io.redleanServices.positionnement.service.ConsultantServiceImpl;
import io.redleanServices.positionnement.service.CvEnvoyeeSercicelmpl;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/cvEnvoyee")
public class RestControlCvEnvoyee {
	@Autowired 
	CvEnvoyeeRepository cvEnvoyeeRepository;
	
	@Autowired 
	CvEnvoyeeSercicelmpl cvEnvoyeeSercicelmpl;
	
	@Autowired 
	ConsultantServiceImpl consultantService;

	
	@PostMapping("/ajouteCvEnvoyee/{idConsultant}")
	public CvEnvoyee saveCvEnvoyee(@RequestBody CvEnvoyeContact c, @PathVariable("idConsultant") Long idConsultant)
	{	
		CvEnvoyee cv = new CvEnvoyee();
		cv.setDateEnvoi(c.getDateEnvoi());
		cv.setNomSociete(c.getNomSociete());
		cv.setPartenairClient(c.getPartenairClient());
		cv.setRemarques(c.getRemarques());
		cv.setStatut(c.getStatut());
		cv.setTJM(c.getTJM());
		Consultant consultant = consultantService.findEmployeeById(idConsultant);
		cv.setConsultant(consultant);
		cvEnvoyeeSercicelmpl.saveCvEnvoyee(cv);

		cv.setManyContact(c.getContact());
		cvEnvoyeeSercicelmpl.saveCvEnvoyee(cv);
		return cv;
	}
	
	@PutMapping("/modifycv") 
	 @ResponseBody 
	 
		public CvEnvoyee updateCvEnvoyee(@RequestBody CvEnvoyeContact c) 
		{ 	
			CvEnvoyee cv = new CvEnvoyee();
			cv.setIdcv(c.getIdcv());
			cv.setDateEnvoi(c.getDateEnvoi());
			cv.setNomSociete(c.getNomSociete());
			cv.setPartenairClient(c.getPartenairClient());
			cv.setRemarques(c.getRemarques());
			cv.setStatut(c.getStatut());
			cv.setTJM(c.getTJM());
			cv.setManyContact(c.getContact());
			cv.setConsultant(c.getConsultant());
			cvEnvoyeeSercicelmpl.updateCvEnvoyee(cv);
	
			
	  		return cv;
	}

	@GetMapping("/get-all-cvEnvoyees") 
	@ResponseBody 
	
	 public List<CvEnvoyee> getAllCvEnvoyees() { 
		
		 List<CvEnvoyee> list = cvEnvoyeeSercicelmpl.getAllCvEnvoyees();
		 return list; 
	} 
	
	@GetMapping("/getCvEnvoyeesByConsId/{id}")
	@ResponseBody 
	
	 public List<CvEnvoyee> getCvEnvoyeesByConsId(@PathVariable("id") Long id) { 
		 List<CvEnvoyee> list = cvEnvoyeeSercicelmpl.getCvEnvoyeesByConsId(id);
		 return list; 
	} 
	

	@DeleteMapping("/deleteCv/{idcv}") 
	@ResponseBody 
	void deleteCvEnvoyeeById(@PathVariable("idcv") Long idcv){ 
		cvEnvoyeeSercicelmpl.deleteCvEnvoyeeById(idcv);
		}  

 
	
	
	   @GetMapping(value = "/cvs/{idcv}")
	    public Optional<CvEnvoyee> afficherUnCvEnvoyee(@PathVariable Long idcv) {
	        return  cvEnvoyeeRepository.findById(idcv);
	    }
	   

	    

        
	    

	  

}
