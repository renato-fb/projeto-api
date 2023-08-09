package br.com.criandoapi.projeto.config;

import br.com.criandoapi.projeto.entity.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    public IUsuario respository;
    public TestConfig(IUsuario repository) {
        this.respository = repository;
    }
    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario(null, "Renato", "reare@gmail.com", "sadasd");
        Usuario u2 = new Usuario(null, "Renato", "reares@gmail.com", "sadasd");
        Usuario u3 = new Usuario(null, "Renato", "rearde@gmail.com", "sadasd");
        Usuario u4 = new Usuario(null, "Renato", "rearedsas@gmail.com", "sadasd");
        Usuario u5 = new Usuario(null, "Renato", "rearddsae@gmail.com", "sadasd");
        Usuario u6 = new Usuario(null, "Renato", "rearedsasd@gmail.com", "sadasd");

        respository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
    }
}
