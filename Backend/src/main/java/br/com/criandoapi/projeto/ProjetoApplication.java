package br.com.criandoapi.projeto;

import br.com.criandoapi.projeto.entity.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProjetoApplication {
	public static void main(String[] args) {

		System.out.println("Application started!");
		SpringApplication.run(ProjetoApplication.class, args);


	}
}
