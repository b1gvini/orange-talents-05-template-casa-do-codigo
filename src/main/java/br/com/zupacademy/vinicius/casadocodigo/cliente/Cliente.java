package br.com.zupacademy.vinicius.casadocodigo.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.vinicius.casadocodigo.estadoepais.Estado;
import br.com.zupacademy.vinicius.casadocodigo.estadoepais.Pais;
import br.com.zupacademy.vinicius.casadocodigo.validacao.UniqueValue;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String nome;

	private String sobrenome;

	private String documento;

	private String endereco;

	private String complemento;

	private String cidade;

	@ManyToOne
	private Pais pais;

	@ManyToOne
	private Estado estado;

	private String telefone;

	private String cep;

	@Deprecated
	public Cliente() {

	}

	public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
			String cidade, Pais pais, String telefone, String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
			String cidade, Pais pais, Estado estado, String telefone, String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public ResponseClienteDTO converterParaDTO() {
		return new ResponseClienteDTO(this.id);
	}


}
