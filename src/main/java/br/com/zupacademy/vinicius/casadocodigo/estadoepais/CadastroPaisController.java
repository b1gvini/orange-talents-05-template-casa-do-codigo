package br.com.zupacademy.vinicius.casadocodigo.estadoepais;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class CadastroPaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	
	@PostMapping
	public ResponseEntity<PaisDTO> cadastrar(@RequestBody @Valid PaisDTO dto) {
		Pais pais = dto.converter();
		paisRepository.save(pais);
		
		return ResponseEntity.ok().build();
		
	}

}
