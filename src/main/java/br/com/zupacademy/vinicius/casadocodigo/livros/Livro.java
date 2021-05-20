package br.com.zupacademy.vinicius.casadocodigo.livros;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.vinicius.casadocodigo.autores.cadastroautor.Autor;
import br.com.zupacademy.vinicius.casadocodigo.categorias.cadastro.Categoria;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String titulo;

	@Lob
	@Length(max = 500)
	@NotBlank
	private String resumo;

	@Lob
	@NotBlank
	private String sumario;

	@Max(value = 20)
	@NotNull
	private BigDecimal precoDoLivro;

	@Min(value = 100)
	@NotNull
	private Integer numPaginas;

	@ISBN
	@NotBlank
	private String isbn;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@Future
	private LocalDate dataDeEntrarNoAr;

	public void setDataDeEntrarNoAr(LocalDate dataDeEntrarNoAr) {
		this.dataDeEntrarNoAr = dataDeEntrarNoAr;
	}

	@ManyToOne
	private Autor autor;

	@ManyToOne
	private Categoria categoria;

	public Livro() {

	}

	public Livro(@NotBlank String titulo, @Length(max = 500) @NotBlank String resumo, @NotBlank String sumario,
			@Max(20) @NotNull BigDecimal precoDoLivro, @Min(100) @NotNull Integer numPaginas,
			@ISBN @NotBlank String isbn, LocalDate dataDeEntrarNoAr, Autor autor, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.precoDoLivro = precoDoLivro;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.dataDeEntrarNoAr = dataDeEntrarNoAr;
		this.autor = autor;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
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

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

}
