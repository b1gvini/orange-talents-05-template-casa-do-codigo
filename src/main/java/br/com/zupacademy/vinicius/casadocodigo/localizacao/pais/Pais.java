package br.com.zupacademy.vinicius.casadocodigo.localizacao.pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	public Pais() {
		
	}

	public Pais(String nome) {
		this.nome = nome;
	}
}
