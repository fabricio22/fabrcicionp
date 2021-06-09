package br.com.fabricionp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fabricionp.domain.Categoria;
import br.com.fabricionp.repositories.CategoriaRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Inform�tica");
		Categoria cat2 = new Categoria(null, "Escrit�rio");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}
}
