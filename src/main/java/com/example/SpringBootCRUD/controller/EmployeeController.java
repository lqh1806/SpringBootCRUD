package com.example.SpringBootCRUD.controller;

import com.example.SpringBootCRUD.model.Employee;
import com.example.SpringBootCRUD.service.EmployeeService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
	
	@Autowired
	private RestTemplate restTemplate;
    
    private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

    //display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model){
    	ResponseEntity<Employee[]> responseEntity = restTemplate.getForEntity("/all", Employee[].class);
    	Employee[] employees = responseEntity.getBody();
        model.addAttribute("listEmployees", employees);
        return "index";
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
    	ResponseEntity<Employee> responseEntity = restTemplate.postForEntity("/add", employee, Employee.class);
    	if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
			System.out.println("Them thanh cong");
		}
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormUpdate(@PathVariable("id") Long id, Model model){
        //get employee
    	ResponseEntity<Employee> responseEntity = restTemplate.getForEntity("/" + id, Employee.class);

        //set employee as model for update form
        model.addAttribute("employee", responseEntity.getBody());
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
    	restTemplate.delete("/delete/" + id, Employee.class);
//        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
