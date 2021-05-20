package br.com.zupacademy.vinicius.casadocodigo.autores.cadastroautor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	public Optional<Autor> findByEmail(String email);
	public Optional<Autor> findByNome(String nome);

}
