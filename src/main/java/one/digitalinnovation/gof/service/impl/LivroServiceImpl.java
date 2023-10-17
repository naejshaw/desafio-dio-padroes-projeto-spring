package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Livro;
import one.digitalinnovation.gof.model.LivroRepository;
import one.digitalinnovation.gof.service.GeneroService;
import one.digitalinnovation.gof.service.LivroService;
import one.digitalinnovation.gof.model.Autor;
import one.digitalinnovation.gof.model.AutorRepository;


@Service
public class LivroServiceImpl implements LivroService {
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private GeneroService generoService;

	@Override
	public Iterable<Livro> buscarTodos() {
		return livroRepository.findAll();
	}

	@Override
	public Livro buscarPorId(Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.get();
	}

	@Override
	public void inserir(Livro livro) {
		salvarLivroComGenero(livro);
	}

	@Override
	public void atualizar(Long id, Livro livro) {
		Optional<Livro> livroBd = livroRepository.findById(id);
		if (livroBd.isPresent()) {
			salvarLivroComGenero(livro);
		}
	}

	@Override
	public void deletar(Long id) {
		livroRepository.deleteById(id);
	}

	private void salvarLivroComGenero(Livro livro) {
		String genero = livro.getAutor().getGenero();
		Autor autor = autorRepository.findById(genero).orElseGet(() -> {
			Autor novoAutor = generoService.consultarGenero(genero);
			autorRepository.save(novoAutor);
			return novoAutor;
		});
		livro.setAutor(autor);
		livroRepository.save(livro);
	}

}
