package br.com.zupacademy.vinicius.casadocodigo.livros.listar;

public class ListarLivroDTO {
	
	private Long id;
	private String nome;
	
	public ListarLivroDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
