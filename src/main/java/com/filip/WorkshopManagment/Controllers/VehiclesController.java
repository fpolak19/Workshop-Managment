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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String formVehicle( Long id , Model model) {
       Vehicles vehicles = new Vehicles();
       model.addAttribute("vehicles", vehicles);
      Iterable<Customer> customer = customerRepository.findAll();

       model.addAttribute("customerNameList" , customer );
        return "newvehicleform";
    }
    @PostMapping ("/newvehicleform.html")
    public String save( Vehicles vehicles) {
        vehicleRepository.save(vehicles);
        return "redirect:/vehiclelist.html";
    }
    @RequestMapping("/vehicles/delete/{id}")
    public String delete(@PathVariable Long id) {
        vehicleService.delete(Long.valueOf(id));
        return "redirect:/vehiclelist.html";
    }
    @GetMapping("/newvehicleform2.html/{id}")
    public String form2Vehicle( @PathVariable("id") Long id , Model model) {
        Vehicles vehicles = new Vehicles();
        model.addAttribute("vehicles", vehicles);
        Customer customer = customerService.getById(id);

        model.addAttribute("customerId", customer);
        return "newvehicleform2";
    }
    @PostMapping ("/newvehicleform2.html/{id}")
    public String save2( Vehicles vehicles) {
        vehicleService.saveOrUpdate(vehicles);

        return "redirect:/vehiclelist.html";
    }


}
