package br.com.zupacademy.vinicius.casadocodigo.livro.cadastro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vinicius.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.vinicius.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.vinicius.casadocodigo.livro.Livro;
import br.com.zupacademy.vinicius.casadocodigo.livro.LivroRepository;

@RequestMapping("/livros")
@RestController
public class CadastroLivroController {

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;


	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastroLivroDTO dto) {
		Livro livro = dto.converter(autorRepository, categoriaRepository);
		livroRepository.save(livro);
		return ResponseEntity.ok().build();

	}

}
