package com.filip.WorkshopManagment.Controllers;

import com.filip.WorkshopManagment.Models.Vehicles;
import com.filip.WorkshopManagment.Reopsitory.VehicleRepository;
import com.filip.WorkshopManagment.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehiclesController {
    private final VehicleService vehicleService;
    private final VehicleRepository vehicleRepository;
    @Autowired
    public VehiclesController(VehicleService vehicleService, VehicleRepository vehicleRepository) {
        this.vehicleService = vehicleService;
        this.vehicleRepository = vehicleRepository;
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
        return "newvehicleform";
    }
    @PostMapping ("/newvehicleform.html")
    public String save( Vehicles vehicles) {
        vehicleRepository.save(vehicles);
        return "vehiclelist.html";
    }


}
