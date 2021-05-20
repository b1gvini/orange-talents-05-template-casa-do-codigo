package br.com.zupacademy.vinicius.casadocodigo.livros.listar;

import br.com.zupacademy.vinicius.casadocodigo.livros.Livro;

public class ListarLivroDTO {
	
	private Long Id;
	private String nome;
	
	public ListarLivroDTO(Livro livro) {
		this.Id = livro.getId();
		this.nome = livro.getNome();
	}

	public Long getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}
	
}
