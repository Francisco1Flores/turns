package com.personal.turns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class TurnsApplication {
	public static void main(String[] args) {
		SpringApplication.run(TurnsApplication.class, args);
	}
}