package io.redleanServices.positionnement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redleanServices.positionnement.dao.ContactRepository;
import io.redleanServices.positionnement.entity.Contact;

@Service 
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	ContactRepository contactRepository;

	@Override
	public Contact saveContact(Contact p) {
		return contactRepository.save(p);
	}

	@Override
	public void deleteContact(Contact p) {
		// TODO Auto-generated method stub
		contactRepository.delete(p);		

		
	}

	@Override
	public void deleteContactById(Long id) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(id);

		
	}

	@Override
	public Contact getContact(Long id) {
		return contactRepository.findById(id).get();

	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> Categorys =(List<Contact>) contactRepository.findAll();
		for(Contact Category:Categorys) {
			System.out.println(Category);
		}
		return Categorys;
	}

	@Override
	public Contact updateContact(Contact adv, Long idAd) {
		Contact a = adv;
		return contactRepository.save(a);
	}

	@Override
	public Contact updateContact(Contact p) {
		return contactRepository.save(p);

	}

}
