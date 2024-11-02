package com.parking.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.parking.entities")
public class ParkingproyectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingproyectApplication.class, args);
	}

}
