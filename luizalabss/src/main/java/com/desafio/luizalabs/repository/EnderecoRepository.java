package com.desafio.luizalabs.repository;


import java.util.List;
              

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.luizalabs.model.Endereco;


/**é uma classe de repository que será responsável pela comunicação com o banco de dados*/
@Repository   
public interface  EnderecoRepository extends JpaRepository<Endereco, Long> {

	/** Listar no banco de dados todos os atributos do endereço pelo Cep */
	public List<Endereco> findAllByCep(String  cep); 
	
	
}
