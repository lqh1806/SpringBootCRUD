package com.example.SpringBootCRUD.service;

import com.example.SpringBootCRUD.model.Employee;

import java.util.List;


public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);
}
