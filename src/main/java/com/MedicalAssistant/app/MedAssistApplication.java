package com.MedicalAssistant.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedAssistApplication {

	public static void main(String[] args) {
		System.out.println(System.getenv("MA_RESOURCES"));

//		SpringApplication.run(MedAssistApplication.class, args);
	}

}
