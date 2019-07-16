package com.hanselnpetal.service;

import com.hanselnpetal.data.repos.CustomerContactRepository;
import com.hanselnpetal.domain.CustomerContact;
import org.springframework.stereotype.Service;

@Service
public class ContactsManagementService
{

    private final CustomerContactRepository customerContactRepository;

    public ContactsManagementService(CustomerContactRepository customerContactRepository)
    {
        this.customerContactRepository = customerContactRepository;
    }

    public CustomerContact add(CustomerContact aContact)
    {

        CustomerContact newContact = null;

        if (aContact.getFirstName() != null) {
            newContact = customerContactRepository.save(aContact);
        }

        return newContact;
    }

	/*
	public CustomerContact addContactOccasion(CustomerContact aContact, ContactImportantOccasion anOccasion) {
		CustomerContact newContact = null;

		return newContact;
	}
	*/
}
