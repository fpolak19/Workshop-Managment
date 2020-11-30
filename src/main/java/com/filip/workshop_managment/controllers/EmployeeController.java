package com.filip.workshop_managment.controllers;

import com.filip.workshop_managment.models.Employee;
import com.filip.workshop_managment.reopsitory.EmployeeRepository;
import com.filip.workshop_managment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    @GetMapping("/employee_list")
    public String displayList(Model model){
        model.addAttribute("employee", employeeRepository.findAll());
        return "employee_list";
    }

    @GetMapping("/new_employee_form")
    public String displayForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee );
        return "new_employee_form";
    }
    @PostMapping("/new_employee_form")
    public String saveForm(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employee_list";
    }
    @GetMapping("/employee/delete/{id}")
    public String delete(@PathVariable Long id ){
        employeeRepository.deleteById(id);
        return "redirect:/employee_list";
    }
    @GetMapping("/employee/edit/{id}")
    public String edit(@PathVariable Long id, Model model ){
        model.addAttribute("employee", employeeService.getById(id));
        return "new_employee_form";
    }
    @PostMapping("/employee/edit/{id}")
    public String postEdit(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employee_list";
    }

}
