package com.filip.WorkshopManagment.Controllers;

import com.filip.WorkshopManagment.Models.Customer;
import com.filip.WorkshopManagment.Models.Vehicles;
import com.filip.WorkshopManagment.Reopsitory.CustomerRepository;
import com.filip.WorkshopManagment.Reopsitory.VehicleRepository;
import com.filip.WorkshopManagment.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

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

    @GetMapping("/customerlist.html")
    public String listcustomer(Model model) {
        model.addAttribute("customers", customerService.listAll());
        return "customerlist";
    }

    @GetMapping("/newcustomerform.html")
    public String formcustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "newcustomerform";
    }

    @PostMapping("/newcustomerform.html")
    public String save(Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customerlist.html";
    }

    @GetMapping("/newvehicleform.html/{id}")
    public String addVehicleToCustomer(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.getById(id);
        Vehicles vehicles = new Vehicles();
        model.addAttribute("vehicles", vehicles);
        return "newvehicleform";
    }

    @PostMapping("/newvehicleform.html/{id}")
    public String saveNewVehicle(Vehicles vehicles, Map<String, Object> map) {
       vehicleRepository.save(vehicles);
        return "vehiclelist.html";
    }
    @RequestMapping("/customerlist/delete/{id}")
    public String delete(@PathVariable Long id) {
        customerService.delete(Long.valueOf(id));
        return "redirect:/customerlist.html";
    }
}