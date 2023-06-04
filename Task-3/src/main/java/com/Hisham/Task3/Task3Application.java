package com.Hisham.Task3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class Task3Application {


	public static void main(String[] args) {
		SpringApplication.run(Task3Application.class, args);
	}

}
