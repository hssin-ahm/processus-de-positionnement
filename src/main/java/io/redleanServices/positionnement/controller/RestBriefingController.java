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
import io.redleanServices.positionnement.entity.Briefing;
import io.redleanServices.positionnement.service.BriefingServicelmpl;


@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/Briefing")
public class RestBriefingController {
	@Autowired 
	BriefingRepository briefingRepository;
	
	@Autowired 
	BriefingServicelmpl briefingServicelmpl;
	/*
	 * {
   
        "dateBriefing": "2021-08-05T00:00:00.000+00:00",
        "lieu": "dua",
        "remarque": "nn",
        "contact": "25",
        "duree": "2021-08-05T00:00:00.000+00:00"

}*/


//http://localhost:8081/SpringMVC/servlet/Briefing/ajouterBriefing
	@PostMapping("/ajouterBriefing")
	@ResponseBody
	public Briefing saveBriefing(@RequestBody Briefing b)
	{
		briefingServicelmpl.saveBriefing(b);
		return b;
	}
	
	
	
//http://localhost:8081/SpringMVC/servlet/Briefing/get-all-Briefings
	@GetMapping("/get-all-Briefings") 
	@ResponseBody 
	
	 public List<Briefing> getAllBriefings() { 
		
		 List<Briefing> list = briefingServicelmpl.getAllBriefings();
		 return list; 
	} 
	

	

	//http://localhost:8081/SpringMVC/servlet/Briefing/deleteC/2
	@DeleteMapping("/deleteC/{idBriefing}") 
	@ResponseBody 
	void deleteidBriefingById(@PathVariable("idBriefing") Long idBriefing){ 
		briefingServicelmpl.deleteBriefingById(idBriefing);
		}  

/*
{
   "idBriefing":1,
        "dateBriefing": "2021-08-05T00:00:00.000+00:00",
        "lieu": "dua",
        "remarque": "lipa",
        "contact": "25",
        "duree": "2021-08-05T00:00:00.000+00:00"

}
 * */
	

//http://localhost:8081/SpringMVC/servlet/Briefing/modifyidBriefing
	@PutMapping("/modifyidBriefing") 
	 @ResponseBody 
	 
		public Briefing updateProduit(@RequestBody Briefing b) 
		{ 	 
    	
   		 return briefingServicelmpl.updateBriefing(b);
 	}
	
	
//http://localhost:8081/SpringMVC/servlet/Briefing/Briefings/1
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
