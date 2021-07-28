package com.microservicios.servicePhoto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class ServicePhotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePhotoApplication.class, args);
	}

}
