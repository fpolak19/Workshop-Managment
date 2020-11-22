package com.filip.WorkshopManagment.Controllers;

import com.filip.WorkshopManagment.Models.Customer;
import com.filip.WorkshopManagment.Models.Vehicles;
import com.filip.WorkshopManagment.Reopsitory.CustomerRepository;
import com.filip.WorkshopManagment.Reopsitory.VehicleRepository;
import com.filip.WorkshopManagment.Service.CustomerService;
import com.filip.WorkshopManagment.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/vehiclelist.html")
    public String listVehiclels(Model model) {
        model.addAttribute("vehicles", vehicleService.listAll());
        return "vehiclelist";
    }
   @GetMapping("/newvehicleform.html")
    public String formVehicle(Model model) {
       Vehicles vehicles = new Vehicles();
       model.addAttribute("vehicles", vehicles);
       List<Customer> customer = (List<Customer>) customerService.listAll();
       model.addAttribute("customerNameList" ,customer );
        return "newvehicleform";
    }
    @PostMapping ("/newvehicleform.html")
    public String save( Vehicles vehicles) {
        vehicleRepository.save(vehicles);
        return "vehiclelist.html";
    }


}
