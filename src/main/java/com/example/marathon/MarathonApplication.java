package com.example.marathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;


@SpringBootApplication
public class MarathonApplication {
static List<Integer> arr ;
	public static void main(String[] args) {
	ApplicationContext ac= SpringApplication.run(MarathonApplication.class, args);


	System.out.println("Spring Server running");
	}

}
