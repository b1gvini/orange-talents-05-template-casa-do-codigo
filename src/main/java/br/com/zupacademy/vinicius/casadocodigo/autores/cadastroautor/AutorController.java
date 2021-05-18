package br.com.zupacademy.vinicius.casadocodigo.autores.cadastroautor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vinicius.casadocodigo.config.validacao.EmailUnicoAutorValidator;

@RequestMapping("/autores")
@RestController
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private EmailUnicoAutorValidator emailUnicoAutorValidator;
	
	
	/*
	 * Um método público com essa anotação é utilizado na primeira request recebida pelo controller
	 * o código dentro do init é executado para fazer configurações adicionais
	 * que precisam ser colocadas na execução da request relativa a este controller.
	 */
	@InitBinder
	public void init(WebDataBinder binder){ 
		binder.addValidators(emailUnicoAutorValidator);
	}

	@PostMapping
	public ResponseEntity<AutorDTO> cadastrar(@RequestBody @Valid AutorDTO dto) {
		Autor autor = dto.ConverterParaEntidade();
		autorRepository.save(autor);
		
		return ResponseEntity.ok().build();
		
	}

}
