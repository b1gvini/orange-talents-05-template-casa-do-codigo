package br.com.zupacademy.vinicius.casadocodigo.localizacao.estado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.vinicius.casadocodigo.config.validacao.ExistingID;
import br.com.zupacademy.vinicius.casadocodigo.localizacao.pais.Pais;
import br.com.zupacademy.vinicius.casadocodigo.localizacao.pais.PaisRepository;

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
