package br.com.zupacademy.vinicius.casadocodigo.config.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.vinicius.casadocodigo.localizacao.estado.Estado;
import br.com.zupacademy.vinicius.casadocodigo.localizacao.estado.EstadoDTO;
import br.com.zupacademy.vinicius.casadocodigo.localizacao.estado.EstadoRepository;

@Component
public class EstadoUnicoPorPaisValidator implements Validator {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return EstadoDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		EstadoDTO dto = (EstadoDTO) target;
		
		Optional<Estado> existeEstado = estadoRepository.jaExisteEstadoNestePais(dto.getIdPais(), dto.getNome());
		if (existeEstado.isPresent()) {
			errors.rejectValue("idPais", "ExisteEstadoNestePais");
		}
		
		
		
		
	}

}
