package br.com.zupacademy.vinicius.casadocodigo.config.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.vinicius.casadocodigo.categorias.cadastro.Categoria;
import br.com.zupacademy.vinicius.casadocodigo.categorias.cadastro.CategoriaDTO;
import br.com.zupacademy.vinicius.casadocodigo.categorias.cadastro.CategoriaRepository;

@Component
public class NomeUnicoCategoriaValidator implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CategoriaDTO dto = (CategoriaDTO) target;
		Optional<Categoria> existeNome = categoriaRepository.findByNomeIgnoreCase(dto.getNome());

		if (existeNome.isPresent()) {
			errors.rejectValue("nome", "NomeUnico");
		}

	}

}
