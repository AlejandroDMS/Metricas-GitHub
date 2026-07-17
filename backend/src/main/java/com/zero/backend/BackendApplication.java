package com.zero.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "com.zero.backend",
    "com.zero.backend.negocio.controladores",
    "com.zero.backend.servicios",
    "com.zero.backend.persistencia.dtos"
})
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
