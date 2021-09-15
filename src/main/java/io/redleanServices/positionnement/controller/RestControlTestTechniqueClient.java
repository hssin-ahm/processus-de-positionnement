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
import io.redleanServices.positionnement.dao.TestTechniqueClientRepository;
import io.redleanServices.positionnement.entity.Consultant;
import io.redleanServices.positionnement.entity.CvEnvoyee;
import io.redleanServices.positionnement.entity.EntretienPartenaire;
import io.redleanServices.positionnement.entity.Positionnement;
import io.redleanServices.positionnement.entity.TestTechniqueClient;
import io.redleanServices.positionnement.service.ConsultantServiceImpl;
import io.redleanServices.positionnement.service.TestTechniqueClientServicelmpl;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/testTechniqueClient")
public class RestControlTestTechniqueClient {
	@Autowired 
	TestTechniqueClientRepository testTechniqueClientRepository;
	
	@Autowired 
	TestTechniqueClientServicelmpl testTechniqueClientServicelmpl;
	
	@Autowired 
	ConsultantServiceImpl consultantService;
	
	@Autowired 
	CvEnvoyeeRepository cvEnvoyeeRepository;
	
	@GetMapping("/getTestTechniqueByCvId/{id}") 
	@ResponseBody 
	 public TestTechniqueClient getTestTechniqueByCvId(@PathVariable("id") Long id) { 
		
		 TestTechniqueClient testTechniqueClient = testTechniqueClientServicelmpl.getTestTechniqueByCvId(id);
		 
		 return testTechniqueClient; 
	} 
	
	@PostMapping("/ajouterTestTechnique/{id}/{consultantId}")
	@ResponseBody
	public TestTechniqueClient saveEntretien(@RequestBody TestTechniqueClient e, @PathVariable("id") Long id, @PathVariable("consultantId") Long consultantId)
	{
		Consultant consultant = consultantService.findEmployeeById(consultantId);
		Optional<CvEnvoyee> cvEnvoyee = cvEnvoyeeRepository.findById(id);
		e.setConsultant(consultant);
		e.setCvEnvoyee(cvEnvoyee.get());
		testTechniqueClientServicelmpl.saveTestTechniqueClient(e);
		return e;
	}
	
	@PutMapping(value = "/modifyidTestTechnique/{id}/{consultantId}") 
	 @ResponseBody 
	 
		public TestTechniqueClient updateEntretien(@RequestBody TestTechniqueClient e, @PathVariable("id") Long id, @PathVariable("consultantId") Long consultantId) 
		{ 	 
		Consultant consultant = consultantService.findEmployeeById(consultantId);
		Optional<CvEnvoyee> cvEnvoyee = cvEnvoyeeRepository.findById(id);
		e.setConsultant(consultant);
		e.setCvEnvoyee(cvEnvoyee.get());
		testTechniqueClientServicelmpl.updateEntretien(e);
	 	return e;
		}
	
	
	
//	@PostMapping("/ajouterTestTechniqueClient")
//	@ResponseBody
//	public TestTechniqueClient saveTestTechniqueClient(@RequestBody TestTechniqueClient e)
//	{
//		testTechniqueClientServicelmpl.saveTestTechniqueClient(e);
//		return e;
//	}
	@PostMapping("/ajouterTestTechniqueClient/{consultantId}")
	@ResponseBody
	public TestTechniqueClient saveEntretienByConsId(@RequestBody TestTechniqueClient e, @PathVariable("consultantId") Long consultantId)
	{
		Consultant consultant = consultantService.findEmployeeById(consultantId);
		e.setConsultant(consultant);
		testTechniqueClientServicelmpl.saveTestTechniqueClient(e);
		return e;
	}
	
	@GetMapping("/get-all-TestTechniqueClients") 
	@ResponseBody 
	
	 public List<TestTechniqueClient> getAllTestTechniqueClients() { 
		
		 List<TestTechniqueClient> list = testTechniqueClientServicelmpl.getAllTestTechniqueClients();
		 return list; 
	} 
	
	@GetMapping("/get-all-TestTechniqueClients/{id}") 
	@ResponseBody 
	
	 public List<TestTechniqueClient> getAllEntretiensByConsultantId(@PathVariable("id") Long id) { 
		
		 List<TestTechniqueClient> list = testTechniqueClientServicelmpl.getAllEntretiensByConsultantId(id);
		 return list; 
	} 
	
	@DeleteMapping("/deleteT/{idTestTechniqueClient}") 
	@ResponseBody 
	void deleteidTestTechniqueClientById(@PathVariable("idTestTechniqueClient") Long idTestTechniqueClient){ 
		testTechniqueClientServicelmpl.deleteTestTechniqueClientById(idTestTechniqueClient);
		}  
	
	@PutMapping("/modifyidTestTechniqueClient") 
	 @ResponseBody 
	 
		public TestTechniqueClient updateEntretien(@RequestBody TestTechniqueClient e) 
		{ 	 
    	
   		 return testTechniqueClientServicelmpl.updateEntretien(e);
 	}
	
	
	   @GetMapping(value = "/idTestTechniqueClients/{idTestTechniqueClient}")
	    public Optional<TestTechniqueClient> afficherUnTestTechniqueClient(@PathVariable Long idTestTechniqueClient) {
	        return  testTechniqueClientRepository.findById(idTestTechniqueClient);
	    }
	   

	    
	    @GetMapping(value = "/TestTechniqueClients/{idTestTechniqueClient}")
	    @ResponseBody
	 	
	 	public TestTechniqueClient findTestTechniqueClient(@PathVariable("idTestTechniqueClient") Long idTestTechniqueClient)
	 	     {
	 			return testTechniqueClientServicelmpl.getTestTechniqueClient(idTestTechniqueClient);
	 		 }
	    
}
