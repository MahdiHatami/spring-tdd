package com.hanselnpetal.data.repos;

import com.hanselnpetal.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CustomerContactRepositoryIntegrationTest
{

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Test
    public void testFindByEmail()
    {

        // setup data scenario
        CustomerContact aNewContact = new CustomerContact();
        aNewContact.setFirstName("Fred");
        aNewContact.setEmail("fred@email.com");

        entityManager.persist(aNewContact);

        // Find an inserted record using repository class
        CustomerContact foundContact = customerContactRepository.findByEmail(aNewContact.getEmail());


        // Assertion
        assertThat(foundContact.getEmail(), is(equalTo(aNewContact.getEmail())));
    }

}
