package com.countryservice.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.controllers.AddResponse;
import com.countryservice.demo.repositories.CountryRepository;

@Component
@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	public List<Country> getAllCountries() {

		return countryRepository.findAll();

	}

	public Country getCountryById(int id) {

		return countryRepository.findById(id).get();

	}

	public Country getCountryByName(String name) {
		Country countryObj = null;

		List<Country> countries = countryRepository.findAll();

		for (Country c : countries) {
			if (c.getCountryName().equalsIgnoreCase(name))
				countryObj = c;
		}

		return countryObj;

	}

	public Country addNewCountry(Country cntObj) {

		cntObj.setId(getMaxID());
		countryRepository.save(cntObj);

		return cntObj;
	}

	// Utility to get max id from Map
	public int getMaxID() {
		int i = countryRepository.findAll().size();

		return ++i;
	}

	public Country updateExistingCountry(Country country) {

		countryRepository.save(country);
		return country;
	}

	public AddResponse deleteCountry(int id) {
		countryRepository.deleteById(id);
		AddResponse response = new AddResponse();
		response.setMsg(id + "country is deleted from Country table...");
		return response;
	}

}
