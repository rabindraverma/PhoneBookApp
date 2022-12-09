package com.phoneBook.service;

import java.util.List;

import com.phoneBook.entity.Contact;

public interface ContactService {
	
	Contact addContact(Contact contact);

	List<Contact>getAllContact();

	Contact updateContact(Contact contact);

	Contact deleteContactById(int contactId);

	Contact getContactById(int contactId);


}
