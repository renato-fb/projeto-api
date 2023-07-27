package br.com.criandoapi.projeto;

import br.com.criandoapi.projeto.entity.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) {

		System.out.println("Application started!");
		SpringApplication.run(ProjetoApplication.class, args);
	}

}
