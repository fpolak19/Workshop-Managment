package com.filip.workshop_managment.controllers;

import com.filip.workshop_managment.models.Customer;
import com.filip.workshop_managment.models.Vehicle;
import com.filip.workshop_managment.reopsitory.CustomerRepository;
import com.filip.workshop_managment.reopsitory.VehicleRepository;
import com.filip.workshop_managment.service.CustomerService;
import com.filip.workshop_managment.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehiclesController {
    private final VehicleService vehicleService;
    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    @Autowired
    public VehiclesController(CustomerService customerService,VehicleService vehicleService, VehicleRepository vehicleRepository, CustomerRepository customerRepository) {
        this.vehicleService = vehicleService;
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
        this.customerService =customerService;
    }

    @GetMapping("/vehicle_list.html")
    public String listVehicle(Model model) {
        model.addAttribute("vehicle", vehicleService.listAll());
        return "vehicle_list";
    }
   @GetMapping("/new_vehicle_form.html")
    public String formVehicle(  Long id , Model model) {
       Vehicle vehicle = new Vehicle();
       model.addAttribute("vehicle", vehicle);

      // Iterable<Customer> customer = customerRepository.findAll();

       model.addAttribute("customerNameList" , customerRepository.findAll() );
        return "new_vehicle_form";
    }
    @PostMapping ("/new_vehicle_form.html")
    public String save( Vehicle vehicle) {

        vehicleRepository.save(vehicle);
        return "redirect:/vehicle_list.html";
    }
    @GetMapping("/vehicle/delete/{id}")
    public String delete(@PathVariable Long id) {

        vehicleService.delete(id);
        return "redirect:/vehicle_list.html";
    }
    @GetMapping("/new_vehicle_form2.html/{id}")
    public String form2Vehicle( @PathVariable Long id , Model model) {

        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);

        Customer customer = customerService.getById(id);
        model.addAttribute("customerId", customer ) ;

        return "new_vehicle_form2";
    }
    @PostMapping("/new_vehicle_form2.html/{id}")
    public String save2(Vehicle vehicle ) {

        vehicleRepository.save(vehicle);
        return "redirect:/vehicle_list.html";
    }
    @GetMapping("/new_vehicle_form2.html/edit/{id}")
    public String edit(@PathVariable Long id, Model model){

        model.addAttribute("vehicle", vehicleService.getById(id));
        return "new_vehicle_form2";
    }
    @PostMapping("/new_vehicle_form2.html/edit/{id}")
    public String saveEdit( Vehicle vehicle, Long id){
        vehicleRepository.save(vehicle);
        return "redirect:/vehicle_list.html";
    }




}
