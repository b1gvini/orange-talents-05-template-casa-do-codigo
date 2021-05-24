package br.com.zupacademy.vinicius.casadocodigo.estadoepais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.vinicius.casadocodigo.validacao.ExistingID;

public class EstadoDTO {

	@NotBlank
	private String nome;

	@NotNull
	@ExistingID(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	public EstadoDTO(String nome, Long id) {
		this.nome = nome;
		this.idPais = id;
	}

	public Estado converter(PaisRepository paisRepository) {
		Pais pais = paisRepository.getOne(idPais);
		return new Estado(nome, pais);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

}
