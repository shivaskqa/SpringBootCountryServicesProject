package com.countryservice.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.services.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;
	
   @GetMapping("/getcountries")	
   public List<Country>	getCountries()
	{
		return countryService.getAllCountries();
	}

   @GetMapping("/getcountries/{id}")
    public ResponseEntity<Country> getCountryByID(@PathVariable(value="id") int id)
    {
	   try
	   {
		   Country country=countryService.getCountryById(id);
		   return new ResponseEntity<Country>(country,HttpStatus.OK);
	   }
    	catch(Exception e)
	   {
    		System.out.println("Exception is occured in getCountryById method in Country Controller Class..");
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
    }
   
   @GetMapping("/getcountries/countryname")
    public ResponseEntity<Country> getCountryByName(@RequestParam(value="name") String name)
    {
    
      try
      {
	      Country country=countryService.getCountryByName(name);
    	  return new ResponseEntity<Country>(country,HttpStatus.OK);
      }
      catch(Exception e)
      {
    	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

   
   @PostMapping("/addcountry")
   public Country createCountry(@RequestBody Country country)
   {
	   return countryService.addNewCountry(country);
   }
   
   @PutMapping("/updatecountry/{id}")
   public Country updateCountry(@PathVariable(value="id") int id, @RequestBody Country country)
   {
	   Country existsCountryObj=countryService.getCountryById(id);
	   if(existsCountryObj!=null)
		 return  countryService.updateExistingCountry(existsCountryObj);
	   else
		return  countryService.addNewCountry(existsCountryObj);
	   
   } 
   
   @DeleteMapping("/deletecountry/{id}")
   public AddResponse deleteCountry(@PathVariable(value="id") int id)
   {
	   return countryService.deleteCountry(id);
   }
   
}





