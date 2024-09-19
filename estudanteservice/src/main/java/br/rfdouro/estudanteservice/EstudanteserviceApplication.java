package br.rfdouro.estudanteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EstudanteserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudanteserviceApplication.class, args);
	}

}
