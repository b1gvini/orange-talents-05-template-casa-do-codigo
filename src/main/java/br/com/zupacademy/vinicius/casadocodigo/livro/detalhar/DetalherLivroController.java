package br.com.zupacademy.vinicius.casadocodigo.livro.detalhar;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vinicius.casadocodigo.livro.Livro;
import br.com.zupacademy.vinicius.casadocodigo.livro.LivroRepository;

@RestController
@RequestMapping("/detalhar")
public class DetalherLivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping("/{id}")
	public ResponseEntity<?> detalhar(@PathVariable Long id) {
		
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new DetalharLivroDTO(livro.get()));
		}
		return ResponseEntity.notFound().build();

	}

}
