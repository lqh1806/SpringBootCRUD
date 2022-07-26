package com.example.SpringBootCRUD.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Config {
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select().build();
	}
	
	@Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory("http://10.3.0.217:8080/api/v1/employee");
        restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);
        return restTemplate;
    }
}
