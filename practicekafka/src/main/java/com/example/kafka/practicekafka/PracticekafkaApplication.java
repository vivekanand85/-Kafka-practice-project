package com.example.kafka.practicekafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticekafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticekafkaApplication.class, args);
		System.out.println("kafka is running");
	}

}
