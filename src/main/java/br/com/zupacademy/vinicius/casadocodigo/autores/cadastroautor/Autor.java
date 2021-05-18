package br.com.zupacademy.vinicius.casadocodigo.autores.cadastroautor;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty
	private String nome;
	@Email
	private String email;
	@NotNull @NotEmpty @Length(max=400)
	@Type(type = "text")
	private String descricao;
	private OffsetDateTime criadoEm;
	
	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.criadoEm = OffsetDateTime.now();
	}
	
}
