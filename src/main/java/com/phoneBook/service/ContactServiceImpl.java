package com.phoneBook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoneBook.entity.Contact;
import com.phoneBook.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo; 

	@Override
	public Contact addContact(Contact contact) {
		return contactRepo.save(contact);
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> allContact = contactRepo.findAll();
		return allContact;
	}

	@Override
	public Contact updateContact(Contact contact) {
		Optional<Contact> contactData = contactRepo.findById(contact.getContactId());
		if (contactData.isPresent()) {
			Contact contact2 = contactData.get();
			contact2.setContactName(contact.getContactName());
			contact2.setContactEmail(contact.getContactEmail());
			contact2.setContactNum(contact.getContactNum());
			contactRepo.save(contact2);
			return contact2;
		} else {
			throw new RuntimeException("Contact not available of this given contactId");
		}
	}

	@Override
	public Contact deleteContactById(int contactId) {
		  Contact findByContactId = contactRepo.findByContactId(contactId);
		if (findByContactId!=null) {
			contactRepo.deleteById(contactId);
			return findByContactId;
		} else {
			throw new RuntimeException("contactId is not valid");
		}
	}

	@Override
	public Contact getContactById(int contactid) {
		Optional<Contact> findById = contactRepo.findById(contactid);
		Contact contact = findById.get();
		return contact;
	}

}
