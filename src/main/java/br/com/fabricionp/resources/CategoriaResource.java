package br.com.fabricionp.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricionp.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@GetMapping
	public List<Categoria> listar() {

		Categoria categoria = new Categoria(1, "Informática");
		Categoria categoria2 = new Categoria(2, "Escritório");

		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		listaCategoria.add(categoria);
		listaCategoria.add(categoria2);
		
		return listaCategoria;
	}
}
