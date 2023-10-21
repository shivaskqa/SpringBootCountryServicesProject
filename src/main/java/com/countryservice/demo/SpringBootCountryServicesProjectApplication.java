package com.countryservice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EntityScan(basePackages = "com.countryservice.demo.beans.Country")
@EnableJpaRepositories(basePackages="com.countryservice.demo.repositories.CountryRepository")
@ComponentScan(basePackages={"com.countryservice.demo.controllers.CountryController","com.countryservice.demo.services.CountryService"})
public class SpringBootCountryServicesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCountryServicesProjectApplication.class, args);
	}

}
