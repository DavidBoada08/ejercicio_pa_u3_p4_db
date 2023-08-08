package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class EjercicioPaU3P4DbApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(EjercicioPaU3P4DbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU3P4DbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
