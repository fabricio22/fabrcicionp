package br.com.fabricionp.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricionp.domain.Categoria;
import br.com.fabricionp.repositories.CategoriaRepository;
import br.com.fabricionp.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Categoria buscar(Integer id) throws Exception {
		Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);

		if (!optionalCategoria.isPresent()) {
			throw new Exception("Categoria não localizada com o id " + id + " informado!");
		}

		return optionalCategoria.get();
	}

}
