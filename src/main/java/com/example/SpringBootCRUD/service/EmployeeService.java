package com.example.SpringBootCRUD.service;

import com.example.SpringBootCRUD.model.Employee;

import java.util.List;


public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    int deleteEmployee(Long id);
}
