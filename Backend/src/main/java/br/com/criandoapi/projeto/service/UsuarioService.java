package br.com.criandoapi.projeto.service;

import br.com.criandoapi.projeto.entity.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Usuario atualizarUsuario(Usuario usuario) {
        Usuario usarioNovo = repository.save(usuario);
        return usuario;
    }

    public void excluirUsuario(Integer id) {
        repository.deleteById(id);
    }

    public void excluirTodosUsuarios() {
        repository.deleteAll();
    }



}
