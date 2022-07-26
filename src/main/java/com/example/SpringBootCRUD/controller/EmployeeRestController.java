package com.example.SpringBootCRUD.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCRUD.exception.ErrorMessage;
import com.example.SpringBootCRUD.model.Employee;
import com.example.SpringBootCRUD.service.EmployeeService;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;
    
    private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

    @GetMapping("/all")
    public ResponseEntity getAll(){
    	LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        
        try {
			
		} catch (Exception e) {
			LOGGER.error("Error level log message", e);
		}
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee != null)
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorMessage(404, "Khong tim thay nhan vien"));
        }
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@Valid @RequestBody Employee employee){
        Employee employee2 = null;
        employee2 = employeeService.saveEmployee(employee);
        if(employee2 != null)
            return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorMessage(404, "Them khong thanh cong"));
    }

    @PutMapping("/put")
    public ResponseEntity putEmployee(@Valid @RequestBody Employee employee){
        Employee employee2 = null;
        employee2 = employeeService.saveEmployee(employee);
        if(employee2 != null)
            return ResponseEntity.ok(employee);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorMessage(404, "Sua khong thanh cong"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable("id") Long id){
        int res = employeeService.deleteEmployee(id);
        if(res == 1){
            return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
        }
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(404, "Xoa khong thanh cong"));
    }
}
