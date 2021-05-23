package br.com.zupacademy.vinicius.casadocodigo.cliente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.vinicius.casadocodigo.localizacao.estado.Estado;
import br.com.zupacademy.vinicius.casadocodigo.localizacao.estado.EstadoRepository;

@Component
public class ExisteEstadoNestePaisValidator implements Validator {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors()) {
			return;
		}

		ClienteDTO dto = (ClienteDTO) target;

		Optional<Estado> estado = estadoRepository.findByIdAndPaisId(dto.getIdEstado(), dto.getIdPais());

		if (estado.isEmpty()) {
			errors.rejectValue("idEstado", "ExisteEstadoNestePaisMSG");

		}

	}

}
