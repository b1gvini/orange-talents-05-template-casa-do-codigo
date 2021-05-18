package br.com.zupacademy.vinicius.casadocodigo.autores.cadastroautor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

public class AutorDTO {

	@NotNull
	@NotEmpty
	private String nome;
	@Email
	@NotEmpty
	@NotNull
	private String email;
	@NotNull
	@NotEmpty
	@Length(max = 400)
	@Type(type = "text")
	private String descricao;

	public AutorDTO(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor ConverterParaEntidade() {
		return new Autor(nome, email, descricao);
	}
}
