package br.com.zupacademy.vinicius.casadocodigo.cliente;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.vinicius.casadocodigo.estadoepais.Estado;
import br.com.zupacademy.vinicius.casadocodigo.estadoepais.EstadoRepository;
import br.com.zupacademy.vinicius.casadocodigo.estadoepais.Pais;
import br.com.zupacademy.vinicius.casadocodigo.estadoepais.PaisRepository;
import br.com.zupacademy.vinicius.casadocodigo.validacao.CpfOuCnpj;
import br.com.zupacademy.vinicius.casadocodigo.validacao.ExistingID;
import br.com.zupacademy.vinicius.casadocodigo.validacao.UniqueValue;

public class ClienteDTO {

	@Email
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CpfOuCnpj
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull 
	@ExistingID(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	private Long idEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public ClienteDTO(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			@NotNull Long idPais, @NotBlank String telefone, @NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.telefone = telefone;
		this.cep = cep;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Optional<Pais> pais = paisRepository.findById(idPais);
		if (idEstado == null) {
			return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais.get(), telefone,
					cep);
		}
		Optional<Estado> estado = estadoRepository.findById(idEstado);
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais.get(), estado.get(),
				telefone, cep);

	}

	public Long getIdEstado() {
		return idEstado;
	}

	public Long getIdPais() {
		return idPais;
	}
}
