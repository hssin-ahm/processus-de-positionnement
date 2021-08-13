package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.Contact;

public interface ContactService {
	Contact saveContact(Contact p);
		void deleteContact(Contact p);
		void deleteContactById(Long id);
		Contact getContact(Long id);
		List<Contact> getAllContacts();
		Contact updateContact(Contact adv, Long idAd) ;
		Contact updateContact(Contact p) ;
}
