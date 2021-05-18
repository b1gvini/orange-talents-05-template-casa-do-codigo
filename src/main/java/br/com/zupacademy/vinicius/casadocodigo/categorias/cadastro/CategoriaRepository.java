package br.com.zupacademy.vinicius.casadocodigo.categorias.cadastro;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findByNomeIgnoreCase(String nome);

}
