package com.filip.WorkshopManagment.Service;

import com.filip.WorkshopManagment.Models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listAll();

    Customer getById(Long id);

    Customer saveOrUpdate(Customer customer);

    void delete(Long id);

    void update(Long id, Customer customer);
}
