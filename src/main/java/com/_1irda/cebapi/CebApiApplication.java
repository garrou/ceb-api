package com._1irda.cebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CebApiApplication {

	public static final int MAX_OPERANDS = 6;

	public static void main(String[] args) {
		SpringApplication.run(CebApiApplication.class, args);
	}

}
