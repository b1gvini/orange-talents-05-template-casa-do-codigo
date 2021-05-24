package br.com.zupacademy.vinicius.casadocodigo.estadoepais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@ManyToOne
	private Pais pais;
	
	@Deprecated
	public Estado() {
		
	}
	public Estado(String nome) {
		this.nome = nome;
	}
	
	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
	
	public Long getId() {
		return id;
	}
	
}
