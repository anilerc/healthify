package com.anilerc.healthify;

import com.anilerc.healthify.models.Doctor;
import com.anilerc.healthify.services.DoctorService;
import com.anilerc.healthify.utility.Gender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HealthifyApplication {
	public static void main(String[] args) {
		SpringApplication.run(HealthifyApplication.class, args);
	}

}
