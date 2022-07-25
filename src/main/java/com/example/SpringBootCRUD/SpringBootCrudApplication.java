package com.example.SpringBootCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootCrudApplication extends SpringBootServletInitializer {

	public static void main(String[] args){
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}

}
