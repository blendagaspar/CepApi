package com.desafio.luizalabs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.luizalabs.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	
	
	public Optional<Usuario> findByUsuario(String usuario);
}
