package com.nokia.nokia.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.nokia.Service.StudentService;

@RestController

public class StudentController {
	
	
	@RestController
	public class studentController {

		private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
		
		@Autowired
		StudentService studentService;
		
		@GetMapping("/api/student/find/all")
		public ResponseEntity<?> getAllStudents(){
			
			LOGGER.info("Inside  getAllStudents Controller ");		
			return new ResponseEntity<>(studentService.getAll(),HttpStatus.OK);
		}
		
		@GetMapping("/api/student/find/{id}")
		public ResponseEntity<?> getStudentById(@PathVariable Long id){
			
			LOGGER.info("Inside  getStudentById Controller ");

			return new ResponseEntity<>(studentService.getById(id),HttpStatus.OK);
		}
	
		
		@DeleteMapping("/api/student/delete/all")
		public ResponseEntity<?> deleteAllStudent(){
			
			LOGGER.info("Inside  deleteAllStudent Controller ");
			return new ResponseEntity<>(studentService.delteAll(),HttpStatus.OK);
		}
		@DeleteMapping("/api/student/delete/{id}")
		public ResponseEntity<?> deleteStudentById(@PathVariable Long id){

			LOGGER.info("Inside  deleteStudentById Controller ");
			return  new ResponseEntity<>(studentService.deleteById(id),HttpStatus.OK);
		}
	}

}
