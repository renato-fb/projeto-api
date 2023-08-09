package br.com.criandoapi.projeto.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.criandoapi.projeto.dto.UsuarioDto;
import br.com.criandoapi.projeto.security.Token;
import br.com.criandoapi.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import br.com.criandoapi.projeto.entity.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;


@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

	private UsuarioService usuarioService;
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Usuario>> listarUsuarios () {
		return ResponseEntity.status(200).body(usuarioService.listarUsuarios());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarUsuarios (@PathVariable Integer id) {
		return ResponseEntity.status(200).body(usuarioService.listarUsuario(id));
	}

	@PostMapping
	public ResponseEntity<Usuario> criarUsuario (@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> editarUsuario (@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(usuarioService.editarUsuario(usuario));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirUsuario (@PathVariable Integer id){
		usuarioService.excluirUsuario(id);
		return ResponseEntity.status(204).build();
	}

	@DeleteMapping("/all")
	public ResponseEntity<?> excluirTodosUsuarios() {
		usuarioService.excluirTodosUsuarios();
		return ResponseEntity.status(204).build();
	}

	@PostMapping("/login")
	public ResponseEntity<Token> logar(@Valid @RequestBody UsuarioDto usuario) {
		Token token = usuarioService.gerarToken(usuario);
		if(token != null) {
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(403).build();
	}
}

