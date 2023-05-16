//aqui e o start (run) da aplicação.
//utilização do H2 banco de dados em memória.
//Uso do Postman para o teste.

package com.proj.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjApiApplication.class, args);
	}

}
