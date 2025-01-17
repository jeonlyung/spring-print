package com.image.spring_print;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPrintApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPrintApplication.class, args);
		System.out.println("Main 테스트");
	}

}
