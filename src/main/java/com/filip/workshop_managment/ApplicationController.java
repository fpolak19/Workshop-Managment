package com.filip.workshop_managment;

import com.filip.workshop_managment.reopsitory.CustomerRepository;
import com.filip.workshop_managment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
@Autowired
    public ApplicationController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String homePage() {
        return "index";

    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/basic_table.html")
    public String table() {
        return "basic_table";
    }

    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

    @GetMapping("/profile.html")
    public String profile() {
        return "profile";

    }
    @GetMapping("/widgets.html")
    public String widgets() {
        return "widgets";

    }
    @GetMapping("/grids.html")
    public String grids() {
        return "grids";

    }
    @GetMapping("/general.html")
    public String general() {
        return "general";

    }
    @GetMapping("/form_validation.html")
    public String faormVal() {
        return "form_validation";

    }
    @GetMapping("/form_component.html")
    public String formComp() {
        return "form_component";
    }
    @GetMapping("/contact.html")
    public String contact() {
        return "contact";
    }
    @GetMapping("/chart-chartjs.html")
    public String chart() {
        return "chart-chartjs";
    }
    @GetMapping("/buttons.html")
    public String buttons() {
        return "buttons";
    }
    @GetMapping("/new_vehicle_form2.html/index.html")
    public String vehicleFromIndex(){
    return "redirect:/index.html";
    }


}