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

import io.redleanServices.positionnement.dao.ContactRepository;
import io.redleanServices.positionnement.entity.Contact;
import io.redleanServices.positionnement.service.ContactServiceImpl;


@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("Contact")
public class RestControlContact {

	@Autowired 
	ContactRepository contactRepository;
	
	@Autowired 
	ContactServiceImpl contactServiceImpl;
	


	
	
	/*
	 * {
    
    "nom": "fvb",
    "prenom": "ee",
    "mail": "dfbn",
    "telephone": 22
}*/
    //http://localhost:8081/SpringMVC/servlet/Contact/ajouterContact
	@PostMapping("/ajouterContact")
	@ResponseBody
	public Contact saveContact(@RequestBody Contact c)
	{
		contactServiceImpl.saveContact(c);
		return c;
	}
	
	
	
	//http://localhost:8081/SpringMVC/servlet/Contact/get-all-Contacts
	@GetMapping("/get-all-Contacts") 
	@ResponseBody 
	
	 public List<Contact> getAllContacts() { 
		
		 List<Contact> list = contactServiceImpl.getAllContacts();
		 return list; 
	} 
	

	

	
	//http://localhost:8081/SpringMVC/servlet/Contact/deleteC/1
	@DeleteMapping("/deleteC/{idContact}") 
	@ResponseBody 
	void deletePartenaireById(@PathVariable("idContact") Long idContact){ 
		contactServiceImpl.deleteContactById(idContact);
		}  


	

	//http://localhost:8081/SpringMVC/servlet/Contact/modifyidContact
	/*
	 *{
    "idContact":1,
    "nom": "fvb",
    "prenom": "ee",
    "mail": "dfbn",
    "telephone": 22
}
	}*/
	@PutMapping("/modifyidContact") 
	 @ResponseBody 
	 
		public Contact updateProduit(@RequestBody Contact c) 
		{ 	 
    	
   		 return contactServiceImpl.updateContact(c);
 	}
	
	

	 //http://localhost:8081/SpringMVC/servlet/Contact/Contacts/1
	   @GetMapping(value = "/Contacts/{idContact}")
	    public Optional<Contact> afficherUnContact(@PathVariable Long idContact) {
	        return  contactRepository.findById(idContact);
	    }
	   

	    

         //afficher par id
	    //http://localhost:8081/SpringMVC/servlet/Contact/contacts/1
	    @GetMapping(value = "/contacts/{idContact}")
	    @ResponseBody
	 	
	 	public Contact findContact(@PathVariable("idContact") Long idContact)
	 	     {
	 			return contactServiceImpl.getContact(idContact);
	 		 }
	    
	    

	    
	
	
}
