package com.nokia.microserivice2.nokiamicroserivice2.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.microserivice2.nokiamicroserivice2.Service.CityService;




@RestController
public class CityController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CityService cityService;

	@GetMapping("/api/city/find/all")
	public ResponseEntity<?> getAllCitiesy(){

		LOGGER.info("Inside  getAllCitiesy Controller ");		
		return new ResponseEntity<>(cityService.getAll(),HttpStatus.OK);
	}

	@GetMapping("/api/city/find/{id}")
	public ResponseEntity<?> getCityById(@PathVariable Long id){

		LOGGER.info("Inside  getCityById Controller ");

		return new ResponseEntity<>(cityService.getById(id),HttpStatus.OK);
	}


	@DeleteMapping("/api/city/delete/all")
	public ResponseEntity<?> deleteAllCity(){

		LOGGER.info("Inside  deleteAllCity Controller ");
		return new ResponseEntity<>(cityService.delteAll(),HttpStatus.OK);
	}
	@DeleteMapping("/api/city/delete/{id}")
	public ResponseEntity<?> deleteCitytById(@PathVariable Long id){

		LOGGER.info("Inside  deleteCitytById Controller ");
		return  new ResponseEntity<>(cityService.deleteById(id),HttpStatus.OK);
	}
}

