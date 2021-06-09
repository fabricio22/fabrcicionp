package br.com.fabricionp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricionp.domain.Endereco;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
