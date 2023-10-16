package com.example.DocumentMessagePattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DocumentMessagePatternApplication implements CommandLineRunner {

	@Autowired
	private RegistrationService registrationService;

	@Override
	public void run(String... args) throws Exception {
		registrationService.getReservation(new ReservationRecord("Person1", new Date()));
	}

	public static void main(String[] args) {
		SpringApplication.run(DocumentMessagePatternApplication.class, args);
	}
}
