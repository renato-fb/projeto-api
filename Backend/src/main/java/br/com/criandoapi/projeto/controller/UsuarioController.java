package br.com.criandoapi.projeto.controller;

import java.util.List;

import br.com.criandoapi.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoapi.projeto.entity.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;

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

	@PostMapping
	public ResponseEntity<Usuario> criarUsuario (@RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> alterarUsuario (@RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(usuarioService.atualizarUsuario(usuario));
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
}
