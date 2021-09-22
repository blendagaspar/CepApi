package com.desafio.luizalabs.service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.desafio.luizalabs.model.Usuario;
import com.desafio.luizalabs.model.UsuarioLogin;
import com.desafio.luizalabs.repository.UsuarioRepository;



@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
     public Optional<Usuario> cadastrarUsuario(Usuario usuario) {
		
		
		if(usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			throw new ResponseStatusException(
		          	HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);

		return Optional.of(usuarioRepository.save(usuario));
	}

	
    public Optional<Usuario> atualizarUsuario(Usuario usuario){
	
	if(usuarioRepository.findById(usuario.getId()).isPresent()) {
		
				
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return Optional.of(usuarioRepository.save(usuario));
	
	}else {
		
		throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
		
	}
	
}


public Optional<UsuarioLogin> logarUsuario(Optional<UsuarioLogin> usuarioLogin) {

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	Optional<Usuario> usuario = usuarioRepository.findByUsuario(usuarioLogin.get().getUsuario());

	if (usuario.isPresent()) {
		if (encoder.matches(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {

			String auth = usuarioLogin.get().getUsuario() + ":" + usuarioLogin.get().getSenha();
			byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
			String authHeader = "Basic " + new String(encodedAuth);

			usuarioLogin.get().setToken(authHeader);				
			usuarioLogin.get().setUsuario(usuario.get().getUsuario());
			usuarioLogin.get().setSenha(usuario.get().getSenha());
			
			return usuarioLogin;

		}
	}
	throw new ResponseStatusException(
			HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos!", null);
}
	
	
	
	
	
	
	
	
	
}
