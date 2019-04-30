package com.nokia.microserivice2.nokiamicroserivice2.Service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nokia.microserivice2.nokiamicroserivice2.DTO.City;
import com.nokia.microserivice2.nokiamicroserivice2.Repo.CityRepository;

@Service
@CacheConfig(cacheNames = {"city"})

public class CityService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());	

	@Autowired
	CityRepository cityRepo;

	public List<City> getAll() {

		LOGGER.info("Inside getAll Service");
		return cityRepo.findAll();
	}
	
	@Cacheable(key="#id")
	public City getById(Long id) {


		LOGGER.info("Inside getById Service");
		LOGGER.info("############# Backend processing...");

		Optional<City> optionalStudent =cityRepo.findById(id);
		if(optionalStudent.isPresent()){	
			return optionalStudent.get();
		}else{
			return null;
		}	

	}

	@CacheEvict(key = "#id")
	public String deleteById(Long id) {

		LOGGER.info("Inside deleteById Service");
		LOGGER.info("############# Backend processing...");

		Optional<City> optionalStudent =cityRepo.findById(id);
		if(optionalStudent.isPresent()){
			cityRepo.deleteById(id);
			return "Student Deleted ";
		}else{
			return "Student not found to delete ";
		}

	}

	@CacheEvict(allEntries=true)
	public String delteAll() {

		LOGGER.info("Inside delteAll Service");
		LOGGER.info("############# Backend processing...");
		cityRepo.deleteAll();
		return "ALL Students are deleted";
	}


}
