package com.phoneBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoneBook.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	Contact findByContactId(int contactId);

}
