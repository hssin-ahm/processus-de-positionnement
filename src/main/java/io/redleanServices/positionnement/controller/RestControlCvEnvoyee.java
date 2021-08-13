package io.redleanServices.positionnement.controller;

import java.util.List
;
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

import io.redleanServices.positionnement.dao.CvEnvoyeeRepository;
import io.redleanServices.positionnement.entity.CvEnvoyee;
import io.redleanServices.positionnement.service.CvEnvoyeeSercicelmpl;

@RestController
@RequestMapping("CvEnvoyee")
public class RestControlCvEnvoyee {
	@Autowired 
	CvEnvoyeeRepository cvEnvoyeeRepository;
	
	@Autowired 
	CvEnvoyeeSercicelmpl cvEnvoyeeSercicelmpl;
	


	/*
	 * 
	 *  "dateEnvoi": null,
    "remarques": "bbb",
    "contact": null,
    "partenairClient": null,
    "statut": "nnn",
    "tjm": 0.0,
    "nomSociete": "v"*/
	
	//http://localhost:8081/SpringMVC/servlet/CvEnvoyee/ajouteCvEnvoyee
	@PostMapping("/ajouteCvEnvoyee")
	@ResponseBody
	public CvEnvoyee saveContact(@RequestBody CvEnvoyee c)
	{
		cvEnvoyeeSercicelmpl.saveCvEnvoyee(c);
		return c;
	}
	
//http://localhost:8081/SpringMVC/servlet/CvEnvoyee/get-all-cvEnvoyees	
	
	@GetMapping("/get-all-cvEnvoyees") 
	@ResponseBody 
	
	 public List<CvEnvoyee> getAllCvEnvoyees() { 
		
		 List<CvEnvoyee> list = cvEnvoyeeSercicelmpl.getAllCvEnvoyees();
		 return list; 
	} 
	

	

	//http://localhost:8081/SpringMVC/servlet/CvEnvoyee/deleteCv/1
	@DeleteMapping("/deleteCv/{idcv}") 
	@ResponseBody 
	void deleteCvEnvoyeeById(@PathVariable("idcv") Long idcv){ 
		cvEnvoyeeSercicelmpl.deleteCvEnvoyeeById(idcv);
		}  


	/*{   
    "idcv": 1,
    "dateEnvoi": null,
    "remarques": "never forget",
    "contact": null,
    "partenairClient": null,
    "statut": "nnn",
    "tjm": 0.0,
    "nomSociete": "v"
}

*/
//http://localhost:8081/SpringMVC/servlet/CvEnvoyee/modifycv
	@PutMapping("/modifycv") 
	 @ResponseBody 
	 
		public CvEnvoyee updateCvEnvoyee(@RequestBody CvEnvoyee c) 
		{ 	 
    	
   		 return cvEnvoyeeSercicelmpl.updateCvEnvoyee(c);
 	}
	
	
//http://localhost:8081/SpringMVC/servlet/CvEnvoyee/cvs/1
	   @GetMapping(value = "/cvs/{idcv}")
	    public Optional<CvEnvoyee> afficherUnCvEnvoyee(@PathVariable Long idcv) {
	        return  cvEnvoyeeRepository.findById(idcv);
	    }
	   

	    

        
	    

	  

}
