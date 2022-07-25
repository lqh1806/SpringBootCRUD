package com.example.SpringBootCRUD.controller;

import com.example.SpringBootCRUD.model.Employee;
import com.example.SpringBootCRUD.service.EmployeeService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

    //display list of employees
    @GetMapping("/")
    public List<Employee> viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return employeeService.getAllEmployees();
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //create model to bind data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }


    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee){
        //save employee to the database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormUpdate(@PathVariable("id") Long id, Model model){
        //get employee
        Employee employee = employeeService.getEmployeeById(id);

        //set employee as model for update form
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
