package com.project.springsecurityauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


//@EntityScan("com.project.springsecurityauth")
@SpringBootApplication
public class SpringSecurityAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuthApplication.class, args);
	}

}
