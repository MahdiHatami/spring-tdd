package com.hanselnpetal.data.repos;

import com.hanselnpetal.domain.CustomerContact;
import org.springframework.data.repository.CrudRepository;

public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {

	public CustomerContact findByEmail(String email);
}
