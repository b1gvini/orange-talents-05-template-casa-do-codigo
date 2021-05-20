package br.com.zupacademy.vinicius.casadocodigo.categorias.cadastro;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.vinicius.casadocodigo.autores.cadastroautor.Autor;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findByNomeIgnoreCase(String nome);

}
