package br.com.criandoapi.projeto.service;

import br.com.criandoapi.projeto.dto.UsuarioDto;
import br.com.criandoapi.projeto.entity.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;
import br.com.criandoapi.projeto.security.Token;
import br.com.criandoapi.projeto.security.TokenUtil;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class UsuarioService {


    private final IUsuario repository;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService (IUsuario repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuarios () {
        logger.info("Usuario: " + getLogado() + " Listando Usarios");
        return repository.findAll();
    }

    public Usuario criarUsuario(Usuario usuario) {
        logger.info("Usuario: " + getLogado() + " Criando usuário");
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        return usuario;
    }

    public Usuario editarUsuario(Usuario usuario) {
        logger.info("Usuario: " + getLogado() + " Editando usuário: " + usuario);
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        return usuario;
    }

    public boolean excluirUsuario(Integer id) {
        logger.info("Usuario: " + getLogado() + " Excluindo usuário");
        repository.deleteById(id);
        return true;
    }

    public void excluirTodosUsuarios() {
        repository.deleteAll();
        logger.info("Usuario: " + getLogado() + " Excluindo todos usuarios usuário");
    }

    public Token gerarToken(@Valid UsuarioDto usuario) {
        Usuario user = repository.findByEmailOrSenha(usuario.getEmail(), usuario.getSenha());
        if(user != null) {
            Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha());
            if(valid) {
                return new Token(TokenUtil.createToken(user));
            }
        }
        return null;
    }

    private String getLogado() {
        Authentication userLogado = SecurityContextHolder.getContext().getAuthentication();
        if(!(userLogado instanceof AnonymousAuthenticationToken)) {
            return userLogado.getName();
        }
        return "Null";
    }
}


