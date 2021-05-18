package br.com.zupacademy.vinicius.casadocodigo.categorias.cadastro;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CategoriaDTO {

	@NotNull
	@NotBlank
	private String nome;

	/*
	 * Anotação para evitar erro "JSON parse error: Cannot construct instance of.."
	 * já que não temos construtor padrão. Para evitarmos, bastaria criar um
	 * construtor padrão.
	 */
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public CategoriaDTO(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public Categoria converter() {
		return new Categoria(nome);
	}

}
