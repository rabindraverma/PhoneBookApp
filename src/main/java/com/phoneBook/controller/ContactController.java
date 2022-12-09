package com.phoneBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoneBook.entity.Contact;
import com.phoneBook.service.ContactService;

@RestController
@RequestMapping("/api/v1")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/addContact")
	public ResponseEntity<Contact> saveNewContact(@RequestBody Contact contact){
		return new ResponseEntity<>(contactService.addContact(contact),HttpStatus.CREATED);
	}
	@GetMapping("/getAllContact")
	public ResponseEntity<List<Contact>> getAllContact(){
		List<Contact> allContact = contactService.getAllContact();
	return new ResponseEntity<List<Contact>>(allContact,HttpStatus.OK);
	}
	
	@GetMapping("/getContactById/{contactId}")
	public ResponseEntity<Contact> getContactById(@PathVariable("contactId") int contactId){
		Contact contactById = contactService.getContactById(contactId);
		return new ResponseEntity<Contact>(contactById,HttpStatus.OK);
	}
	
	@PutMapping("/updateContact/{contactId}")
	public ResponseEntity<Contact> updateContact(@PathVariable("contactId") int contactId, @RequestBody Contact contact){
		contact.setContactId(contactId);
		return new ResponseEntity<Contact>(contactService.updateContact(contact),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteContactByContactId/{contactId}")
	public ResponseEntity<Contact> deleteContactById(@PathVariable("contactId") int contactId){
		Contact deleteContactById = contactService.deleteContactById(contactId);
		return new ResponseEntity<>(deleteContactById,HttpStatus.GONE);
	}
	
	
	
	

}
