package com.hanselnpetal.controller;

import com.hanselnpetal.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContactsManagementControllerIntegrationTest
{

    @Autowired
    ContactsManagementController contactsManagementController;

    @Test
    public void testAddContactHappyPath()
    {

        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Jenny");
        aContact.setLastName("Johnson");

        // POST our CustomerContact form bean to the controller; check the outcome
        String result = contactsManagementController.processAddContactSubmit(aContact);


        // Assert THAT the outcome is as expected
        assertThat(result, is(equalTo("/addContactForm")));

    }

    @Test
    public void testAddContactFirstNameMissing()
    {
        CustomerContact aContact = new CustomerContact();

        String result = contactsManagementController.processAddContactSubmit(aContact);

        assertThat(result, equalTo("redirect:/showAddContact"));

    }
}
