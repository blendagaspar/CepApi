package com.desafio.luizalabs.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.luizalabs.model.Usuario;
import com.desafio.luizalabs.model.UsuarioLogin;
import com.desafio.luizalabs.repository.UsuarioRepository;
import com.desafio.luizalabs.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> GetAll() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable long id){
		return usuarioRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());			
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> usuarioLogin) {
		
		return usuarioService.logarUsuario(usuarioLogin).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
		Optional<Usuario> novoUsuario = usuarioService.cadastrarUsuario(usuario);
		try {
				return ResponseEntity.ok(novoUsuario.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
		
	@PutMapping("/alterar")
	public ResponseEntity<Usuario> Put(@RequestBody Usuario usuario){
		Optional<Usuario> usuarioUpdate = usuarioService.atualizarUsuario(usuario);
		try {
			return ResponseEntity.ok(usuarioUpdate.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	
	
		
	
}
