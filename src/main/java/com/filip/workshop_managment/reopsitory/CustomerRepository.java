package com.filip.workshop_managment.reopsitory;

import com.filip.workshop_managment.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
