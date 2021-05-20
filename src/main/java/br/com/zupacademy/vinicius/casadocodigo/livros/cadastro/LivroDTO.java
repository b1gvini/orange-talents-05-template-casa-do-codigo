package br.com.zupacademy.vinicius.casadocodigo.livros.cadastro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Lob;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.vinicius.casadocodigo.autores.cadastroautor.Autor;
import br.com.zupacademy.vinicius.casadocodigo.autores.cadastroautor.AutorRepository;
import br.com.zupacademy.vinicius.casadocodigo.categorias.cadastro.Categoria;
import br.com.zupacademy.vinicius.casadocodigo.categorias.cadastro.CategoriaRepository;
import br.com.zupacademy.vinicius.casadocodigo.config.validacao.UniqueValue;

public class LivroDTO {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;

	@Lob
	@Length(max = 500)
	@NotBlank
	private String resumo;

	@Lob
	@NotBlank
	private String sumario;

	@Min(value = 20)
	@NotNull
	private BigDecimal precoDoLivro;

	@Min(value = 100)
	@NotNull
	private Integer numPaginas;

	@ISBN
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@NotNull
	private LocalDate dataDeEntrarNoAr;

	private void setDataDeEntrrNoAr(LocalDate dataDeEntrarNoAr) {
		this.dataDeEntrarNoAr = dataDeEntrarNoAr;
	}

	@NotNull
	private Long autor;

	@NotNull
	private Long categoria;

	public LivroDTO(@NotBlank String titulo, @Length(max = 500) @NotBlank String resumo, @NotBlank String sumario,
			@Max(20) @NotNull BigDecimal precoDoLivro, @Min(100) @NotNull Integer numPaginas,
			@ISBN @NotBlank String isbn, @NotNull Long autor, @NotNull Long categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.precoDoLivro = precoDoLivro;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.autor = autor;
		this.categoria = categoria;
	}

	public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		Autor autorEntidade = autorRepository.findById(autor).get();
		Categoria categoriaEntidade = categoriaRepository.findById(categoria).get();
		return new Livro(titulo, resumo, sumario, precoDoLivro, numPaginas, isbn, dataDeEntrarNoAr, autorEntidade,
				categoriaEntidade);
	}

	public String getTitulo() {
		return titulo;
	}

	public LocalDate getDataDeEntrarNoAr() {
		return dataDeEntrarNoAr;
	}

	public void setDataDeEntrarNoAr(LocalDate dataDeEntrarNoAr) {
		this.dataDeEntrarNoAr = dataDeEntrarNoAr;
	}

}