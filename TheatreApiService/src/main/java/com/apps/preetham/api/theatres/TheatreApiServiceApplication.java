package com.apps.preetham.api.theatres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.apps.preetham.api.theatres")
//@EntityScan(basePackages = "com.apps.preetham.api.theatres")
@EnableDiscoveryClient
@SpringBootApplication
public class TheatreApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreApiServiceApplication.class, args);
	}

}

