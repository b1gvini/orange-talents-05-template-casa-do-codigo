package br.com.zupacademy.vinicius.casadocodigo.autor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/autores")
@RestController
public class CadastroAutorController {

	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	public ResponseEntity<AutorDTO> cadastrar(@RequestBody @Valid AutorDTO dto) {
		Autor autor = dto.ConverterParaEntidade();
		autorRepository.save(autor);

		return ResponseEntity.ok().build();

	}

}
