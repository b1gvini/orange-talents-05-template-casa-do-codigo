package br.com.zupacademy.vinicius.casadocodigo.localizacao.pais;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.vinicius.casadocodigo.config.validacao.UniqueValue;

public class PaisDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class,fieldName = "nome")
	private String nome;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public PaisDTO(String nome) {
		this.nome = nome;
	}
	
	public Pais converter() {
		return new Pais(nome);
	}

}
