package com.nokia.nokia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;

import com.nokia.nokia.DTO.Student;
import com.nokia.nokia.Repo.StudentRepository;


@SpringBootApplication
@EnableCaching
public class NokiaApplication  implements CommandLineRunner{

	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	Environment env;
	
	
	public static void main(String[] args) {
		SpringApplication.run(NokiaApplication.class, args);
	}
	

	@Override
	public void run(String... arg0) throws Exception {
		
		
		LOGGER.info("Installizing Data ");
		
		for (int i=0;i<(int)(Math.random() * ((100 - 50) + 1)) + 50;i++){
			Student obStudent= new Student();
			obStudent.setAge(i+(int)Math.random());
			obStudent.setFirstName("Nokia"+i);
			obStudent.setLastName("India"+i);
			
			LOGGER.info("inserting ---->"+obStudent.toString());
			studentRepo.save(obStudent);
			
		}
		
		LOGGER.info("\n\n\nApplication Listening on Port "+env.getProperty("server.port"));
		
	}
}
