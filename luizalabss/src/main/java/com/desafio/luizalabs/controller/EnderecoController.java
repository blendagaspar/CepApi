package com.desafio.luizalabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.luizalabs.model.Endereco;
import com.desafio.luizalabs.repository.EnderecoRepository;



/**é uma classe controller 
 é a URI aonde será acessada a API
para aceitar requisições de qualquer origem*/
@RestController                                                     
@RequestMapping("/endereco")                                       
@CrossOrigin("*")                                                    
public class EnderecoController {
	
	
	/**injeção de independencia do spring */
	@Autowired                                                        
	private EnderecoRepository enderecoRepository; 
	
	/**pesquisar por endereço pelo método Get do HTTP*/
	@GetMapping                                                      
	public ResponseEntity<List<Endereco>> GetAll () {
		return ResponseEntity.ok(enderecoRepository.findAll());
    }
	
	
	/**pesquisar por cep pelo método HTTP (GET)*/
	@GetMapping("/{cep}")	
	public ResponseEntity<List<Endereco>> GetByCep(@PathVariable String cep){
		return ResponseEntity.ok(enderecoRepository.findAllByCep(cep));
	}
	
	/**adicionar ceps ao banco de dados para testes pelo método HTTP (POST) */
	@PostMapping
	public ResponseEntity<Endereco>postEndereco(@RequestBody Endereco endereco){
			
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(endereco));
					
     }
	
		
	 
}
