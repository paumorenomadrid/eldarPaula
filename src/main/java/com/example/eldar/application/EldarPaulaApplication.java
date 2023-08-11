package com.example.eldar.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import static com.example.eldar.application.Ejercicio1.ejercicioUno;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.eldar")
public class EldarPaulaApplication {

	public static void main(String[] args) {

		SpringApplication.run(EldarPaulaApplication.class, args);

		ejercicioUno();
	}


}
