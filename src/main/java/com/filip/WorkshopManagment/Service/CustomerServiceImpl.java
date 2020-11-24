package com.filip.WorkshopManagment.Service;

import com.filip.WorkshopManagment.Models.Customer;
import com.filip.WorkshopManagment.Reopsitory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements  CustomerService{
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> listAll() {
        List<Customer> customer = new ArrayList<>();
        customerRepository.findAll().forEach(customer::add);
        customerRepository.findAll().toString();

        return customer;
    }

    @Override
    public Customer getById(Long id) {
       return customerRepository.findById(id).orElse(null);

    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        customerRepository.save(customer);
        return null;
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);

    }

    @Override
    public void update(Long id, Customer customer) {
        List<Customer> customers = new ArrayList<>();
        for(int i=0; i<customers.size(); i++){
            Customer updateCustomer = customers.get(i);
            if(updateCustomer.getId().equals(id)){
                customers.set(i,customer);
                return;
            }
        }

    }
}
