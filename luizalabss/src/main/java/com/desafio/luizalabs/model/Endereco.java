package com.desafio.luizalabs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





/**endtidade do JPA hibernate */
@Entity              
/**criar tabela com nome de endereço no banco de dados*/
@Table(name = "endereco")  
public class Endereco {                 

	
	@Id                                                      
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "digite cep no formato 8888888")
	@Size(min= 8 , max = 8, message = "digite apenas 8 caracteres")
	private String cep;
	
	@NotNull(message = "digite o nome da rua")
	private String rua ;
	
	@NotNull(message = "digite o nome do bairro")
	private String bairro;
	
	@NotNull(message = "digite o nome da cidade")
	private String cidade;
	
	@NotNull(message = "digite o nome do estado")
	private String estado;
   
	@ManyToOne
	@JsonIgnoreProperties ("endereco")
	private Usuario usuario;
	
	
	//getters e setteres 
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
