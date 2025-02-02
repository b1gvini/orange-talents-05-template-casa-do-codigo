package br.com.zupacademy.vinicius.casadocodigo.livro.listar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vinicius.casadocodigo.livro.Livro;
import br.com.zupacademy.vinicius.casadocodigo.livro.LivroRepository;

@RestController
@RequestMapping("/listar")
public class LivroListarController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping
	public ResponseEntity<List<ListarLivroDTO>> listar() {
		List<Livro> lista = livroRepository.findAll();
		if (lista.isEmpty()){
			return ResponseEntity.ok().build();
		}
		List<ListarLivroDTO> listaDTO = new ArrayList<>();

		lista.forEach(livro -> {
			listaDTO.add(new ListarLivroDTO(livro.getId(), livro.getTitulo()));
		});
		return ResponseEntity.ok(listaDTO);

	}
}
