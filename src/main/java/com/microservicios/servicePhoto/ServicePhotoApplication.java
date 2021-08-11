package com.microservicios.servicePhoto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@EnableEurekaClient
public class ServicePhotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePhotoApplication.class, args);
	}

}
