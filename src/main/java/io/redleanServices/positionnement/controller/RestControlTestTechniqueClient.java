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

import io.redleanServices.positionnement.dao.TestTechniqueClientRepository;
import io.redleanServices.positionnement.entity.TestTechniqueClient;
import io.redleanServices.positionnement.service.TestTechniqueClientServicelmpl;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/a/testTechniqueClient")
public class RestControlTestTechniqueClient {
	@Autowired 
	TestTechniqueClientRepository testTechniqueClientRepository;
	
	@Autowired 
	TestTechniqueClientServicelmpl testTechniqueClientServicelmpl;
	
/*
{
 "dateEntretien": null,
    "duree": null,
    "observations": "gb ",

    "typeEntretien": "rfgb"

}
*/
	//http://localhost:8081/SpringMVC/servlet/TestTechniqueClient/ajouterTestTechniqueClient
	@PostMapping("/ajouterTestTechniqueClient")
	@ResponseBody
	public TestTechniqueClient saveTestTechniqueClient(@RequestBody TestTechniqueClient e)
	{
		testTechniqueClientServicelmpl.saveTestTechniqueClient(e);
		return e;
	}
	
	
	//http://localhost:8081/SpringMVC/servlet/TestTechniqueClient/get-all-TestTechniqueClients
	@GetMapping("/get-all-TestTechniqueClients") 
	@ResponseBody 
	
	 public List<TestTechniqueClient> getAllTestTechniqueClients() { 
		
		 List<TestTechniqueClient> list = testTechniqueClientServicelmpl.getAllTestTechniqueClients();
		 return list; 
	} 
	

	
	//http://localhost:8081/SpringMVC/servlet/TestTechniqueClient/deleteT/2
	@DeleteMapping("/deleteT/{idTestTechniqueClient}") 
	@ResponseBody 
	void deleteidTestTechniqueClientById(@PathVariable("idTestTechniqueClient") Long idTestTechniqueClient){ 
		testTechniqueClientServicelmpl.deleteTestTechniqueClientById(idTestTechniqueClient);
		}  

/*
{
 "dateEntretien": null,
    "duree": null,
    "observations": null,
    "testTechniqueClient": 1,
    "typeEntretien": "telephone"

}
*/
	//http://localhost:8081/SpringMVC/servlet/TestTechniqueClient/modifyidTestTechniqueClient
	
	@PutMapping("/modifyidTestTechniqueClient") 
	 @ResponseBody 
	 
		public TestTechniqueClient updateEntretien(@RequestBody TestTechniqueClient e) 
		{ 	 
    	
   		 return testTechniqueClientServicelmpl.updateEntretien(e);
 	}
	
	
//http://localhost:8081/SpringMVC/servlet/TestTechniqueClient/idTestTechniqueClients/3
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
