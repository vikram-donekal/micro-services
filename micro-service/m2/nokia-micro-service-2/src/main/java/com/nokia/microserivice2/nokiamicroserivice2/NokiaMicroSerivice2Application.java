package com.nokia.microserivice2.nokiamicroserivice2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;

import com.nokia.microserivice2.nokiamicroserivice2.DTO.City;
import com.nokia.microserivice2.nokiamicroserivice2.Repo.CityRepository;


@SpringBootApplication
@EnableCaching
public class NokiaMicroSerivice2Application  implements CommandLineRunner{

	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	CityRepository cityRepo;
	
	@Autowired
	Environment env;
	
	
	public static void main(String[] args) {
		SpringApplication.run(NokiaMicroSerivice2Application.class, args);
	}
	

	@Override
	public void run(String... arg0) throws Exception {
		
		
		LOGGER.info("Installizing Data ");
		
		for (int i=0;i<(int)(Math.random() * ((100 - 50) + 1)) + 50;i++){
			City objCity= new City();
			objCity.setPinCode(i+(int)Math.random());
			objCity.setLocation("Nokia Branch Name "+i);
			objCity.setCountry("India"+i);
			objCity=cityRepo.save(objCity);
			LOGGER.info("inserting ---->"+objCity.toString());
			
		}
		
		LOGGER.info("\n\n\nApplication Listening on Port "+env.getProperty("server.port"));
		
	}
}
