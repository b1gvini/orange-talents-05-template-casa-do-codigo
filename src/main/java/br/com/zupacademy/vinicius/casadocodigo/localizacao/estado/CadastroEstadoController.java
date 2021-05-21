package br.com.zupacademy.vinicius.casadocodigo.localizacao.estado;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vinicius.casadocodigo.config.validacao.EstadoUnicoPorPaisValidator;
import br.com.zupacademy.vinicius.casadocodigo.localizacao.pais.PaisRepository;

@RestController
@RequestMapping("/estados")
public class CadastroEstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired EstadoUnicoPorPaisValidator validator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
	@PostMapping
	public ResponseEntity<EstadoDTO> cadastrar(@RequestBody @Valid EstadoDTO dto) {

			Estado estado = dto.converter(paisRepository);
			estadoRepository.save(estado);	
			return ResponseEntity.ok().build();
	
	}
		
	
}
