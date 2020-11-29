package com.filip.workshop_managment.controllers;

import com.filip.workshop_managment.models.Customer;
import com.filip.workshop_managment.reopsitory.CustomerRepository;
import com.filip.workshop_managment.reopsitory.VehicleRepository;
import com.filip.workshop_managment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, CustomerService customerService,VehicleRepository vehicleRepository) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping("/customer_list.html")
    public String listCustomer(Model model) {
        model.addAttribute("customers", customerService.listAll());
        return "customer_list";
    }

    @GetMapping("/new_customer_form.html")
    public String formCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer_form";
    }

    @PostMapping("/new_customer_form.html")
    public String save(Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customer_list.html";
    }


    @GetMapping("/customer_list/delete/{id}")
    public String delete(@PathVariable Long id) {
        customerService.delete(id);
        return "redirect:/customer_list.html";
    }
    @GetMapping("/new_customer_form/edit/{id}")
    public String edit(@PathVariable Long id, Model model){

        model.addAttribute("customer", customerService.getById(id));
        return "new_customer_form";
    }
    @PostMapping("/customer_list/edit/{id}")
    public String saveEdit(Customer customer){
        customerRepository.save(customer);
        return "redirect:/customer_list.html";
    }


}