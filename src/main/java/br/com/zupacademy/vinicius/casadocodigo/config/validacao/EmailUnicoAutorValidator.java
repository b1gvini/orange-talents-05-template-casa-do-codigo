package br.com.zupacademy.vinicius.casadocodigo.config.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.vinicius.casadocodigo.autores.cadastroautor.Autor;
import br.com.zupacademy.vinicius.casadocodigo.autores.cadastroautor.AutorDTO;
import br.com.zupacademy.vinicius.casadocodigo.autores.cadastroautor.AutorRepository;

@Component // Para ser gerenciada pelo Spring
public class EmailUnicoAutorValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors()) { // Verifica se já ocorreu algum outro erro de validação, caso sim, não
									// executamos nossa validação.
			return;
		}

		AutorDTO dto = (AutorDTO) target;
		Optional<Autor> existeAutor = autorRepository.findByEmail(dto.getEmail());
		if (existeAutor.isPresent()) {
			errors.rejectValue("email", "EmailUnico");

		}
	}

}
