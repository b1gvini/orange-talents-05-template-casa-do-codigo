package br.com.zupacademy.vinicius.casadocodigo.categoria;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.vinicius.casadocodigo.autor.Autor;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findByNomeIgnoreCase(String nome);

}
