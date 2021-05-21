package br.com.zupacademy.vinicius.casadocodigo.localizacao.estado;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface EstadoRepository extends JpaRepository<Estado, Long>{
	
	@Query(value = "Select * from estado WHERE pais_id = :id and nome = :nome", nativeQuery = true)
	Optional<Estado> jaExisteEstadoNestePais(@Param("id") long id, @Param("nome") String nome);

}
