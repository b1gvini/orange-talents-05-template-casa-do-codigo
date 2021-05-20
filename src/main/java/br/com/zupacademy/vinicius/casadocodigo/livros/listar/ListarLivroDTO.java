package br.com.zupacademy.vinicius.casadocodigo.livros.listar;

public class ListarLivroDTO {
	
	private Long Id;
	private String nome;
	
	public ListarLivroDTO(Long id, String titulo) {
		this.Id = id;
		this.nome = titulo;
	}

	public Long getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}
	
}
