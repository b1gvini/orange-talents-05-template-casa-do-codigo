package br.com.zupacademy.vinicius.casadocodigo.livros.listar;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.vinicius.casadocodigo.livros.Livro;

public class DetalharLivroDTO {

	private String titulo;
	
	private String nomeAutor;
	
	private String categoria;

	private String resumo;

	private String sumario;

	private BigDecimal precoDoLivro;

	private Integer numPaginas;

	private String isbn;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataDeEntrarNoAr;

	@JsonCreator
	public DetalharLivroDTO(Livro livro) {
		this.titulo = livro.getTitulo();
		this.nomeAutor = livro.getAutor().getNome();
		this.categoria = livro.getCategoria().getNome();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.precoDoLivro = livro.getPrecoDoLivro();
		this.numPaginas = livro.getNumPaginas();
		this.isbn = livro.getIsbn();
		this.dataDeEntrarNoAr = livro.getDataDeEntrarNoAr();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPrecoDoLivro() {
		return precoDoLivro;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataDeEntrarNoAr() {
		return dataDeEntrarNoAr;
	}
	
	
	
	
}
