package com.trab.controle_de_estoque_micelico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication //Service e controller em arquivos separados

@Configuration
@EnableJpaRepositories(basePackages = "com.trab.controle_de_estoque_micelico.repository") 

public class ControleDeEstoqueMicelicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleDeEstoqueMicelicoApplication.class, args);
	}

}

