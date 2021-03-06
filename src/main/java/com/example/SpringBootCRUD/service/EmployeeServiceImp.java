package com.example.SpringBootCRUD.service;

import com.example.SpringBootCRUD.model.Employee;
import com.example.SpringBootCRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }
        else{
            employee = null;
        }
        return employee;
    }

    @Override
    public int deleteEmployee(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            employeeRepository.deleteById(optional.get().getId());
            employeeRepository.deleteAll();
            return 1;
        }
        else{
            throw new RuntimeException("Employee not found for id " + id);
        }
    }


}
