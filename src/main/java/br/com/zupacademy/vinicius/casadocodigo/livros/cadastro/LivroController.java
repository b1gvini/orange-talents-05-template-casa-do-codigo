package br.com.zupacademy.vinicius.casadocodigo.livros.cadastro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vinicius.casadocodigo.autores.cadastroautor.AutorRepository;
import br.com.zupacademy.vinicius.casadocodigo.categorias.cadastro.CategoriaRepository;

@RequestMapping("/livros")
@RestController
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;


	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroDTO dto) {
		Livro livro = dto.converter(autorRepository, categoriaRepository);
		livroRepository.save(livro);
		return ResponseEntity.ok().build();

	}

}
