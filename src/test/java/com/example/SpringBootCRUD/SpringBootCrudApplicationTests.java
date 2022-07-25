package com.example.SpringBootCRUD;

import com.example.SpringBootCRUD.controller.EmployeeController;
import com.example.SpringBootCRUD.model.Employee;
import com.example.SpringBootCRUD.service.EmployeeService;
import com.example.SpringBootCRUD.service.EmployeeServiceImp;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class SpringBootCrudApplicationTests {

	private List<Employee> listTest;

	@Before
	public void init(){
		listTest = new ArrayList<>();
		listTest.add(new Employee(1L,"abc", "Le", "abc@gmail.com"));
		listTest.add(new Employee(2L,"abc", "Le", "abc@gmail.com"));
		listTest.add(new Employee(3L,"abc", "Le", "abc@gmail.com"));
		listTest.add(new Employee(4L,"abc", "Le", "abc@gmail.com"));
		System.out.println("Log before");
	}

	@Mock
	EmployeeService employeeService;

	@InjectMocks
	EmployeeController employeeController;

	@Test
	public void testViewHomePage(){
		Mockito.when(employeeService.getAllEmployees()).thenReturn(listTest);

		Assert.assertEquals(4, employeeService.getAllEmployees().size());
	}

}
