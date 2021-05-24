package br.com.zupacademy.vinicius.casadocodigo.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vinicius.casadocodigo.estadoepais.EstadoRepository;
import br.com.zupacademy.vinicius.casadocodigo.estadoepais.PaisRepository;
import br.com.zupacademy.vinicius.casadocodigo.validacao.ExisteEstadoNestePaisValidator;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ExisteEstadoNestePaisValidator validator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
	@Autowired 
	private ClienteRepository clienteRepository;
	
	@Autowired 
	private EstadoRepository estadoRepository;
	@Autowired 
	private PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteDTO dto){
		Cliente cliente = dto.converter(paisRepository, estadoRepository);
		clienteRepository.save(cliente);
		ResponseClienteDTO response = cliente.converterParaDTO();
		return ResponseEntity.ok(response);
	}

}
