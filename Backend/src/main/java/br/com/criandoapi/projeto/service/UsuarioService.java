package br.com.criandoapi.projeto.service;

import br.com.criandoapi.projeto.entity.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private IUsuario repository;

    public UsuarioService (IUsuario repository) {
        this.repository = repository;
    }

    public List<Usuario> listarUsuarios () {
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario) {
        Usuario usarioNovo = repository.save(usuario);
        return usuario;
    }


}
