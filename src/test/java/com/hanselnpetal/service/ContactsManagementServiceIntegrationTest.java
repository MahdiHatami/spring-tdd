package com.hanselnpetal.service;

import com.hanselnpetal.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementServiceIntegrationTest {

	@Autowired
	private ContactsManagementService contactsManagementService;


	@Test
	public void testAddContactHappyPath() {

		// Create a contact
		CustomerContact aContact = new CustomerContact();
		aContact.setFirstName("Jenny");
		aContact.setLastName("Johnson");


		// Test adding the contact
		CustomerContact newcontact = contactsManagementService.add(aContact);


		// Verify the addition
		assertNotNull(aContact);
		assertNotNull(aContact.getId());
		assertEquals("Jenny", aContact.getFirstName());

	}
}
