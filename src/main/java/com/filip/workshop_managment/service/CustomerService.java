package com.filip.workshop_managment.service;

import com.filip.workshop_managment.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listAll();

    Customer getById(Long id);

    Customer saveOrUpdate(Customer customer);

    void delete(Long id);

    void update(Long id, Customer customer);
}
