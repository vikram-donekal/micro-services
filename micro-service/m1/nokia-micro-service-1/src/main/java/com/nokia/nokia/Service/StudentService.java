package com.nokia.nokia.Service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nokia.nokia.DTO.Student;
import com.nokia.nokia.Repo.StudentRepository;

@Service
@CacheConfig(cacheNames = {"student"})

public class StudentService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());	

	@Autowired
	StudentRepository studentRepo;

	public List<Student> getAll() {

		LOGGER.info("Inside getAll Service");
		return studentRepo.findAll();
	}
	
	@Cacheable(key="#id")
	public Student getById(Long id) {


		LOGGER.info("Inside getById Service");
		LOGGER.info("############# Backend processing...");

		Optional<Student> optionalStudent =studentRepo.findById(id);
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

		Optional<Student> optionalStudent =studentRepo.findById(id);
		if(optionalStudent.isPresent()){
			studentRepo.deleteById(id);
			return "Student Deleted ";
		}else{
			return "Student not found to delete ";
		}

	}

	@CacheEvict(allEntries=true)
	public String delteAll() {

		LOGGER.info("Inside delteAll Service");
		LOGGER.info("############# Backend processing...");
		studentRepo.deleteAll();
		return "ALL Students are deleted";
	}


}
